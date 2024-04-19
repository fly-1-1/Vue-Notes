<script setup>

</script>

<template>
  <div>
    <h1>Welcome to EMS 欢迎:XXX</h1>
    <router-link :to="{ name: 'Login' }">登录</router-link>
    <a>退出登录</a>
    <h2>欢迎进入首页</h2>
    <a href="#/index/emps">员工管理</a>
    <a href="#/index/depts">部门管理</a>
    <a href="">用户管理</a>
    <a href="">订单管理</a>

    <router-view></router-view>
  </div>
</template>

<style scoped>

</style>
