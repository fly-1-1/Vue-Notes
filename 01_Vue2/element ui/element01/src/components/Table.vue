

<template>
  <div>
    <el-table :data="tableData.filter(data => !search || data.name.toLowerCase().includes(search.toLowerCase()))" @select="selectRow" border :height="600" stripe :fit="true" empty-text="暂无数据" ref="table">
      <el-table-column type="selection"></el-table-column>
      <el-table-column  header-align="left"  prop="id" label="ID" width="100"></el-table-column>
      <el-table-column  prop="name" label="Name" width="180"></el-table-column>
      <el-table-column  :sort-method="sorts"  prop="age" label="Age" width="180"></el-table-column>
      <el-table-column  prop="email" label="Email" width="300"></el-table-column>
      <el-table-column  :formatter="showDept" prop="dept.name" label="部门"></el-table-column>
      <el-table-column>
        <template slot="header" slot-scope="scope">
          <el-input
            v-model="search"
            size="medium"
            placeholder="输入关键字搜索"/>
        </template>
        <template slot-scope="scope">
          <el-button
            size="medium"
            @click="handleEdit(scope.$index, scope.row)">编辑</el-button>
          <el-button
            size="medium"
            type="danger"
            @click="handleDelete(scope.$index, scope.row)">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    <el-button @click="clearSelect">清空选择</el-button>
  </div>
</template>
<script>
export default {
  name: "Table",
  data(){
    return{
      tableData: [
        { id:21,name:"小明",age:20,email:"23232@qq.com",
        dept:{id:1,name:"部门1"}},
        { id:22,name:"小红",age:21,email:"23232@qq.com" ,
        dept:{id:2,name:"部门2"}},
        { id:23,name:"小刚",age:22,email:"23232@qq.com" ,
        dept:{id:3,name:"部门3"}},
        {id:24,name:"小李",age:23,email:"23232@qq.com" ,
        dept:{}}
      ],
      search:""
    }
  },
  methods: {
    sorts(a, b) {
      return b.age - a.age; //>0 升序，<0 降序
    },
    showDept(row, column, cellValue, index) {
      if (cellValue) {
        return cellValue;
      }else{
        return "暂无部门";
      }
    },
    selectRow(selection, row){
      console.log(selection)
      console.log(row)
    },
    clearSelect(){
      this.$refs.table.clearSelection()
    },
    handleEdit(index, row){
      console.log(index)
      console.log(row)
    },
    handleDelete(index, row){
      console.log(index)
      console.log(row)
    }
  }
}
</script>
<style scoped>

</style>
