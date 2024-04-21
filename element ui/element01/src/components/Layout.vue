
<template>
  <div>
    <div><h1>Layout</h1></div>
    <div>
      <el-row>
        <el-col :span="6"><div style="border: 1px solid">占用6份</div></el-col>
        <el-col :span="6"><div style="border: 1px solid">占用6份</div></el-col>
        <el-col :span="6"><div style="border: 1px solid">占用6份</div></el-col>
        <el-col :span="6"><div style="border: 1px solid">占用6份</div></el-col>
      </el-row>
    </div>
    <br>

      <el-row :gutter="10" tag="span">
        <el-col :span="3"><div style="border: 1px solid">占用3份</div></el-col>
        <el-col :span="9"><div style="border: 1px solid">占用9份</div></el-col>
        <el-col :span="2"><div style="border: 1px solid">占用2份</div></el-col>
        <el-col :span="10"><div style="border: 1px solid">占用10份</div></el-col>
      </el-row>
    <br>

    <h1>偏移</h1>
    <el-row >
      <el-col offset="3" :push="3" :span="12"><div style="border: 1px solid aqua">占用12份</div></el-col>
      <el-col :span="6"><div style="border: 1px solid">占用6份</div></el-col>
    </el-row>

  </div>
</template>
<script>
export default {
  name: "Layout"
}
</script>
<style scoped>

</style>
