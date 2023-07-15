import axios from "axios";
import requestConfig from "@/utils/requestConfig";

const http=axios.create(requestConfig)
//请求拦截器
http.interceptors.request.use(config=>{
    return config
},error => {
    return Promise.reject(error)
})
//响应拦截器
http.interceptors.response.use(response=>{
    return response
},error => {
    return Promise.reject(error)
})


export default http