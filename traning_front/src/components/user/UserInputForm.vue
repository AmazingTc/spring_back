<template>
        <el-form class="form" ref="form"
                 :model="form"
                 label-position="left"
                 :rules="rules"
                 label-width="auto">
            <el-form-item label="姓名:" prop="name">
                <el-input placeholder="请输入姓名" v-model="form.name"></el-input>
            </el-form-item>
            <el-form-item label="年龄:" prop="age">
                <el-input placeholder="请输入年龄" v-model="form.age"></el-input>
            </el-form-item>
            <el-form-item label="性别:" prop="sex">
                <el-select v-model="form.sex" placeholder="请选择性别">
                    <el-option label="男" value="男"></el-option>
                    <el-option label="女" value="女"></el-option>
                </el-select>
            </el-form-item>
            <el-form-item label="出生日期:" prop="birth">
                <el-col :span="11">
                    <el-date-picker type="date" placeholder="选择日期"  format="yyyy 年 MM 月 dd 日" value-format="yyyy-MM-dd" v-model="form.birth" style="width: 100%"></el-date-picker>
                </el-col>
            </el-form-item>
            <el-form-item label="地址:" prop="address">
                <el-input  placeholder="请输入地址" v-model="form.address"></el-input>
            </el-form-item>
            <el-button v-if="type===0" type="primary" @click="submit">提交</el-button>
            <el-button v-else type="primary" @click="submitEdit">确认</el-button>
        </el-form>
</template>

<script>
import getMessage from "@/utils/message";
import {updateUser} from "@/api";
export default {
    name: "UserInputForm",
    props:['getFormData','type','currentUser'],
    data(){
        return{
            form: {
                name: '',
                age: '',
                sex: '',
                birth: '',
                address: '',
            },
            rules:{
                name: [
                    { required: true, message: '请输入姓名', trigger: 'blur' },
                    { min: 2, max: 5, message: '格式错误', trigger: 'blur' },
                ],
                age: [
                    { required: true, message: '请输入年龄', trigger: 'blur' },
                    { min: 2, max: 3, message: '年龄格式错误', trigger: 'blur' },
                ],
                sex: [
                    { required: true, message: '请选择性别', trigger: 'blur' },
                ],
                birth: [
                    { required: true, message: '请选择日期', trigger: 'blur' },
                ],
                address: [
                    { required: true, message: '请输入地址', trigger: 'blur' },
                ],
            }
        }
    },
    methods: {
        //提交新增
        submit(){
            //对整个表单进行校验
            this.$refs.form.validate((isSuccess)=>{
                if(isSuccess){
                    //校验通过
                    const obj = JSON.parse(JSON.stringify(this.form))
                    this.$emit('getFormData',obj)
                }else{
                    this.$message({
                        type: 'error',
                        message: '请检查输入!',
                        duration:1000,
                    });
                }
            })
        },
        //提交编辑
        submitEdit(){
            this.form.addr=this.form.address
            updateUser(this.form).then(res=>{
                getMessage(res.data.code,'更新')
                this.form={}
                this.$bus.$emit('updateList')
            })
        }
    },
    mounted() {
        if(this.type===1){Object.assign(this.form,this.currentUser)}
        //清空表单数据
        this.$bus.$on('clearInputForm',()=>{
            this.$refs.form.resetFields()
        })
        //点击编辑时传入原用户信息
        this.$bus.$on('getUserInfo',(userInfo)=>{
            this.form= JSON.parse(JSON.stringify(userInfo))
            console.log('传入了用户数据',userInfo)
        })
    },
}
</script>

<style lang="less" scoped>
.form{
    display: flex;
    flex-wrap: wrap;
    justify-content: center;
    align-items: center;
    .el-button{
        width: 50%;

    }
    .el-form-item{
        width: 100%;
    }
}
</style>