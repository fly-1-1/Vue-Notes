<script>
export default {
  name: "DatePicker",
  data() {
    return {
      pickerOptions: {
        disabledDate(time) {
          return time.getTime() > Date.now();
        },
        shortcuts: [{
          text: '今天',
          onClick(picker) {
            picker.$emit('pick', new Date());
          }
        }, {
          text: '昨天',
          onClick(picker) {
            const date = new Date();
            date.setTime(date.getTime() - 3600 * 1000 * 24);
            picker.$emit('pick', date);
          }
        }, {
          text: '一周前',
          onClick(picker) {
            const date = new Date();
            date.setTime(date.getTime() - 3600 * 1000 * 24 * 7);
            picker.$emit('pick', date);
          }
        }]
      },
      value1: '',
      value2: '',
      createDate: '',
      createDate1: ''
    };
  },
  methods: {
    aa(val) {
      console.log(val);
    }
  }

}
</script>

<template>
  <div>
    <el-date-picker
      v-model="createDate"
      type="daterange"
      start-placeholder="Start date"
      end-placeholder="End date"
      format="yyyy/MM/dd"
    ></el-date-picker>
    <br>
    <el-date-picker
      v-model="createDate1"
      tyoe="date"
      placeholder="Select date"
      format="yyyy/MM/dd"
      :picker-options="pickerOptions"
      @change="aa"
    >

    </el-date-picker>
  </div>
</template>

<style scoped>

</style>
