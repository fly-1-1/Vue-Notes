
<template>
  <div>
    <h1>Login</h1>
    <form>
      <input type="text" placeholder="Username"><br>
      <input type="password" placeholder="Password"><br>
      <input type="submit" value="Login" @click="login">
    </form>
  </div>
</template>

<script>
  export default {
    methods:{
      login(){
        //发送请求，登录
        this.$router.push({name:'Index'})
      }
    }
  }
</script>


<style scoped>

</style>
