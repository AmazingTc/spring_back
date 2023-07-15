//动态路由
export function fnAddDynamicMenuRoutes(menuList=[],routes=[]){
    let temp=[] //不具有子路由
    let route=[] //具有子路由
    for(let i=0;i<menuList.length;i++){
        if(menuList[i].children&&menuList[i].children.length > 0){
            //基本路由
            route=getRoute(menuList[i])
            //递归处理子路由，作为路由的children保存
            route.children=fnAddDynamicMenuRoutes(menuList[i].children)
            routes.push(route)
        }else{
            //不具有子路由的直接添加
            temp.push(getRoute(menuList[i]))
        }
    }
    //合并路由
    return routes.concat(temp)
}
//封装路由的基本结构
function getRoute(item){
    return {
        path: item.path,
        name: item.name,
        component: (resolve) => require([`@/view/${item.url}`], resolve),
        meta: {
            icon: item.icon
        },
        children: []
    }
}