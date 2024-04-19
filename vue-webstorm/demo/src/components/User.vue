<template>
  <div>
    <h3>{{msg}}</h3>
    <button>添加</button>
    <table border="1" width="100%">
      <tr  class="aa">
        <th>编号</th>
        <th>姓名</th>
        <th>年龄</th>
        <th>工资</th>
        <th>操作</th>
      </tr>
      <tr v-for="(v,i) in users" :key="i">
        <td>{{v.id}}</td>
        <td>{{v.name}}</td>
        <td>{{v.age}}</td>
        <td>{{v.salary}}</td>
        <td><a href="#" @click.prevent="editUser(v.id)">编辑</a> | <a href="#">删除</a></td>
      </tr>
    </table>

    <form action="">
      <div v-show="user.id">
        <input type="text" placeholder="编号" v-model="user.id">
      </div>
      <input type="text" placeholder="姓名" v-model="user.name">
      <input type="text" placeholder="年龄" v-model="user.age">
      <input type="text" placeholder="工资" v-model="user.salary">
      <input type="submit" @click.prevent="addUser" value="添加">
    </form>

  </div>



</template>

<script>

//导入axios

import axios from 'axios'

export default{
  name: 'User',
  data(){
    return{
      msg:'用户管理',
      users:[],
      user:{}
    }
  },
  methods:{
    editUser(id){

    }
  },
  created(){
    this.users=[
      {id:1,name:'张三',age:25,salary:5000},
      {id:2,name:'李四',age:30,salary:6000}

    ]
   /*axios.get("http://localhost:8080/users").then(res=>{

   }).catch(err=>{

   })*/
  }
}


</script>

<style scoped>
    .aa{
    background-color: #f2f2f2
    }
</style>
