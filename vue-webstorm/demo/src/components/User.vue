<template>
  <div>
    <h3>{{msg}}</h3>
    <table>
      <tr>
        <th>编号</th>
        <th>姓名</th>
        <th>年龄</th>
        <th>工资</th>
        <th>操作</th>
      </tr>
    </table>
  </div>



</template>

<script>

export default{
  name: 'User',
  data(){
    return{
      msg:'用户管理'
    }
  },

}


</script>

<style >

</style>
