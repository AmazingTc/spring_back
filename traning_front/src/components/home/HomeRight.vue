<template>
    <div class="right">
        <div class="count">
            <el-card v-for="item in countData"
                     :key="item.name"
                     :body-style="{display:'flex',height:'80px',justifyContent:'space-between',padding:0,alignItems:'center'}"
                     shadow="hover">
                <div :class="`el-icon-${item.icon} iconStyle`" :style="{background:item.color}"></div>
                <div class="countData">
                    <p>{{ item.value }}人</p>
                    <p style="color:#999;font-size: 14px">{{ item.name }}</p>
                </div>
            </el-card>
        </div>
        <div class="echarts">
            <el-card id="chart1">
            </el-card>
            <div class="bottom">
                <el-card id="chart2">
                </el-card>
                <el-card id="chart3">
                </el-card>
            </div>

        </div>
    </div>
</template>
<script>
import * as echarts from 'echarts'

export default {
    name: "HomeRight",
    props: ['orderData', 'userData', 'videoData'],
    data() {
        return {
            countData: [
                {
                    name: "昨日总完成",
                    value: 1,
                    icon: "success",
                    color: "#2ec7c9",
                },
                {
                    name: "今日总完成",
                    value: 1,
                    icon: "star-on",
                    color: "#ffb980",
                },
                {
                    name: "今日未完成",
                    value: 1,
                    icon: "s-goods",
                    color: "#5ab1ef",
                },
                {
                    name: "本月已完成",
                    value: 2,
                    icon: "success",
                    color: "#2ec7c9",
                },
                {
                    name: "本月未完成",
                    value: 3,
                    icon: "star-on",
                    color: "#ffb980",
                },
                {
                    name: "本月预计完成",
                    value: 20,
                    icon: "s-goods",
                    color: "#5ab1ef",
                },
            ],
            myChart1: null,
            myChart2: null,
            myChart3: null,
        }
    },
    watch: {
        orderData(newVal, oldVal) {
            this.initCharts()
        }
    },
    methods: {
        initCharts() {
            //折线图
            const chart1 = document.getElementById('chart1')
            const orderDatas = this.orderData['data']
            const lineX = Object.keys(orderDatas[0])
            const series1 = []
            lineX.forEach(name => {
                series1.push({
                    name,
                    type: 'line',
                    data: orderDatas.map(item => item[name])
                })
            })
            const option1 = {
                backgroundColor: '#98F0EE',
                color: ['#80FFA5', '#00DDFF', '#37A2FF', '#FF0087', '#FFBF00'],
                tooltip: {
                    trigger: 'axis',
                    axisPointer: {
                        type: 'cross',
                        label: {
                            backgroundColor: '#6a7985'
                        }
                    }
                },
                legend: {
                    data: ['企业文化课程', '岗位层次课程', '公司层次课程', '销售态度课程', '产品信息课程']
                },
                grid: {
                    left: '3%',
                    right: '4%',
                    bottom: '3%',
                    containLabel: true
                },
                xAxis: [
                    {
                        type: 'category',
                        boundaryGap: false,
                        data: ['Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat', 'Sun']
                    }
                ],
                yAxis: [
                    {
                        type: 'value'
                    }
                ],
                series: [
                    {
                        name: '企业文化课程',
                        type: 'line',
                        stack: 'Total',
                        smooth: true,
                        lineStyle: {
                            width: 0
                        },
                        showSymbol: false,
                        areaStyle: {
                            opacity: 0.8,
                            color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [
                                {
                                    offset: 0,
                                    color: 'rgb(128, 255, 165)'
                                },
                                {
                                    offset: 1,
                                    color: 'rgb(1, 191, 236)'
                                }
                            ])
                        },
                        emphasis: {
                            focus: 'series'
                        },
                        data: [140, 232, 101, 264, 90, 340, 250]
                    },
                    {
                        name: '岗位层次课程',
                        type: 'line',
                        stack: 'Total',
                        smooth: true,
                        lineStyle: {
                            width: 0
                        },
                        showSymbol: false,
                        areaStyle: {
                            opacity: 0.8,
                            color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [
                                {
                                    offset: 0,
                                    color: 'rgb(0, 221, 255)'
                                },
                                {
                                    offset: 1,
                                    color: 'rgb(77, 119, 255)'
                                }
                            ])
                        },
                        emphasis: {
                            focus: 'series'
                        },
                        data: [120, 282, 111, 234, 220, 340, 310]
                    },
                    {
                        name: '公司层次课程',
                        type: 'line',
                        stack: 'Total',
                        smooth: true,
                        lineStyle: {
                            width: 0
                        },
                        showSymbol: false,
                        areaStyle: {
                            opacity: 0.8,
                            color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [
                                {
                                    offset: 0,
                                    color: 'rgb(55, 162, 255)'
                                },
                                {
                                    offset: 1,
                                    color: 'rgb(116, 21, 219)'
                                }
                            ])
                        },
                        emphasis: {
                            focus: 'series'
                        },
                        data: [320, 132, 201, 334, 190, 130, 220]
                    },
                    {
                        name: '销售态度课程',
                        type: 'line',
                        stack: 'Total',
                        smooth: true,
                        lineStyle: {
                            width: 0
                        },
                        showSymbol: false,
                        areaStyle: {
                            opacity: 0.8,
                            color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [
                                {
                                    offset: 0,
                                    color: 'rgb(255, 0, 135)'
                                },
                                {
                                    offset: 1,
                                    color: 'rgb(135, 0, 157)'
                                }
                            ])
                        },
                        emphasis: {
                            focus: 'series'
                        },
                        data: [220, 402, 231, 134, 190, 230, 120]
                    },
                    {
                        name: '产品信息课程',
                        type: 'line',
                        stack: 'Total',
                        smooth: true,
                        lineStyle: {
                            width: 0
                        },
                        showSymbol: false,
                        label: {
                            show: true,
                            position: 'top'
                        },
                        areaStyle: {
                            opacity: 0.8,
                            color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [
                                {
                                    offset: 0,
                                    color: 'rgb(255, 191, 0)'
                                },
                                {
                                    offset: 1,
                                    color: 'rgb(224, 62, 76)'
                                }
                            ])
                        },
                        emphasis: {
                            focus: 'series'
                        },
                        data: [220, 302, 181, 234, 210, 290, 150]
                    }
                ]
            };

            //柱状图
            const chart2 = document.getElementById('chart2')
            // Generate data
            let category = [];
            let dottedBase = +new Date();
            let lineData = [];
            let barData = [];
            for (let i = 0; i < 20; i++) {
                let date = new Date((dottedBase += 3600 * 24 * 1000));
                category.push(
                    [date.getFullYear(), date.getMonth() + 1, date.getDate()].join('-')
                );
                let b = Math.random() * 200;
                let d = Math.random() * 200;
                barData.push(b);
                lineData.push(d + b);
            }
            const option2 = {
                backgroundColor: '#98F0EE',
                legend: {
                    data: ['预估', '当前'],
                    textStyle: {
                        color: '#000'
                    }
                },
                xAxis: {
                    data: category,
                    axisLine: {
                        lineStyle: {
                            color: '#000'
                        }
                    }
                },
                yAxis: {
                    splitLine: {show: false},
                    axisLine: {
                        lineStyle: {
                            color: '#0f375f'
                        }
                    }
                },
                series: [
                    {
                        name: '预估',
                        type: 'line',
                        smooth: true,
                        showAllSymbol: true,
                        symbol: 'emptyCircle',
                        symbolSize: 15,
                        data: lineData
                    },
                    {
                        name: '当前',
                        type: 'bar',
                        barWidth: 10,
                        itemStyle: {
                            borderRadius: 5,
                            color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [
                                {offset: 0, color: '#14c8d4'},
                                {offset: 1, color: '#43eec6'}
                            ])
                        },
                        data: barData
                    },
                    {
                        name: 'line',
                        type: 'bar',
                        barGap: '-100%',
                        barWidth: 10,
                        itemStyle: {
                            color: new echarts.graphic.LinearGradient(252, 105, 85, 1, [
                                {offset: 0, color: 'rgba(20,200,212,0.5)'},
                                {offset: 0.2, color: 'rgba(20,200,212,0.2)'},
                                {offset: 1, color: 'rgba(20,200,212,0)'}
                            ])
                        },
                        z: -12,
                        data: lineData
                    },
                    {
                        name: 'dotted',
                        type: 'pictorialBar',
                        symbol: 'rect',
                        itemStyle: {
                            color: '#0f375f'
                        },
                        symbolRepeat: true,
                        symbolSize: [12, 4],
                        symbolMargin: 1,
                        z: -10,
                        data: lineData
                    }
                ]
            };

            //饼图
            const chart3 = document.getElementById('chart3')
            const option3 = {
                title: {
                    text: "培训年龄占比",
                    color:'#fff',
                    x:"center",
                },

                backgroundColor: '#98F0EE',
                series: [
                    {
                        name: 'Nightingale Chart',
                        type: 'pie',
                        radius: [10, 60],
                        center: ['50%', '50%'],
                        roseType: 'area',
                        itemStyle: {
                            borderRadius: 8
                        },
                        data: [
                            {value: 40, name: '0~18'},
                            {value: 38, name: '18~25'},
                            {value: 32, name: '25~30'},
                            {value: 30, name: '30~40'},
                            {value: 28, name: '40~50'},
                            {value: 26, name: '50~60'},
                            {value: 22, name: '60~70'},
                            {value: 2, name: '70~80'}
                        ]
                    }
                ]
            };
            this.myChart1 = echarts.init(chart1);
            this.myChart2 = echarts.init(chart2);
            this.myChart3 = echarts.init(chart3);
            this.myChart1.setOption(option1)
            this.myChart2.setOption(option2)
            this.myChart3.setOption(option3)
            //自适应
            window.addEventListener('resize', () => {
                this.myChart1.resize()
                this.myChart2.resize()
                this.myChart3.resize()
            })
        }
    },
    mounted() {
    }
}
</script>

<style lang="less" scoped>
.el-card {
    background-color: rgba(255, 255, 255, 0.7) !important;
}

.count {
    display: flex;
    justify-content: center;
    flex-wrap: wrap;

    .el-card {
        width: 30%;
        height: 80px;
        margin: 0 5px 5px 0;
        background-color: #98F0EE !important;

        .iconStyle {
            width: 80px;
            height: 80px;
            font-size: 30px;
            color: white;
            text-align: center;
            line-height: 80px;
            background-color: red;
        }

        .countData {
            text-align: left;
            margin-right: 50px;
        }
    }
}

.echarts {
    display: flex;
    justify-content: center;
    align-items: center;
    flex-wrap: wrap;

    #chart1 {
        width: 100%;
        height: 180px;
        margin: 10px 40px;
    }

    .bottom {
        display: flex;
        width: 100%;
        justify-content: space-between;
        padding: 0 40px;

        .el-card {
            width: 48%;
        }

        #chart2, #chart3 {
            height: 260px;
        }
    }
}

.el-card__body, .el-main {
    padding: 0 !important;
}
</style>