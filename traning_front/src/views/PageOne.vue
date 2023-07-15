<template>
  <div>
    <div>
      <el-button
        type="primary"
        @click="
          dialog = true;
          isAdd = true;
        "
        >+新增</el-button
      >
    </div>
    <el-table
      :data="tableData"
      border
      :lazy="true"
      :stripe="true"
      max-height="500"
      style="width: 100%"
    >
      <el-table-column
        prop="employee_id"
        label="id"
        width="120"
      ></el-table-column>
      <el-table-column
        prop="employee_name"
        label="姓名"
        width="120"
      ></el-table-column>
      <el-table-column
        prop="employee_age"
        label="年龄"
        width="100"
      ></el-table-column>
      <el-table-column
        prop="employee_sex"
        label="性别"
        width="100"
      ></el-table-column>
      <el-table-column
        prop="traning_id"
        label="培训项目id"
        width="100"
      ></el-table-column>
      <el-table-column    
       width="120"
       label="是否完成培训">
        <template slot-scope="scope">
            <el-checkbox v-model="scope.row.complete" @change="handleChange(scope)"></el-checkbox>
        </template>
       
      </el-table-column>
      <el-table-column
        prop="employee_address"
        label="家庭地址"
        width="100"
      ></el-table-column>
      <el-table-column
        prop="employee_phone"
        label="联系方式"
        width="100"
      ></el-table-column>

       <el-table-column fixed="right" label="操作" width="150">
        <template slot-scope="scope">
          <el-button type="danger" size="small" @click="toDetail(scope)"
            >查看详情</el-button
          >
        </template>
      </el-table-column>
      
      <el-table-column fixed="right" label="操作" width="150">
        <template slot-scope="scope">
          <el-button type="danger" size="small" @click="handleDelete(scope)"
            >删除</el-button
          >
          <el-button type="primary" size="small" @click="handleEdit(scope)"
            >编辑</el-button
          >
        </template>
      </el-table-column>
    </el-table>

    <!--        dialog-->
    <el-drawer
      :title="!isAdd ? '编辑' : '添加'"
      :visible.sync="dialog"
      direction="ltr"
      :before-close="handleDrawerClose"
      custom-class="demo-drawer"
      ref="drawer"
      size="35%"
    >
      <div class="demo-drawer__content">
        <el-form
          :model="form"
          v-loading="loading"
          element-loading-text="拼命提交中"
          element-loading-spinner="el-icon-loading"
        >
        <el-form-item label="员工Id:" :label-width="formLabelWidth">
            <el-input v-model="form.employee_id" autocomplete="off"></el-input>
          </el-form-item>
          <el-form-item label="姓名:" :label-width="formLabelWidth">
            <el-input v-model="form.employee_name" autocomplete="off"></el-input>
          </el-form-item>
          <el-form-item label="年龄:" :label-width="formLabelWidth">
            <el-input
              v-model="form.employee_age"
              autocomplete="off"
            ></el-input>
          </el-form-item>
          <el-form-item label="性别:" :label-width="formLabelWidth">
            <el-input
              v-model="form.employee_sex"
              autocomplete="off"
            ></el-input>
          </el-form-item>
          <el-form-item label="培训项目ID:" :label-width="formLabelWidth">
            <el-input v-model="form.traning_id" autocomplete="off"></el-input>
          </el-form-item>
          <el-form-item label="家庭地址:" :label-width="formLabelWidth">
            <el-input
              v-model="form.employee_address"
              autocomplete="off"
            ></el-input>
          </el-form-item>
          <el-form-item label="联系方式:" :label-width="formLabelWidth">
            <el-input
              v-model="form.employee_phone"
              autocomplete="off"
            ></el-input>
          </el-form-item>
  
        </el-form>
        <div class="demo-drawer__footer">
          <el-button @click="cancelForm">取 消</el-button>
          <el-button type="primary" @click="submit" :loading="loading"
            >{{ loading ? "提交中 ..." : "确 定" }}
          </el-button>
        </div>
      </div>
    </el-drawer>
  </div>
</template>

