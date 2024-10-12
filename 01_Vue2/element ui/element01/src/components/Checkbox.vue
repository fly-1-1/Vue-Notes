<script >
  export default {
    name: 'Checkbox',
    data() {
      return {
        checked: "北京",
        checkList: []
      }
    },
    methods: {
      aa() {
        console.log(this.checkList)
      }
    }
  }
</script>

<template>
  <div>
    <el-checkbox v-model="checked" true-label="北京">北京</el-checkbox>
    <el-checkbox v-model="checked" true-label="上海">上海</el-checkbox>
    <el-checkbox v-model="checked" true-label="广州" @change="aa">广州</el-checkbox>
    <el-checkbox v-model="checked" true-label="深圳" @change="aa">深圳</el-checkbox>

    <el-checkbox-group :min=1 :max=2 v-model="checkList" @change="aa">
      <el-checkbox label="复选框 A"></el-checkbox>
      <el-checkbox label="复选框 B"></el-checkbox>
      <el-checkbox label="复选框 C"></el-checkbox>
      <el-checkbox label="禁用" disabled></el-checkbox>
      <el-checkbox label="选中且禁用" disabled></el-checkbox>
    </el-checkbox-group>
  </div>
</template>

<style scoped>

</style>
