import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
  //用来定义组件共享的数据
  state:{
    counter:0,
  },
  mutations:{
    increment(state,count){
      state.counter+=count;
    },
    decrement(state){
      state.counter--;
    }
  },
  //类似于computed，用来处理state的变化，但是只读
  getters:{
    countSqrt(state){
      return state.counter*state.counter;
    }
  }
});
