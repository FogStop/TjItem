<template>
  <div>
    <!-- 搜索栏 -->
    <el-card class="box-s">
      <el-row>
        <el-col :span="20">
          <el-input
            v-model="searchList.username"
            placeholder="用户名"
            clearable
          ></el-input>
          <!-- clearable:一键删除 -->
          <el-input
            v-model="searchList.phone"
            placeholder="电话"
            clearable
          ></el-input>
          <el-button
            @click="getUserList"
            type="primary"
            round
            icon="el-icon-search"
            >查询</el-button
          >
        </el-col>
        <el-col :span="4" align="right">
          <el-button
            @click="openEditUI(null)"
            type="primary"
            round
            icon="el-icon-plus"
            circle
          ></el-button>
        </el-col>
      </el-row>
    </el-card>

    <!-- 内容展示 -->
    <el-card>
      <el-table :data="userList" stripe style="width: 100%">
        <el-table-column label="序号" width="80">
          <template slot-scope="scope">
            {{
              (searchList.pageNo - 1) * searchList.pageSize + scope.$index + 1
            }}
          </template>
        </el-table-column>
        <el-table-column prop="id" label="用户ID" width="180">
        </el-table-column>
        <el-table-column prop="username" label="用户名" width="180">
        </el-table-column>
        <el-table-column prop="phone" label="电话" width="180">
        </el-table-column>
        <el-table-column prop="status" label="用户状态" width="180">
          <template slot-scope="scope">
            <el-tag v-if="scope.row.status == 1">正常</el-tag>
            <el-tag v-else type="danger">禁止</el-tag>
          </template>
        </el-table-column>
        <el-table-column prop="email" label="电子邮件"></el-table-column>
        
        <el-table-column label="操作" width="180">
          <template slot-scope="scope">
            <el-button
              @click="openEditUI(scope.row.id)"
              type="primary"
              icon="el-icon-edit"
              size="mini"
              circle
            ></el-button>
            <el-button
            @click="deleteUser(scope.row)"
              type="danger"
              icon="el-icon-delete"
              size="mini"
              circle
            ></el-button>
          </template>
        </el-table-column>
      </el-table>
    </el-card>
    <!-- 分页 -->
    <el-pagination
      @size-change="handleSizeChange"
      @current-change="handleCurrentChange"
      :current-page="searchList.pageNo"
      :page-sizes="[5, 10, 20, 50]"
      :page-size="searchList.pageSize"
      layout="total, sizes, prev, pager, next, jumper"
      :total="total"
    >
    </el-pagination>
    <!-- 用户对话框 -->
    <el-dialog
      @close="clearForm"
      :title="title"
      :visible.sync="dialogFormVisible"
    >
      <el-form :model="userform" ref="userFormRef" :rules="rules">
        <el-form-item
          label="用户姓名:"
          prop="username"
          :label-width="formLabelWidth"
        >
          <el-input v-model="userform.username" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item
          label="用户密码:"
          v-if="userform.id == null || userform.id == undefined"
          prop="password"
          :label-width="formLabelWidth"
        >
          <!--  v-if="userform.id == null || userform.id == undefined"   判断状态 -->
          <el-input
            type="password"
            v-model="userform.password"
            autocomplete="off"
          ></el-input>
        </el-form-item>
        <el-form-item
          label="联系电话:"
          prop="phone"
          :label-width="formLabelWidth"
        >
          <el-input v-model="userform.phone" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="员工状态:" :label-width="formLabelWidth">
          <el-switch
            v-model="userform.status"
            active-value="1"
            inactive-value="0"
          >
          </el-switch>
        </el-form-item>
        <el-form-item
          label="电子邮件"
          prop="email"
          :label-width="formLabelWidth"
        >
          <el-input v-model="userform.email" autocomplete="off"></el-input>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="dialogFormVisible = false">取 消</el-button>
        <el-button type="primary" @click="saveUser">确 定</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import userApi from"@/api/userMange.js"
export default {
  name: "allorder",
  data() {
    return {
      formLabelWidth: "130px", //左边距
      userform: {},
      dialogFormVisible: false, //是否可见
      title: "",
      total: 0,
      searchList: {
        pageNo: 1,
        pageSize: 10,
      },
      userList: [],
      rules: {
        username: [
          { required: true, message: "请输入用户名", trigger: "blur" },
          { min: 2, max: 50, message: "长度为3到50个字符", trigger: "blur" },
        ],
        password: [
          { required: true, message: "请输入登录密码", trigger: "blur" },
          { min: 2, max: 50, message: "长度为2到16个字符", trigger: "blur" },
        ],
        phone: [
          { required: true, message: "请输入联系电话", trigger: "blur" },
          { min: 4, max: 16, message: "长度为3到18个字符", trigger: "blur" },
        ],
        email: [{ required: true, message: "请输入电子邮件", trigger: "blur" }],
      },
    };
  },
  methods: {
    deleteUser(user){
     this.$confirm(`您确定删除${user.username}?`,'提示',{
      confirmButtonText: '确定',
      cancelButtonText:'取消',
      type:'warning'
     }).then(()=>{
      userApi.deleteUserById(user.id).then(response=>{
         this.$message({
          type:'success',
          message:response.message
         });
      });
     }).catch(()=>{
      this.$message({
        type:'info',
        message:'已取消删除'
      });
     });
    },
    saveUser() {
      // 表单验证
      this.$refs.userFormRef.validate((valid) => {
        if (valid) {
          userApi.saveUser(this.userform).then((response) => {
            // 成功提示
            this.$message({
              message: response.message,
              type: "success",
            });
            // 关闭对话
            this.dialogFormVisible = false;
            // 刷新表格
            this.getUserList();
          });
        }
      });
    },
    clearForm() {
      this.userform = {}; //清除对话框缓存
      this.$refs.userFormRef.clearValidate();
    },
    handleSizeChange(pageSize) {
      this.searchList.pageSize = pageSize;
      this.getUserList();
    },
    handleCurrentChange(pageNo) {
      this.searchList.pageNo = pageNo;
      this.getUserList();
    },
    getUserList() {
      userApi.getUserList(this.searchList).then((response) => {
        this.userList = response.data.rows;
        this.total = response.data.total;
      });
    },
    openEditUI(id) {
      if (id == null) {
        this.title = "新增用户";
      } else {
        this.title = "修改用户";
        // 根据id查数据
        userApi.getUserId(id).then((response) => {
          this.userform = response.data;
        });
      }
      this.dialogFormVisible = true;
    },
  },
  created() {
    this.getUserList();
  },
};
</script>

<style>
.box-s .el-input {
  width: 200px;
  margin-right: 10px;
}
.el-dialog .el-input {
  width: 80%;
}
</style>