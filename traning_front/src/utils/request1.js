import axios from "axios";
const api=axios.create({
    // baseURL:'http://www.menglin.pro',
    baseURL:'http://localhost:9801',
    timeout:10000,
})
//请求拦截器
api.interceptors.request.use(config=>{
    return config
},error => {
    return Promise.reject(error)
})
//响应拦截器
api.interceptors.response.use(response=>{
    return response
},error => {
    return Promise.reject(error)
})
export default api