<script>
export default {
  name: "Radio",
  data() {
    return{
      label: "男",
      radio: 3,

    }
  },
  methods: {
    aa() {
      alert(this.radio)
    }
  }

}
</script>

<template>
  <div>
    <h1>Radio</h1>
    <el-radio v-model="label" @change="aa" name="sex" label="男">男</el-radio>
    <el-radio v-model="label" @change="aa" name="sex" border size="mini" label="女">女</el-radio>
    <h1>单选按钮组</h1>
    <el-radio-group v-model="radio" fill="#20a0ff" text-color="#eeee" @change="aa">
      <el-radio-button :label="3" border>备选项</el-radio-button>
      <el-radio-button :label="6" border>备选项</el-radio-button>
      <el-radio-button :label="9" border>备选项</el-radio-button>
    </el-radio-group>
  </div>
</template>

<style scoped>

</style>
