

<template>
  <div>
    <h1>Select组件使用</h1>
    <el-select v-model="cityName" >
      <el-option label="Option 1" value="1"></el-option>
      <el-option label="Option 2" value="2"></el-option>
    </el-select>
    <br>
    <h1>使用远程数据</h1>
    <el-select ref="select" v-model="cityId" multiple clearable @change="aa">
      <el-option v-for="option in options"  :label="option.name" :value="option.id" :key="option.id" ></el-option>
    </el-select>

    <el-button @click="bb">测试方法</el-button>
  </div>
</template>

<script>
export default {
  name: "Select",
  data(){
    return{
      options: [
        {id: 1, name: '研发部'},
        {id: 2, name: '产品部'},
        {id: 3, name: '测试部'},
        {id: 4, name: '运营部'},
      ],
      cityId: '',
      cityName:''
    }
  },
  methods:{
    aa(name){
      console.log(name)
    },
    bb(){
      this.$refs.select.focus();
    }
  }

}
</script>

<style scoped>

</style>
