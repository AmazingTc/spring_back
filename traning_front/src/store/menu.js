// import {fnAddDynamicMenuRoutes} from '@/router/getAsyncRouter'
import router from '@/router/index'
export default {
    namespaced:true,
    actions:{},
    mutations:{
        //保存后台请求过来的菜单数据
        SETMENUDATA(state,data){
            [...state.menuData]=data
            const menu=localStorage.getItem('menu')
            if(menu){
                localStorage.removeItem('menu')
                localStorage.setItem('menu',JSON.stringify(data))
            }else{
                localStorage.setItem('menu',JSON.stringify(data))
            }
        },
        ADDROUTER(state,router){
            //判断缓存中是否有数据
            if(!localStorage.getItem('menu'))return
            // 封装动态路由
            // fnAddDynamicMenuRoutes()
            const menuArr=[]
            const menu=JSON.parse(localStorage.getItem('menu'))
            menu.forEach(item=>{
                if(item.children&&item.children.length>0){
                    let children=JSON.parse(JSON.stringify(item.children))
                    children.forEach(i=>{
                        i.component=()=>import(`../views/${i.url}`)
                        menuArr.push(i)
                    })
                }else{
                    item.component=()=>import(`../views/${item.url}`)
                    menuArr.push(item)
                }
            })
            //动态添加路由
            menuArr.forEach(item=>{
                router.addRoute('main',item)
            })

        },
        //菜单栏打开或折叠
        CHANGEOPEN(state){
            state.isOpen=!state.isOpen
        },
        //更新面包屑
        UPDATETABLELIST(state,value){
            //如果不存在 则添加
            if(!state.tableList.some(item=>item.name===value.name)){
                state.tableList.push(value)
            }
        },
        DELETETAG(state,value){
            const result= state.tableList.filter(item=>item.name!==value.name)
            state.tableList=result
        },

    },
    state:{
        isOpen:true,
        menuData:[],
        //面包屑
        tableList:[
            {
                path: '/home',
                name: 'home',
                label: '首页',
                icon: 's-home',
                url: 'Home.vue'
            }
        ]
    }
}