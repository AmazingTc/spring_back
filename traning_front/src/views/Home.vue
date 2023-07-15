<template>
    <div class="home">
        <el-row>
            <el-col :span="8">
                <HomeLeft :tableData="tableData" />
            </el-col>
            <el-col :span="16">
                <HomeRight :orderData="orderData" :userData="userData"  :videoData="videoData" />
            </el-col>
        </el-row>
    </div>
</template>
<script lang="js">
import HomeLeft from "@/components/home/HomeLeft";
import HomeRight from "@/components/home/HomeRight";
import {getData} from "@/api";
export default {
    name: 'Home',
    components:{HomeLeft,HomeRight},
    data(){
        return {
            tableData: [],
            orderData: {},
            userData: [],
            videoData: []
        }
    },
    mounted() {
        getData().then(({data})=>{
            const {tableData}=data.data
            const {orderData}=data.data
            const {userData}=data.data
            const {videoData}=data.data
            this.tableData=tableData
            this.orderData=orderData
            this.userData=userData
            this.videoData=videoData

        })
    }

}
</script>
<style lang="less" >

</style>