<template>
  <div>
    <div><h1>创建简单按钮</h1></div>
    <el-button>默认按钮</el-button>

    <div><h1>使用按钮的属性</h1></div>
    <el-button type="primary" plain round size="mini" loading>primary</el-button>
    <el-button type="primary" plain round disabled>primary</el-button>
    <el-button type="primary" plain round size="medium" autofocus>primary</el-button>
    <el-button type="primary" size="medium" plain circle icon="el-icon-loading"></el-button>

    <div><h1>按钮组</h1></div>
    <el-button-group>
      <el-button type="primary" icon="el-icon-remove">上一页</el-button>
      <el-button type="primary" icon="el-icon-circle-plus">下一页</el-button>
    </el-button-group>

  </div>

</template>
<script>

</script>

<style scoped>

</style>
