<template>
    <div class="win">
        <div class="login">
            <el-form ref="loginForm" class="form" :rules="rules" label-position="left" label-width="80px" :model="user">
                <h3 style="text-align: center">login</h3>
                <div class="box">

                    <el-form-item prop="username"   style="margin-top: 30px;">
                        <span slot="label">
      	                        <span style="color: white">用户名:</span>
                        </span>
                        <i class="el-icon-user-solid"></i>
                        <el-input v-model="user.username"></el-input>
                    </el-form-item>
                </div>
                <div class="box">
                    <el-form-item prop="password"  class="box">
                        <span slot="label">
      	                        <span style="color: white">密码:</span>
                        </span>
                        <i class="el-icon-user"></i>
                        <el-input type="password" v-model="user.password"></el-input>
                    </el-form-item>
                </div>
                <el-button @click="login" style="margin-top: 30px;width: 50%;background-color:rgba(0,0,0,0.3);" type="primary" >登录</el-button>
            </el-form>
        </div>
    </div>
</template>

<script>
import Cookie from 'js-cookie'
import {userLogin} from "@/api";
import getMessage from "@/utils/message";
export default {
    name: "Login",
    data() {
        return {
            user: {
                username: '',
                password: ''
            },
            rules: {
                username: [
                    {required: true, message: '请输入用户名', trigger: 'blur'},
                    {min: 2, max: 10, message: '长度在 2 到 10 个字符', trigger: 'blur'}
                ],
                password: [
                    {required: true, message: '请输入密码', trigger: 'blur'},
                    {pattern:  /^[0-9A-Za-z]{4,12}$/, message: '4到12位数字加字母', trigger: 'blur'}
                ]

            }
        }
    },
    methods: {
        login() {
            if (this.$refs.loginForm) {
                this.$refs.loginForm.validate((isSuccess) => {
                    if (isSuccess) {
                        //校验通过
                        //访问后端登接口
                        userLogin(this.user).then(res => {
                            const menu1 = [
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
                                    label: '培训项目管理',
                                    icon: 'video-play',
                                    url: 'Mall.vue'
                                },
                                {
                                    path: '/user',
                                    name: 'user',
                                    label: '员工管理',
                                    icon: 'user',
                                    url: 'User.vue'
                                },
                                {
                                    path: 'detail',
                                    name: 'detail',
                                    label: '详情',
                                    icon: 'setting',
                                    url: 'Detail.vue',
                                },
                                {
                                    label: '其他',
                                    icon: 'location',
                                    children: [
                                        {
                                            path: '/page1',
                                            name: 'page1',
                                            label: '培训人员管理',
                                            icon: 'setting',
                                            url: 'PageOne.vue',
                                        },
                                        {
                                            path: '/page2',
                                            name: 'page2',
                                            label: '详情',
                                            icon: 'setting',
                                            url: 'PageTwo.vue'
                                        }
                                    ]
                                }
                            ]
                            const menu2 = [
                                {
                                    path: '/home',
                                    name: 'home',
                                    label: '首页',
                                    icon: 's-home',
                                    url: 'HomeUser.vue'
                                },
                                {
                                    path: '/page1',
                                    name: 'page1',
                                    label: '我的培训',
                                    icon: 'setting',
                                    url: 'PageOne.vue',
                                },
                                {
                                    path: 'detail',
                                    name: 'detail',
                                    label: '详情',
                                    icon: 'setting',
                                    url: 'Detail.vue',
                                },
                            ]
                            const menu = res.data.data.power === 0 ? menu1 : menu2
                            const token = res.data.token
                            if (res.data.code === 2000) {
                                const user = {...res.data.data}
                                getMessage(res.data.code, '登录')
                                Cookie.set('token', token)
                                this.$store.commit('userModule/SAVEUSER', user)
                                this.$store.commit('menuModule/SETMENUDATA', menu)
                                this.$store.commit('menuModule/ADDROUTER', this.$router)
                                this.$router.replace('/home')

                            } else if (res.data.code === 2001) {
                                this.$message({
                                    type: 'error',
                                    message: '密码错误!',
                                    duration: 1000,
                                });
                            }
                        })
                    } else {
                        this.$message({
                            type: 'error',
                            message: '输入格式错误!',
                            duration: 1000,
                        });
                    }
                })
            }
        }
    },
    mounted() {
        window.addEventListener('keyup',e=>{
            if(e.code==='Enter'){
                this.login()
            }
        })
    },
}
</script>6

<style lang="less" scoped>
.win {
    background: url("../assets/images/login.jpg");
    background-size: cover;
    background-repeat: no-repeat;
    height: 100vh;
    width: 100vw;
    position: absolute;
}

.login {
    width: 25vw;
    height: 40vh;
    border: 1px solid #ccc;
    margin: 150px auto;
    border-radius: 10px;
    color:#fff;
    background-color: rgba(0, 0, 0, 0.5);

    .form {
        display: flex;
        justify-content: center;
        align-items: center;
        flex-direction: column;
        flex-wrap: wrap;
        padding: 10px 20px;
        .el-form--label-left .el-form-item__label{
            color:red!important;
        }
    }

    .box {
        position: relative;

        i {
            position: absolute;
            left: -95px;
            top: 8px;
        }
    }
}
</style>