<template>
    <div class="left">
        <el-card class="box-card" shadow="hover">
            <div class="user">
                <img src="../../assets/images/head.jpg" alt="">
                <div class="userInfo">
                    <p class="username">Welcome</p>
                    <p class="access gray">{{ userInfo.nickname }}</p>
                </div>
                <div class="loginInfo">
                    <div>
                        <span>上次登录：</span>
                        <span style="font-size: 10px" class="gray">{{userInfo.lasttime}}</span>
                    </div>
                    <div>
                        <span>上次登录地点：</span>
                        <span class="gray">武汉</span>
                    </div>
                </div>
            </div>
        </el-card>
        <el-card class="box-card" style="margin-top: 20px;height:350px" shadow="hover">
            <el-table
                :data="tableData"
                style="width: 100%">
                <el-table-column
                    v-for="(val,key) in tableLabel"
                    :key="key"
                    :prop="key"
                    :label="val"
                    width="100" />
            </el-table>
        </el-card>
    </div>
</template>

<script>
import {mapState} from 'vuex'
export default {
    name: "HomeLeft",
    props:['tableData'],
    computed:{
        ...mapState('userModule',['userInfo'])
    },
    data() {
        return {
            tableLabel: {
                name: '类别',
                todayBuy: '今日完成',
                monthBuy: '总完成',
                totalBuy: '完成占比'
            }
        }
    },
    mounted() {
        console.log(this.tableData)
    }
}
</script>

<style lang="less" scoped>
.el-card{
    background-color: #98F0EE!important;
}
.user {
    width: 100%;
    height: 40%;
    display: flex;
    flex-wrap: wrap;
    align-items: center;
    padding: 5px 10px;

    .userInfo {
        margin-left: 40px;
        font-size: 20px;
        .username {
            font-weight: bold;
        }
    }
    .loginInfo {
        display: flex;
        flex-direction: column;
        margin-top: 10px;
        div {
            display: flex;
            font-size: 14px;

            span:nth-child(2) {
                margin-left: 40px;
            }
        }
    }
    img {
        width: 120px;
        height: 120px;
        border-radius: 50%;
    }
}
.gray {
    color: #999;
}
</style>