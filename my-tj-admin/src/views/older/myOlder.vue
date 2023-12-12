<template>
  <div>
    <!-- 内容展示 -->
 
    <el-card>
      <h3>用户信息权限展示</h3>
      <el-table :data="datalist" stripe style="width: 100%">
        <el-table-column prop="id" label="用户ID"> </el-table-column>
        <el-table-column prop="username" label="用户名"> </el-table-column>
        <el-table-column prop="phone" label="电话"> </el-table-column>
        <el-table-column prop="status" label="用户状态">
          <template slot-scope="scope">
            <el-tag v-if="scope.row.status == 1">正常</el-tag>
            <el-tag v-else type="danger">禁止</el-tag>
          </template>
        </el-table-column>
        <el-table-column prop="role" label="角色">
          <template slot-scope="item">
            <el-tag v-if="item.row.role == 1" type="danger">超级管理员</el-tag>
            <el-tag v-else-if="item.row.role == 2" type="primary">管理员</el-tag>
            <el-tag v-if="item.row.role == 3" type="success">用户</el-tag>
          </template>
        </el-table-column>
      </el-table>
    </el-card>
  </div>
</template>

<script>
export default {
  name: "myorder",
  data() {
    return {
      datalist: [],
    };
  },
  created: function () {
    this.getData();
  },
  methods: {
    getData() {
      this.$axios.get("http://localhost:8081/employee/list").then((res) => {
        this.datalist = res.data.data;
        console.log(this.datalist);
      });
    },
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