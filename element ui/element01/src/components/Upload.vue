<script>
export default {
  name: "Upload",
  data(){
    return {
      fileList: [{name: 'food.jpeg', url: 'https://fuss10.elemecdn.com/3/63/4e7f3a15429bfda99bce42a18cdd1jpeg.jpeg?imageMogr2/thumbnail/360x360/format/webp/quality/100'}, {name: 'food2.jpeg', url: 'https://fuss10.elemecdn.com/3/63/4e7f3a15429bfda99bce42a18cdd1jpeg.jpeg?imageMogr2/thumbnail/360x360/format/webp/quality/100'}],
      info:{
        id:2
      }
    };
  },
  methods: {
    show(file){
      console.log(file);
    },
    remove(file, fileList){
      console.log(file, fileList);
      //alert(fileList.length);
    },
    beforeRemove(file, fileList){
      if(fileList.length <= 3){
        alert("上传文件不能少于3个");
        return false
      }
    },
    clearFile(){
      this.$refs.uploads.clearFiles();
    }
  }
}
</script>

<template>
  <div>
    <el-upload
    action="https://jsonplaceholder.typicode.com/posts/"
    :file-list="fileList"
    multiple
    :data="info"
    :drag="true"
    accept=".txt"
    :on-preview="show"
    :on-remove="remove"
    :before-remove="beforeRemove"
    ref="uploads"
    >
      <i class="el-icon-upload"></i>
      <div class="el-upload__text">将文件拖到此处，或<em>点击上传</em></div>
      <div class="el-upload__tip" slot="tip">只能上传jpg/png文件，且不超过500kb</div>
    </el-upload>

    <el-button @click="clearFile">清空文件列表</el-button>
  </div>
</template>

<style scoped>

</style>
