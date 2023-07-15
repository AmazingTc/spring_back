<template>
    <div class="header">
        <div class="menu">
            <el-button icon="el-icon-menu" @click="aliveMenu"></el-button>
            <div class="nav">
                <el-breadcrumb separator-class="el-icon-arrow-right">
                     <el-breadcrumb-item
                         v-for="item in tableList" :key="item.name"
                         :to="{ path: item.path }">
                                {{item.label}}
                     </el-breadcrumb-item>

                </el-breadcrumb>
            </div>
        </div>
        <i class="iconfont icon-fantuan"></i>
        <div class="userInfo">
            <span>Welcome</span>
            <el-dropdown @command="handleCommand">
                <span class="el-dropdown-link">
                    <img alt="" src="../assets/images/head.jpg">
                </span>
                <el-dropdown-menu  slot="dropdown" split-button>
                    <el-dropdown-item command="person">个人中心</el-dropdown-item>
                    <el-dropdown-item command="out">退出</el-dropdown-item>
                </el-dropdown-menu>
            </el-dropdown>
        </div>
    </div>
</template>

<script>
import {mapState} from 'vuex'
import Cookie from "js-cookie";
export default {
    name: "Header",
    computed:{
        ...mapState('menuModule',['tableList'])//面包屑数据
    },
    methods:{
        //折叠或打开菜单
        aliveMenu(){
            this.$store.commit('menuModule/CHANGEOPEN')
        },
        handleCommand(command){
            if(command==='out'){
                //退出登录
                Cookie.remove('token')
                this.$router.replace('/login')
                localStorage.removeItem('userInfo')
                localStorage.removeItem('menu')
            }

        }
    },
    mounted() {

    }
}
</script>

<style lang="less" scoped>
@main-color: #F5B041;
.header {
    background-color: #98F0EE;
    width: 100%;
    height: 50px;
    display: flex;
    padding: 0 10px;
    font-size: 14px;
    position:relative;
    justify-content: space-between;
    i {
        font-size: 20px;
        color: @main-color;
        line-height: 50px;
        padding-left: 10px;
    }

    .menu {
        line-height: 50px;
        color: @main-color;
        .nav{
            position:absolute;
            top:20px;
            left: 80px;
            .el-breadcrumb__item:last-child .el-breadcrumb__inner:hover{
                cursor:pointer;
            }
        }
    }

    .userInfo {
        display: flex;
        color: @main-color;

        img {
            width: 50px;
            height: 50px;
            border-radius: 50%;
        }

        span {
            line-height: 50px;
        }

        .person {
            position: absolute;
            display: flex;
            flex-direction: column;
            text-align: center;
            background-color: #fff;
            right: 10px;
            top: 50px;
            box-shadow: #cccccc 5px 5px 5px 5px;
            border-radius: 5px;
            font-size: 10px;

            span {
                cursor: pointer;
                border-bottom: 1px solid rgba(0, 0, 0, 0.1);
            }
        }
    }
}
</style>