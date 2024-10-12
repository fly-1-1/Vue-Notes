import axios from 'axios'; //引入
//创建默认实例


const instance = axios.create({
    baseURL: 'http://localhost:8081', //请求的基础路径
    timeout: 5000 //超时时间
});

instance.interceptors.request.use(config => {
  console.log("请求拦截器");
  return config;
})


instance.interceptors.response.use(response => {
  console.log("响应拦截器");
  return response;
})


//暴露出去
export default instance;
