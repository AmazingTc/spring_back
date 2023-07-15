<template>
    <div class="userList">
        <el-table
            :data="tableData"
            v-loading="loading"
            border
            :lazy="true"
            :stripe="true"
            max-height="500"
            style="width: 100%">
            <el-table-column
                prop="name"
                label="姓名"
                width="120">
            </el-table-column>
            <el-table-column
                prop="age"
                label="年龄"
                width="120">
            </el-table-column>
            <el-table-column
                prop="sex"
                label="性别"
                width="120">
            </el-table-column>
            <el-table-column
                prop="birth"
                label="出生日期"
                width="200">
            </el-table-column>
            <el-table-column
                prop="addr"
                label="地址"
                width="600">
            </el-table-column>
            <el-table-column
                fixed="right"
                label="操作"
                width="150">
                <template slot-scope="scope">
                    <el-button type="danger"  size="small" @click="handleDelete(scope)">删除</el-button>
                    <el-button type="primary"  size="small" @click="handleEdit(scope)">编辑</el-button>
                </template>
            </el-table-column>
        </el-table>

    </div>
</template>

<script>
import getMessage from "@/utils/message";
import {deleteUser} from "@/api";
export default {
    name: "UserList",
    props:['tableList','total'],
    data(){
        return{
            loading:true,
            dialogVisible: false,
            tableData:[],
        }
    },
    watch:{
      tableList(newVal,oldVal){
          newVal.forEach(item=>{
              item.sex=item.sex===1?'男':'女'
          })
          this.tableData=newVal
          this.loading=false
      }
    },
    methods:{
        handleEdit(scope){
            this.$bus.$emit('getType',scope.row)
            this.$bus.$emit('getUserInfo',scope.row)

        },
        handleClose(){
            this.dialogVisible=false
            this.$bus.$emit('clearInputForm')
        },
        handleDelete(scope){
                this.$confirm('删除用户信息, 是否继续?', '提示', {
                    confirmButtonText: '确定',
                    cancelButtonText: '取消',
                    type: 'warning'
                }).then(() => {
                    deleteUser(scope.row).then(res=>{
                        getMessage(res.data.code,'删除')
                    })
                    this.$bus.$emit('updateList')
                }).catch(e=>{})
        }
    },
    mounted() {

    }
}
</script>

<style scoped>
.userList{
    height: 90%;
}
</style>