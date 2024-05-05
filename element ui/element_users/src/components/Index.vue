

<template>

     <div>
       <el-carousel indicator-position="outside" height="500px">
         <el-carousel-item v-for="(img,index) in imgs" :key="index">
          <el-image
           :src="img"
           >
          </el-image>
         </el-carousel-item>
       </el-carousel>
     </div>

</template>
<script>
import homeImg from "../assets/imgs/1.png";
import homeImg2 from "../assets/imgs/2.png";

export default {
  name: "Index",
  data(){
    return{
      imgs:[homeImg,homeImg2]
    }
  }

}
</script>
<style scoped>

</style>
