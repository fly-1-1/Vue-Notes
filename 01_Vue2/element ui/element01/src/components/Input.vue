<script >
  export default {
    data(){
      return{
        name:"zs",

      }
    },
    methods: {
      aa(){
        console.log(this.name)
      },
      focus(){
        this.$refs.inputs.focus()
      },
      blur(){
        this.$refs.inputs.blur()
      }
    }
  }
</script>

<template>
  <div>
    <el-input v-model="name" placeholder="请输入内容" ></el-input>
    <el-input v-model="name" placeholder="请输入内容" type="textarea" ></el-input>
    <el-input v-model="name" placeholder="请输入内容" show-word-limit  maxlength="10"></el-input>
    <el-input v-model="name" placeholder="请输入内容" clearable></el-input>
    <el-input prefix-icon="el-icon-lock" suffix-icon="el-icon-close" v-model="name" placeholder="请输入密码" clearable type="password" show-password></el-input>

    <h1>事件</h1>
    <el-input v-model="name" placeholder="请输入内容" @blur="aa" ></el-input>

    <h1>方法</h1>
    <el-input v-model="name" ref="inputs" ></el-input>
    <el-button @click="focus">聚焦</el-button>
    <el-button @click="blur">失焦</el-button>


  </div>
</template>

<style scoped>

</style>
