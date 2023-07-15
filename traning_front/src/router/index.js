import Vue from "vue";
import VueRouter from "vue-router";
import Login from "@/views/Login";
import Main from "@/views/Main";
import Cookie from "js-cookie";
//重写push和replace方法 改变this指向(防止点击同一路由报错)
const originaPush = VueRouter.prototype.push;
const originaReplace = VueRouter.prototype.replace;

VueRouter.prototype.push = function push(location) {
    return originaPush.call(this, location).catch(err => err)
}
VueRouter.prototype.replace = function replace(location) {
    return originaReplace.call(this, location).catch(err => err)
}
Vue.use(VueRouter)
const routes = [
    {
        path: '/',
        name:'main',
        component: Main,
        redirect:'home',
        children: []
    },
    {
        path:'/login',
        name:'login',
        component: Login,
    }
]

const router = new VueRouter({
    routes,
    mode: 'history'
})
// 导航守卫
router.beforeEach((to, from, next) => {
    const token=Cookie.get('token')
    if(!token&&to.name!=='login'){
        //用户未登录跳转到登录页
        next({name:'login'})
    }else if(token&&to.name==='login'){
        //token存在 已登录 跳转至首页
        next({name:'home'})
    }else{
        next()
    }
})
export default router