<script>
import { updateComplete,deleteEmployee, addEmployee, updateEmployee } from "@/api";
import getMessage from "@/utils/message";
import { getEmployee } from "@/api";
export default {
   name: "PageOne",
  data() {
    return {
      loading: false,
      tableData: [],
      dialog: false,
      formLabelWidth: "80px",
      value:'123',
      isAdd: false,
      options:[
        {
         value: '已完成',
         label: '未完成',
        },
        {
         value: '已完成',
         label: '已完成',
        },

      ],
      form: {
        employee_id:"",
        employee_name: "",
        employee_age: "",
        traning_id: "",
        employee_address: "",
        employee_phone: "",
        employee_sex: "",
        complete:false
      },
    };
  },

  methods: {
    //删除项目
    handleDelete(scope) {
      this.$confirm("此操作将永久删除该项目, 是否继续?", "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning",
      }).then(() => {
          deleteEmployee({ params: { id: parseInt(scope.row.employee_id) } }).then(
            (res) => {
              getMessage(res.data.code, "删除");
              this.getList();
            }
          );
        })
        .catch(() => {
          this.$message({
            type: "info",
            message: "已取消",
          });
        });
    },
    handleChange(scope){
      const params = new FormData();
      params.append("employee_id",scope.row.employee_id );
      params.append("traning_id",scope.row.traning_id );
      params.append("complete", scope.row.complete===true?1:0);
      updateComplete(params).then(res=>{
              getMessage(res.data.code, "更新");
        
      })
    },
    //点击编辑
    handleEdit(scope) {
      this.dialog = true;
      this.form.employee_id = scope.row.employee_id;
      this.form.employee_name = scope.row.employee_name;
      this.form.employee_age = scope.row.employee_age;
      this.form.traning_id = scope.row.traning_id;
      this.form.employee_address = scope.row.employee_address;
      this.form.employee_phone = scope.row.employee_phone;
      this.form.employee_sex = scope.row.employee_sex;
    },

    //取消表单
    cancelForm() {
      this.loading = false;
      this.dialog = false;
      this.isAdd = false;
      this.form = {
        employee_id:"",
        employee_name: "",
        employee_age: "",
        traning_id: "",
        employee_address: "",
        employee_phone: "",
        employee_sex: "",

      };
    },
    toDetail(item){
      this.$router.push({name:'page2',params:{ employee : JSON.stringify(item.row)}})
    },
    //抽屉关闭前调用
    handleDrawerClose() {
      this.cancelForm();
    },
    //添加或者更新图书信息
    submit() {
      this.loading = true;
      const params = new FormData();
      // 使用form表单的数据格式
      // 将输入表单数据添加到params表单中
      params.append("employee_id", parseInt(this.form.employee_id));
      params.append("employee_name", this.form.employee_name);
      params.append("employee_age", this.form.employee_age);
      params.append("traning_id", parseInt(this.form.traning_id));
      params.append("employee_address", this.form.employee_address);
      params.append("employee_phone", this.form.employee_phone);
        params.append("employee_sex", this.form.employee_sex);
      //添加逻辑
      if (this.isAdd) {
        console.log(params)
        addEmployee(params).then((res) => {
          console.log(res);
          getMessage(res.data.code, "添加");
          this.cancelForm();
          this.getList();
        });
      } else {

        //更新逻辑
        updateEmployee(this.form).then((res) => {
          getMessage(res.data.code, "更新");
          this.cancelForm();
          this.getList();
        });
      }
      this.$refs.drawer.closeDrawer();
    },
    getList() {
      getEmployee().then((res) => {
        this.tableData = res.data.data;
      });
    },
  },
  mounted() {
    this.getList();
  },
};
</script>


<style scoped lang="less">
.el-form {
  position: relative;
  padding: 0 20px;
  display: flex;
  flex-wrap: wrap;

  .el-form-item {
    width: 500px;
  }
}
.el-loading-spinner {
  position: absolute;
  left: 0;
}

.demo-drawer {
  display: flex;
  justify-content: center;
  align-items: center;
  button {
    margin-top: 50px;
    width: 200px;
  }
}
/deep/.demo-drawer {
  text-align: center;
  font-weight: bold;
  font-size: 20px;
  height: 800px;
  .el-form {
    display: flex;
    justify-content: center;
  }
}
</style>