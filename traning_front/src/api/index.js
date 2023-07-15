import http from "@/utils/request";//mock
import api from '@/utils/request1'//服务器
export const getMenu=(params)=>{
   return http.post('/permission/getMenu',params)
}
//请求首页数据
export const getData=(url,config)=>{
    //返回一个Promise对象
    return http.get('/home/getData')
}
//添加用户
export const addUser=(data)=>{
    return http.post('/user/add',data)
}
//用户列表
export const getUserList=(conf)=>{
    return http.get('/user/getUserList',conf)
}
//删除用户
export const deleteUser=(data)=>{
    return http.post('/user/delete',data)
}
//更新用户信息
export const updateUser=(data)=>{
    return http.post('/user/update',data)
}


//获取所有培训信息
export const getTraning=()=>{
    return api.get('/getAllTraning')
}

//删除
export const deleteTraning=(params)=>{
    return api.delete('/deleteTraning',params)
}
//更新
export const updateTraning=(data)=>{
    return api.post('/updateTraning',data)
}
// 添加
export const addTraning=(data)=>{
    return api.post('/addTraning',data)
}

export const getTranById=(data)=>{
    return api.post('/getTranById',data)
}





//获取所有员工信息
export const getEmployee=()=>{
    return api.get('/getAllEmployee')
}

//删除
export const deleteEmployee=(params)=>{
    return api.delete('/deleteEmployee',params)
}
//更新
export const updateEmployee=(data)=>{
    return api.put('/updateEmployee',data)
}
// 添加
export const addEmployee=(data)=>{
    return api.post('/addEmployee',data)
}

export const getEmployeeComplete=(data)=>{
    return api.post('/complete',data)
}

export const updateComplete=(data)=>{
    return api.post('/updateComplete',data)
}













// 根据ID获取图书详情
export const getDetailById=id=>{
    return http.get('/book/getDetail',id)
}
//删除
export const deleteBook=(params)=>{
    return api.delete('/bookList',params)
}
// 添加
export const addBook=(data)=>{
    return api.post('/bookList',data)
}
//登录
export const userLogin=(data)=>{
    return api.post('/userLogin',data)
}
//更新
export  const updateBook=data=>{
    return api.put('/bookList',data)
}
export const sendAppraise=data=>{
    return api.post('/comments',data)
}
export const getAppraise=(data)=>{
    return api.get('/comments',data)
}