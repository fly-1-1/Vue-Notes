
<template>
  <div>
    <div class="container-fluid">
      <div class="row">
        <h1 class="text-center text-info">Welcome to EMS <span v-if="isLogin">欢迎:{{admin.username}}</span></h1>
      </div>
      <div class="col-sm-12">
        <div style="float: right">
          <router-link v-if="!isLogin" :to="{ name: 'Login' }">登录</router-link>
          <a v-if="isLogin" href="" @click.prevent="logout">退出登录</a>
        </div>
      </div>
    </div>
    <div class="clearfix"></div>
    <div style="text-align: center">
      <a href="#/index/emps">员工管理</a>
      <a href="#/index/depts">部门管理</a>
      <a href="">用户管理</a>
      <a href="">订单管理</a>
    </div>
  </div>
</template>


<script >
import instance from "../utils/request";

export default {
  name: 'Header',
  data(){
    return{
      admin:{}
    }
  },
  methods:{
    logout(){
      let token = localStorage.getItem("token")
      instance.delete("/token?token="+token).then(res=>{
        this.$router.push({ path: '/' })
        this.admin={}
      })
      localStorage.removeItem("token")
    }
  },
  computed:{
    isLogin(){
      return this.admin.username;
    }
  },
  created(){
    let token = localStorage.getItem("token")
    console.log(token)
    instance.get("/token?token="+token).then(res=>{
      this.admin = res.data
    })
  }
}
</script>


<style scoped>

</style>
