

<template>
  <div>
    <h1>员工列表</h1>
    <input type="button" value="新增员工" @click="addEmp" />
    <table border="1" width="100%">
      <tr class="aa">
        <th>编号</th>
        <th>姓名</th>
        <th>年龄</th>
        <th>工资</th>
        <th>操作</th>
      </tr>
      <tr v-for="(v,i) in emps" :key="i">
        <td>{{v.id}}</td>
        <td>{{v.name}}</td>
        <td>{{v.age}}</td>
        <td>{{v.salary}}</td>
        <td><a href="#">删除</a> <a href="#">编辑</a></td>
      </tr>
    </table>

    <form action="" >
      <input type="text"  placeholder="编号"> <br>
      <input type="text"  placeholder="姓名"> <br>
      <input type="text"  placeholder="年龄"> <br>
      <input type="text"  placeholder="工资"> <br>
      <input type="button" value="保存" @click="saveEmp" />
    </form>
  </div>
</template>
<script >

  import instance from "../../utils/request";

  export default {
    data(){
      return{
        emps:{},
      }
    },
    methods:{
      saveEmp(){
        instance.post("/users")
      }
    },
    created(){
      instance.get("/users")
    }
  }
</script>
<style scoped>
    .aa{
        background-color: #adeeec;
    }
</style>
