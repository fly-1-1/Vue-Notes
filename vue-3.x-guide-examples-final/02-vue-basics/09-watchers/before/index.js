// 示例：使用 watch 监听数据变化
const app = Vue.createApp({
  data() {
    return {
      showAnswer: false,
    };
  },
  computed: {
    label() {
      return this.showAnswer ? "隐藏答案 " : "显示答案";
    },
  },
  methods: {
    toggleAnswer() {
      this.showAnswer = !this.showAnswer;
    },
  },
});
app.mount("#app");
