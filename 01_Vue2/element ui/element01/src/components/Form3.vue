

<template>
  <div>
    <el-form hide-required-asterisk :model="rform2" :rules="rules" ref="rform2">
      <el-form-item label="Username" prop="username">
        <el-input v-model="rform2.username"></el-input>
      </el-form-item>
    </el-form>
  </div>
</template>
<script>
export default {
  name: "Form3",
  data(){
    let validatePass = (rule, value, callback) => {
      if (value === "123") {
        callback(new Error('Please input your password!'));
      }
    };

    return{
      rform2: {
        username: ''
      },
      rules: {
        username: [
          { validator: validatePass, trigger: 'blur' }
        ]
      },
    }

  }
}
</script>
<style scoped>

</style>
