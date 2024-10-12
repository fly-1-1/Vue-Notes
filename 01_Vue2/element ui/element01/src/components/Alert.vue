<script>
export default {
  name: "Alert",
  methods: {
    close() {
      alert("close alert")
    },
    showMessage() {
      const h = this.$createElement;
      this.$message({
        message: h('p', null, [
          h('span', null, '订单创建成功,订单编号为:'),
          h('a', { style: 'color: teal' }, '86')
        ]),
        showClose: true,
        iconClass: 'el-icon-star-on',
        offset:20
      });
    }
  }
}
</script>

<template>
  <div>
    <h1>Alert</h1>
    <el-alert type="success" title="Success Text" closable center show-icon effect="dark" @close="close">
      <div slot>
        我是辅助信息
      </div>
    </el-alert>
    <h1>Message</h1>
    <el-button type="primary" @click="showMessage">Click me to show message</el-button>
  </div>
</template>

<style scoped>

</style>
