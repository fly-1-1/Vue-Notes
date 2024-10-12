

<template>
  <div>
    <el-switch ref="sw" @change="aa" v-model="value" active-color="#13ce66" inactive-color="#F56C6C" :width="60" active-text="打开" inactive-text="关闭"></el-switch>
    <el-button @click="bb">方法</el-button>
  </div>
</template>

<script >
  export default {
    name: 'Switch',
    data(){
      return{
        value: false
      }
    },
    methods: {
      aa(value){
        console.log(value)
      },
      bb(){
        this.$refs.sw.focus()
      }
    }
  }
</script>

<style scoped>

</style>
