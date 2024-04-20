

<template>
  <div>
    <h3>{{msg}} --{{this.$store.state.counter}} --{{$store.state.counter}} --{{$store.getters.countSqrt}}</h3>
    <button @click="incr">修改共享数据</button>
    <button @click="decr">修改共享数据</button>
  </div>
</template>

<script>
export default {
  data(){
    return{
      msg:"部门管理"
    }
  },
  methods:{
    incr(){
      this.$store.commit('increment',10)
    },
    decr(){
      this.$store.commit('decrement')
    }
  }

}

</script>

<style scoped>

</style>
