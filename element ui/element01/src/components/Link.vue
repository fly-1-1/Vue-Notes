<template>
  <div>
    <div><h1>文字链接组件</h1></div>
    <div>
      <div>
        <el-link>默认链接</el-link>
        <el-link type="primary" :underline="false" href="https://www.baidu.com" target="_blank">默认链接</el-link>
        <el-link type="success" disabled>默认链接</el-link>
        <el-link type="warning" icon="el-icon-camera">默认链接</el-link>
        <el-link type="danger">默认链接</el-link>


      </div>
    </div>
  </div>
</template>

<script>
  export default {
    data(){
      return{

      }
    }
  }
</script>

<style scoped>

</style>
