

<template>
  <div>
   <el-form hide-required-asterisk :model="rform" label-width="80px" label-position="right" :rules="rules" ref="rform">
     <el-form-item label="Name" prop="name">
       <el-input v-model="rform.name"></el-input>
     </el-form-item>
     <el-button type="primary" @click="submitForm('rform')"> Submit </el-button>
   </el-form>
  </div>
</template>

<script>
export default {
  data(){
    return{
      rform:{
        name:"",
      },
      rules:{
        name:[
          { required: true, message: 'Please enter your name', trigger: 'blur' },
          { min: 3, max: 5, message: 'Name length should be between 3 and 5', trigger: 'blur' }
        ]
      }
    }
  },
  methods:{
    submitForm(formName){
      this.$refs[formName].validate((valid) => {
        if (valid) {
          alert('submit success');
        } else {
          console.log('error submit form');
          return false;
        }
      })
    }
  }

}
</script>

<style scoped>

</style>
