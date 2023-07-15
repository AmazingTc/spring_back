<template>
    <div class="user">
        <el-dialog
            custom-calss="dialog"
            :title="type===0?'新增员工':'编辑员工'"
            :visible.sync="dialogVisible"
            :before-close="handleClose"
            width="30%"
            height="50%"
            top="80px"
            center
        >
            <!--用户表单信息-->
            <UserInputForm :type="type" :currentUser="currentEditUserInfo" @getFormData="getFormData"/>
        </el-dialog>
        <div class="user-header">
            <div>
                <el-button type="primary" @click="dialogVisible = true;type=0">+新增</el-button>
            </div>
            <div class="search">
                <el-input  v-model="searchInput" prefix-icon="el-icon-search" placeholder="搜索姓名"></el-input>
                <el-button  type="primary" @click="searchByName">搜索</el-button>
            </div>
        </div>
        <div class="user-list">
            <UserList :tableList="tableData"/>
            <div class="pages">
                <el-pagination
                    @current-change="handlePageChange"
                    layout="prev, pager, next"
                    :total="total">
                </el-pagination>
            </div>
        </div>
    </div>
</template>
<script lang="js">
import UserList from "@/components/user/UserList";
import UserInputForm from "@/components/user/UserInputForm";
import {addUser, getUserList,getEmployee} from "@/api";


export default {
    name: 'User',
    components: {UserInputForm, UserList},
    data() {
        return {
            type: 0,
            dialogVisible: false,
            tableData: [],
            currentEditUserInfo: {},
            total: 0,
            searchInput:'',
            pageConfig:{
                page: 1,
                limit: 10
            },
        }
    },
    watch: {
        total(newVal, oldVal) {
            this.total = newVal
        }
    },
    methods: {
        //获取子组件传递过来的表单数据
        getFormData(form) {
            form.addr = form.address
            addUser(form).then(res => {
                if (res.status === 200) {
                    this.$message({
                        type: 'success',
                        message: '添加成功!',
                        duration: 1000,
                    });
                } else {
                    this.$message({
                        type: 'error',
                        message: '添加失败!',
                        duration: 1000,
                    });
                }
                //更新列表
                this.getList()
            })
            this.handleClose()
        },
        //关闭对话框
        handleClose() {
            this.dialogVisible = false
            this.$bus.$emit('clearInputForm')
        },
        //获取数据
        getList() {
            getUserList({params:this.pageConfig}).then(res => {
                this.total = res.data.count
                this.tableData = res.data.list
            })
        },
        //切换分页
        handlePageChange(pageNum) {
            this.pageConfig['page']=pageNum
            this.getList()
        },
        //搜索用户
        searchByName(){
            getUserList({params:{name:this.searchInput}}).then(res =>{
              if(res.data.length<=0){
                  this.$message({
                      type: 'error',
                      message: `无记录!`,
                      duration:2000,
                  })
              }else{
                  this.$router.push({
                      name:'page2',
                      query:{
                          userList : res.data
                      }
                  })
              }
            })
        }
    },
    mounted() {
        
        
        this.getList()
        //编辑用户
        this.$bus.$on('getType', value => {
            this.type = 1
            this.currentEditUserInfo = value
            this.dialogVisible = true
        })
        this.$bus.$on('updateList', () => {
            this.getList()
            this.handleClose()
        })

    },

}
</script>
<style lang="less" scoped>
.dialog {
    border-radius: 50%;
}
.user-list{
    position:relative;
    .pages{
        position:absolute;
        right: 20px;
    }
}
.user-header{
    display: flex;
    justify-content: space-between;
    .search{
        display: flex;
    }
}

</style>