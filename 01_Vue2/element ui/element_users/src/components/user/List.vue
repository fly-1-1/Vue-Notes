
<template>
  <div>
    <el-table
      :data="tableData.filter(data => !search || data.name.toLowerCase().includes(search.toLowerCase()))"
      style="width: 100%">
      <el-table-column
        label="编号"
      >
        <template slot-scope="scope">
          <span style="margin-left: 10px">{{ scope.row.id }}</span>
        </template>
      </el-table-column>
      <el-table-column
        label="姓名"
      >
        <template slot-scope="scope">
          <el-popover trigger="hover" placement="top">
            <p>姓名: {{ scope.row.name }}</p>
            <div slot="reference" class="name-wrapper">
              <el-tag size="medium">{{ scope.row.name }}</el-tag>
            </div>
          </el-popover>
        </template>
      </el-table-column>
      <el-table-column label="生日" prop="bir"></el-table-column>
      <el-table-column label="性别" prop="sex"></el-table-column>
      <el-table-column label="地址" prop="address"></el-table-column>
      <el-table-column align="center">
        <template slot="header" slot-scope="scope">
          <el-input
            v-model="search"
            size="mini"
            placeholder="输入关键字搜索"/>
        </template>
        <template slot-scope="scope">
          <el-button
            size="mini"
            @click="handleEdit(scope.$index, scope.row)">编辑
          </el-button>


          <el-popconfirm
            confirm-button-text='好的'
            cancel-button-text='不用了'
            icon="el-icon-warning"
            title="确定删除吗？"
            @confirm="handleDelete(scope.$index, scope.row)">

            <el-button size="mini"
                       type="danger"
                       slot="reference">删除
            </el-button>
          </el-popconfirm>


        </template>
      </el-table-column>
    </el-table>

    <el-row>
      <el-col :span="7" :offset="15">
        <el-pagination
          layout="prev, pager, next,jumper,total,sizes"
          :page-size="4"
          :page-sizes="[4, 8, 12, 20]"
          :total="pages.total"
          style="margin: 20px 0;"
          @current-change="findPage"
          @size-change="findSize"
          >
        </el-pagination>
      </el-col>
    </el-row>



    <el-button type="primary" size="mini" @click="showForm" style="margin: 10px 10px">添加用户</el-button>

    <transition name="el-zoom-in-center">
      <div v-show="show" class="transition-box">
        <el-form ref="userForm" :model="form" label-width="80px" label-suffix=":" :rules="rules"  hide-required-asterisk>
          <el-form-item label="编号" v-show="form.id" >
            <el-input v-model="form.id" disabled></el-input>
          </el-form-item>
          <el-form-item label="姓名" prop="name">
            <el-input v-model="form.name"></el-input>
          </el-form-item>
          <el-form-item label="生日" prop="bir">
            <el-date-picker type="date" placeholder="选择日期" v-model="form.bir" style="width: 100%;"></el-date-picker>
          </el-form-item>
          <el-form-item label="性别" prop="sex">
            <el-radio-group v-model="form.sex">
              <el-radio label="男"></el-radio>
              <el-radio label="女"></el-radio>
            </el-radio-group>
          </el-form-item>
          <el-form-item label="详细地址" prop="address">
            <el-input type="textarea" v-model="form.address"></el-input>
          </el-form-item>
          <el-form-item v-show="!form.id">
            <el-button type="primary" @click="onSubmit('userForm')">确定添加</el-button>
          </el-form-item>
          <el-form-item v-show="form.id">
            <el-button type="primary" @click="onEdit">确定修改</el-button>
          </el-form-item>
        </el-form>
      </div>
    </transition>

  </div>
</template>

<script>
import axios from "axios";

export default {
  name: "List",
  data() {
    return {
      tableData: [],
      search: '',
      show: false,
      form: {
        id: '',
        name: '',
        bir: '',
        sex: '',
        address: ''
      },
      pages:{
        start:'',
        rows:'',
        total:''
      },
      rules: {
        name:[
          { required: true, message: '请输入姓名', trigger: 'blur' },
          {min: 2, max: 10, message: '长度在 2 到 10 个字符', trigger: 'blur'}
        ],
        bir: [
          { required: true, message: '请选择生日', trigger: 'change' }
        ],
        sex: [
          { required: true, message: '请选择性别', trigger: 'change' }
        ],
        address: [
          { required: true, message: '请输入详细地址', trigger: 'blur' },
          {min: 5, max: 20, message: '长度在 5 到 20 个字符', trigger: 'blur'}
        ]
      }

    }
  },
  methods: {
    handleEdit(index, row) {
      this.show = true;
      this.form = row;
    },
    handleDelete(index, row) {
      axios.delete("http://localhost:8081/user/" + row.id).then(res => {
        if (res.data.status) {
          this.$message.success(res.data.msg);
          this.findAll();
        } else {
          this.$message.error(res.data.msg);
          this.findAll();
        }
      })
    },
    onSubmit(userForm) {
      this.$refs[userForm].validate((valid) => {
        if(valid){
          axios.post("http://localhost:8081/user/add", this.form).then(res => {
            if (res.data.status) {
              this.findAll();
              this.show = false;
              this.form = {};
              this.$message.success(res.data.msg);
            } else {
              this.$message.error(res.data.msg);
            }
          })
        }else{
          this.$message.error("请检查输入项是否正确");
          return false;
        }
      })
    },
    onEdit(){
      axios.put("http://localhost:8081/user/", this.form).then(res => {
        if (res.data.status) {
          this.findAll();
          this.show = false;
          this.form = {};
          this.$message.success(res.data.msg);
        } else {
          this.$message.error(res.data.msg);
        }
      })
    },
    findAll() {
     /* axios.get("http://localhost:8081/user/users").then(res => {
        this.tableData = res.data
      })*/
      this.findPage(1);
    },
    showForm() {
      this.show = !this.show;
      this.form = {}
    },
    findPage(page) {
      axios.get("http://localhost:8081/user/findPage?start="+page+"&rows="+this.pages.rows).then(res => {
        if(res.data.status){
          this.tableData = res.data.data;
          this.pages.total = res.data.total;
        }else{
          this.$message.error(res.data.msg);
        }
      })
    },
    findSize(size) {
      console.log(size);
    }
  },
  created() {
    this.findAll();
  }
}
</script>


<style scoped>
.transition-box {
  margin-bottom: 10px;
  width: 90%;
  height: 600px;
  border-radius: 4px;
  color: #e70c0c;
  padding: 40px 20px;
  box-sizing: border-box;
  margin-right: 20px;
}
</style>
