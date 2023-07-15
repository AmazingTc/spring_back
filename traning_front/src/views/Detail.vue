<template>
    <div class="detailPage">
        <el-row :gutter="20">
            <el-col :span="6">
                <div class="grid-content bg-purple">
                    <div class="mugShot">
                        <i style="position: absolute;justify-content: flex-start;opacity: 0.5;margin: 10px;font-style: normal;background: red;width: 40px;text-align: center;border-radius: 5px"></i>
                        <img class="img1" :src="test( bookList.img_src )" alt="">
                    </div>
                </div>
            </el-col>
            <el-col :span="14">
                <div class="grid-content bg-purple">
                    <div class="introduce">
                        <p style="font-size: 30px">{{ bookList.name }}</p>
                        <i class="el-icon-star-on" @click=collect() v-bind:style="{color: activeColor}"></i>
                        <p style="margin-top: 20px">Deatail</p>
                        <el-row :gutter="20" style="margin-top: 10px">
                            <el-col :span="6">
                                <div class="grid-content bg-purple">
                                    <p style="color: gray;">作者</p>
                                    <p style="font-size: 20px">{{ bookList.author }}</p>
                                </div>
                            </el-col>
                            <el-col :span="8">
                                <div class="grid-content bg-purple"></div>
                                <p style="color: gray;">价格</p>
                                <p style="font-size: 20px">{{ bookList.price }}</p></el-col>
                            <el-col :span="10">
                                <div class="grid-content bg-purple"></div>
                                <p style="color: gray;">概要</p>
                                <p style="font-size: 20px">{{ bookList.synopsis }}</p></el-col>
                        </el-row>
                        <div class="classify" style="margin-top: 10px">
                            <ul style="margin: 20px">
                                <li>123</li>
                                <li>123</li>
                                <li>123</li>
                                <li>123</li>
                            </ul>
                        </div>
                        <!--            <button>购买</button>-->
                    </div>

                </div>
            </el-col>
            <el-col :span="4">
                <div class="grid-content bg-purple">
                </div>
            </el-col>
        </el-row>
        <el-divider></el-divider>
        <div class="evaluate"></div>
        <h1 style="color:pink">评价:</h1>
        <div>
           <el-form>
               <el-input type="textarea" v-model="inputText"></el-input>
               <el-button @click="submitInput">点击提交</el-button>
           </el-form>
        </div>
        <div>
            <el-card v-for="item in appraiseList" :key="item.id" class="box-card">
                <div class="item">
                    <div>
                        <span>用户:</span>:{{item.nickname}}
                    </div>
                   <div>
                       <span>评论:</span>:{{item.comments}}
                   </div>
                    <div>
                        <span>时间:</span>:{{item.datetime}}
                    </div>
                </div>
            </el-card>
        </div>
    </div>
</template>

<script>
import {mapState} from 'vuex'
import getImg from "@/utils/getImg"
import {getAppraise, sendAppraise} from "@/api";
import getMessage from "@/utils/message";
const i = document.querySelectorAll('el-icon-star-on')
export default {
    name: "Detail",
    computed:{
        ...mapState('userModule',['userInfo'])
    },
    data() {
        return {
            activeColor: 'white',
            bookList: '',
            imag: 'bookList.img_src',
            text:'',
            inputText:'',
            appraiseList:[]
        }
    },
    mounted() {
        //点击商品传递过来的商品id
        const id = this.$route.query.id
        const bookLists = this.$route.query.bookLists
        bookLists.forEach((value, index) => {
            if (value.id === id) {
                this.bookList = value
            }
        })
        this.getAppraise()
    },
    methods: {
        collect() {
            if (this.activeColor === "white") {
                this.activeColor = 'orange'
            } else {
                this.activeColor = 'white'
            }

        },
        test(img) {
            return getImg(img)
        },
        //提交评价
        submitInput(){
            if(this.inputText!==''||this.inputText.length>0){
                sendAppraise({
                    nickname:this.userInfo.nickname,
                    book_id:this.$route.query.id,
                    comments:this.inputText
                    }).then(res=>{
                        getMessage(res.data.code,'评价')
                        this.inputText=''
                        this.getAppraise()
                })
            }else{
                this.$message({
                    type: 'error',
                    message: "输入不能为空",
                    duration:2000,
                })
            }
        },
        getAppraise(){
            getAppraise({params:{book_id:this.$route.query.id}}).then(res=>{
                this.appraiseList=res.data.data
            })
        }
    },
}
</script>

<style scoped lang="less">
.detailPage {
    padding: 20px;
    height: 200%;
    .mugShot {
        display: flex;
        height: 300px;
        background: #eeeeee;
        border-radius: 10px;
        box-shadow: 10px 10px 10px 10px #cccccc;
        img {
            height: 80%;
            width: 80%;
            border-radius: 10px;
            margin: auto;
        }
    }

    .introduce {
        height: 300px;
        background: #eeeeee;
        border-radius: 20px;
        padding: 20px;
        box-shadow: 10px 10px 10px 10px #cccccc;

        .el-icon-star-on {
            cursor: pointer;
            margin-top: -30px;
            float: right;
            font-size: 30px;
        }

        button {
            float: right;
            cursor: pointer;
            margin-top: -40px;
            font-size: 20px;
            width: 100px;
            height: 30px;
            background: skyblue;
            border-radius: 5px;
        }
    }
}
.box-card{
    display: flex;
    background-color: #e4eaec;
    margin:20px 0;
    box-shadow: 5px 5px 5px 5px  #ccc;
    .item{
        //flex: 1;
        display: flex;
        flex-wrap: wrap;
        div{
            width:100%;
        }
        span{
            color: #b46481;
        }
    }
}

</style>