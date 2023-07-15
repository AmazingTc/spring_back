import Mock from 'mockjs'
export default {
    getMenu: config => {
        const { username, password } = JSON.parse(config.body)
        // 先判断用户是否存在
        // 判断账号和密码是否对应
        if (username === 'admin' && password === 'admin1') {
            return {
                code: 2000,
                data: {
                    menu: [
                        {
                            path: '/home',
                            name: 'home',
                            label: '首页',
                            icon: 's-home',
                            url: 'Home.vue'
                        },
                        {
                            path: '/mall',
                            name: 'mall',
                            label: '商品管理',
                            icon: 'video-play',
                            url: 'Mall.vue'
                        },
                        {
                            path: '/user',
                            name: 'user',
                            label: '客户管理',
                            icon: 'user',
                            url: 'User.vue'
                        },
                        {
                            path:'detail',
                            name:'detail',
                            label:'详情',
                            icon:'setting',
                            url:'Detail.vue',
                        },
                        {
                            label: '其他',
                            icon: 'location',
                            children: [
                                {
                                    path: '/page1',
                                    name: 'page1',
                                    label: '展台',
                                    icon: 'setting',
                                    url: 'PageOne.vue',
                                },
                                {
                                    path: '/page2',
                                    name: 'page2',
                                    label: '搜索详情',
                                    icon: 'setting',
                                    url: 'PageTwo.vue'
                                }
                            ]
                        }
                    ],
                    token: Mock.Random.guid(),
                    message: '获取成功'
                }
            }
        } else if (username === 'xiaoxiao' && password === 'xiaoxiao1') {
            return {
                code: 2000,
                data: {
                    menu: [
                        {
                            path: '/home',
                            name: 'home',
                            label: '首页',
                            icon: 's-home',
                            url: 'Home.vue'
                        },
                        {
                            path: '/page1',
                            name: 'page1',
                            label: '展台',
                            icon: 'setting',
                            url: 'PageOne.vue',
                        },
                        {
                            path:'detail',
                            name:'detail',
                            label:'详情',
                            icon:'setting',
                            url:'Detail.vue',
                        },
                    ],
                    token: Mock.Random.guid(),
                    message: '获取成功'
                }
            }
        } else {
            return {
                code: -999,
                data: {
                    message: '密码错误'
                }
            }
        }

    }
}