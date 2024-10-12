

<template>
  <div>


    <div class="container-fluid">
        <div class="col-md-12" style="margin-bottom: 10px;">
          <input type="button" class="btn btn-primary" value="新增员工"  @click="addEmp"/>
        </div>

      <div class="col-md-12">
        <table class="table table-bordered table-hover table-striped">
          <thead>
          <tr class="aa">
            <th>编号</th>
            <th>姓名</th>
            <th>年龄</th>
            <th>工资</th>
            <th>操作</th>
          </tr>
          </thead>
          <tbody>
          <tr v-for="(v,i) in users" :key="i">
            <td>{{v.id}}</td>
            <td>{{v.name}}</td>
            <td>{{v.age}}</td>
            <td>{{v.salary}}</td>
            <td>
              <a href="#" class="btn btn-danger btn-sm" @click.prevent="deleteEmp(v.id)" >删除</a>
              <a href="#" class="btn btn-success btn-sm" @click.prevent="findEmp(v.id)" >编辑</a>
            </td>
          </tr>
          </tbody>

        </table>
      </div>

      <div class="col-md-12">
        <form>

          <div class="form-group">
            <div v-if="user.id">
              <input type="text"  placeholder="编号" v-model:value="user.id"> <br>
            </div>
          </div>

          <div class="form-group">
            <input type="text" class="form-control" placeholder="姓名" v-model:value="user.name"> <br>
          </div>
          <div class="form-group">
            <input type="text" class="form-control" placeholder="年龄" v-model:value="user.age"> <br>
          </div>
          <div class="form-group">
            <input type="text" class="form-control" placeholder="工资" v-model:value="user.salary"> <br>
          </div>


          <br>
          <input type="button" class="btn btn-primary" value="保存|修改" @click="saveEmp" />
        </form>
      </div>
    </div>

    <br>

  </div>
</template>
<script >

  import instance from "../../utils/request";

  export default {
    data(){
      return{
        user:{},
        users:[]
      }
    },
    methods:{
      addEmp(){
        this.user = {};
      },
      saveEmp(){
        instance.post("/user",this.user).then(res=>{
          this.findAll();
        })
      },
      findEmp(id){
        instance.get("/user/"+id).then(res=>{
          this.user = res.data;
        })
      },
      findAll(){
        instance.get("/user").then(res=>{
          this.users = res.data;
        })
      },
      deleteEmp(id){
        instance.delete("/user/"+id).then(res=>{
          this.findAll();
        })
      }
    },
    created(){
      this.findAll();
    }
  }
</script>
<style scoped>
    .aa{
        background-color: #adeeec;
    }
</style>
