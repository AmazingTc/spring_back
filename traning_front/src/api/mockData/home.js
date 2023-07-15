// 图表数据
import Mock from 'mockjs'
let List = []
export default {
    getStatisticalData: () => {
        //Mock.Random.float 产生随机数100到8000之间 保留小数 最小0位 最大0位
        for (let i = 0; i < 7; i++) {
            List.push(
                Mock.mock({
                    企业文化课程: Mock.Random.float(100, 8000, 0, 0),
                    岗位层次课程: Mock.Random.float(100, 8000, 0, 0),
                    公司层次课程: Mock.Random.float(100, 8000, 0, 0),
                    销售态度课程: Mock.Random.float(100, 8000, 0, 0),
                    中层管理课程: Mock.Random.float(100, 8000, 0, 0),
                    产品信息课程: Mock.Random.float(100, 8000, 0, 0)
                })
            )
        }
        return {
            code: 2000,
            data: {
                // 饼图
                videoData: [
                    {
                        name: '小米',
                        value: 2999
                    },
                    {
                        name: '苹果',
                        value: 5999
                    },
                    {
                        name: 'vivo',
                        value: 1500
                    },
                    {
                        name: 'oppo',
                        value: 1999
                    },
                    {
                        name: '魅族',
                        value: 2200
                    },
                    {
                        name: '三星',
                        value: 4500
                    }
                ],
                // 柱状图
                userData: [
                    {
                        date: '周一',
                        new: 5,
                        active: 200
                    },
                    {
                        date: '周二',
                        new: 10,
                        active: 500
                    },
                    {
                        date: '周三',
                        new: 12,
                        active: 550
                    },
                    {
                        date: '周四',
                        new: 60,
                        active: 800
                    },
                    {
                        date: '周五',
                        new: 65,
                        active: 550
                    },
                    {
                        date: '周六',
                        new: 53,
                        active: 770
                    },
                    {
                        date: '周日',
                        new: 33,
                        active: 170
                    }
                ],
                // 折线图
                orderData: {
                    date: ['20191001', '20191002', '20191003', '20191004', '20191005', '20191006', '20191007'],
                    data: List
                },
                tableData: [
                    {
                        name: '企业文化课程',
                        todayBuy: 1,
                        monthBuy: 35,
                        totalBuy: '40%'
                    },
                    {
                        name: '岗位层次课程',
                        todayBuy: 2,
                        monthBuy: 22,
                        totalBuy: '50%'
                    },
                    {
                        name: '公司层次课程',
                        todayBuy: 3,
                        monthBuy: 45,
                        totalBuy: '30%'
                    },
                    {
                        name: '销售态度课程',
                        todayBuy: 4,
                        monthBuy: 4,
                        totalBuy: '20%'
                    },
                    {
                        name: '产品信息课程',
                        todayBuy: 5,
                        monthBuy: 12,
                        totalBuy: '50%'
                    },
                    {
                        name: '产品信息课程',
                        todayBuy: 0,
                        monthBuy: 31,
                        totalBuy: '40%'
                    }
                ]
            }
        }
    }
}