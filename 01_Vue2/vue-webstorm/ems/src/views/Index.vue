

<template>
  <div>


    <Header></Header>





    <router-view></router-view>
  </div>
</template>

<script >
 import instance from "../utils/request";
 import Header from "../components/Header.vue";

 export default {
   name:"Index",
   components: {Header},


 }
</script>

<style scoped>

</style>
