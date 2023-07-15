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
        prop="traning_id"
        label="id"
        width="120"
      ></el-table-column>
      <el-table-column
        prop="traning_program"
        label="项目名称"
        width="120"
      ></el-table-column>
      <el-table-column
        prop="traning_data"
        label="项目开始日期"
        width="120"
      ></el-table-column>
      <el-table-column
        prop="traning_personnum"
        label="培训人数"
        width="100"
      ></el-table-column>
      <el-table-column
        prop="traning_address"
        label="培训地址"
        width="100"
      ></el-table-column>
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
          <el-form-item label="id:" :label-width="formLabelWidth">
            <el-input v-model="form.traning_id" autocomplete="off"></el-input>
          </el-form-item>
          <el-form-item label="项目名称:" :label-width="formLabelWidth">
            <el-input
              v-model="form.traning_program"
              autocomplete="off"
            ></el-input>
          </el-form-item>
          <el-form-item label="项目开始日期:" :label-width="formLabelWidth">
            <el-input v-model="form.traning_data" autocomplete="off"></el-input>
          </el-form-item>
          <el-form-item label="培训人数:" :label-width="formLabelWidth">
            <el-input
              v-model="form.traning_personnum"
              autocomplete="off"
            ></el-input>
          </el-form-item>
          <el-form-item label="培训地址:" :label-width="formLabelWidth">
            <el-input
              v-model="form.traning_address"
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
import { getTraning, deleteTraning, addTraning, updateTraning } from "@/api";
import getMessage from "@/utils/message";
export default {
  name: "Mall",
  data() {
    return {
      loading: false,
      tableData: [],
      dialog: false,
      formLabelWidth: "80px",
      isAdd: false,
      form: {
        traning_id: "",
        traning_program: "",
        traning_data: "",
        traning_address: "",
        traning_personnum: "",
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
      })
        .then(() => {
          deleteTraning({ params: { id: scope.row.traning_id } }).then(
            (res) => {
              console.log("结果", res);
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
    //点击编辑
    handleEdit(scope) {
      this.dialog = true;
      this.form.traning_id = scope.row.traning_id;
      this.form.traning_program = scope.row.traning_program;
      this.form.traning_data = scope.row.traning_data;
      this.form.traning_address = scope.row.traning_address;
      this.form.traning_personnum = scope.row.traning_personnum;
    },

    //取消表单
    cancelForm() {
      this.loading = false;
      this.dialog = false;
      this.isAdd = false;
      this.form = {
        traning_id: "",
        traning_program: "",
        traning_data: "",
        traning_address: "",
        traning_personnum: "",
      };
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
      console.log(this.form);
      params.append("traning_id", parseInt(this.form.traning_id));
      params.append("traning_program", this.form.traning_program);
      params.append("traning_data", this.form.traning_data);
      params.append("traning_address", this.form.traning_address);
      params.append("traning_personnum", parseInt(this.form.traning_personnum));
      //添加逻辑
      if (this.isAdd) {
        addTraning(params).then((res) => {
          console.log(res);
          getMessage(res.data.code, "添加");
          this.cancelForm();
          this.getList();
        });
      } else {

        //更新逻辑
        updateTraning(this.form).then((res) => {
          getMessage(res.data.code, "更新");
          this.cancelForm();
          this.getList();
        });
      }
      this.$refs.drawer.closeDrawer();
    },
    getList() {
      getTraning().then((res) => {
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