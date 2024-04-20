
<template>
  <div>
    <div class="container-fluid">
      <div class="col-sm-6 col-sm-offset-3" style="margin-top: 10%">
        <form>

          <div class="form-group">
            <label >Username:</label>
            <input type="text" class="form-control" placeholder="Username" v-model="admin.username"><br>
          </div>

          <div class="form-group">
            <label >Password:</label>
            <input type="password" class="form-control" placeholder="Password" v-model="admin.password"><br>
          </div>



          <input type="submit" value="Login" class="btn btn-primary btn-block" @click="login">
        </form>
      </div>
    </div>


  </div>
</template>

<script>
  import instance from "../utils/request";

  export default {
    data(){
       return{
         admin:{}
      }
    },
    methods:{
      login(){
        //发送请求，登录
        //console.log(this.admin)
        instance.post("/admin",this.admin).then(res=>{
         console.log(res.data)
          if(res.data.success){
            localStorage.setItem("token",res.data.token)
            this.$router.push({name:"Index"})
          }else{
            alert("用户名或密码错误")
          }
        })

      }
    }
  }
</script>


<style scoped>

</style>
