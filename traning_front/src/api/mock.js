import Mock from 'mockjs'
import homeData from "@/api/mockData/home";
import userData from '@/api/mockData/user'
import permission from "@/api/mockData/permission";
import bookList from "@/api/mockData/bookList";
//Mock拦截请求
Mock.mock(/api\/permission\/getMenu/,'post',permission.getMenu)
Mock.mock('/api/home/getData',homeData.getStatisticalData)
//用户列表
Mock.mock(/api\/user\/getUserList/,userData.getUserList)
Mock.mock('/api/user/add','post',userData.createUser)
Mock.mock('/api/user/delete','post',userData.deleteUser)
Mock.mock('/api/user/update','post',userData.updateUser)

Mock.mock(/api\/book\/getBookList/,bookList.getBookList)