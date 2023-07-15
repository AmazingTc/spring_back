<template>
    <div class="UserMsg" style="height: 200%">
        <div class="demo-type" style="margin: 20px">
          <el-avatar src="https://cube.elemecdn.com/0/88/03b0d39583f48206768a7534e55bcpng.png" :size="70"></el-avatar>
        </div>
        <el-descriptions class="margin-top" title="员工详细信息" :column="2" :size="size" border>
          <el-descriptions-item>
            <template slot="label" >
              <i class="el-icon-user"></i>
              姓名
            </template>
            {{ employee.employee_name }}
          </el-descriptions-item>
          <el-descriptions-item>
            <template slot="label">
              <i class="el-icon-s-custom"></i>
              性别
            </template>
            <div >{{employee.employee_sex}}</div>
          </el-descriptions-item>

          <el-descriptions-item>
            <template slot="label">
              <i class="el-icon-time"></i>
              住址
            </template>
            {{ employee.employee_address}}
          </el-descriptions-item>

          <el-descriptions-item>
            <template slot="label">
              <i class="el-icon-location-outline"></i>
              电话
            </template>
            {{ employee.employee_phone }}
          </el-descriptions-item>
          <el-descriptions-item>
            <template slot="label">
              <i class="el-icon-tickets"></i>爱好</template>
            会唱跳rap篮球
          </el-descriptions-item>
          <el-descriptions-item>
            <template slot="label">
              <i class="el-icon-tickets"></i>培训项目</template>
            {{program}}
          </el-descriptions-item>
          <el-descriptions-item>
          <template slot="label">
              <i class="el-icon-tickets"></i>是否完成</template>
            {{isComplete}}
          </el-descriptions-item>
        </el-descriptions>
    </div>
</template>

<script>
import {getEmployeeComplete,getTranById} from "@/api";
import getMessage from '@/utils/message';
export default {
    name: "PageTwo",
    data() {
      return{
        employee:{
          employee_name:"",
          employee_sex:"",
          employee_address:"",
          employee_phone:"",
          
        },
        program:"",
        isComplete:"",
        size:'2',
      }
    },
  mounted() {
    this.employee ={...JSON.parse(this.$route.params.employee)}
    const params = new FormData();
    params.append("employee_id", this.employee.employee_id);
    params.append("traning_id", this.employee.traning_id);
    getEmployeeComplete(params).then(res=>{
          getMessage(res.data.code, "获取")
          this.isComplete=res.data.data.complete==1?"已完成":"未完成"
          const param = new FormData();
          param.append("traning_id",this.employee.traning_id);
          getTranById(param).then(res=>{this.program=res.data.data})
          
    })
  }
}
</script>

<style scoped lang="less">

</style>