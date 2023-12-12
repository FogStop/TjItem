<template>
  <div>
    <el-card>2023年销量总额数据表</el-card>
    <el-card>
      <el-input
        placeholder="请输入月份"
        style="width: 200px"
        suffix-icon="el-icon-search"
      ></el-input>
      <el-button type="primary" style="margin-left: 10px">查询</el-button>
      <el-button type="success">重置</el-button>
    </el-card>
    <!-- 内容展示 -->
    <el-card>
      <el-table
        :data="datalist"
        stripe
        style="width: 100%"
        :header-cell-style="{ background: '#939393', color: '#ffffff', border }"
      >
        <el-table-column label="序号" prop="id"> </el-table-column>
        <el-table-column prop="month" label="月份"> </el-table-column>
        <el-table-column prop="num" label="销售数量"> </el-table-column>
        <el-table-column prop="personnel" label="工作员工数量">
        </el-table-column>
        <el-table-column prop="appraise" label="用户综合评价">
        </el-table-column>
        <el-table-column label="操作">
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
      <el-pagination
        @size-change="handleSizeChange"
        @current-change="handleCurrentChange"
        :current-page="pageNum"
        :page-sizes="[5, 10, 15, 30]"
        :page-size="pageSize"
        layout="total, sizes, prev, pager, next, jumper"
      >
      </el-pagination>
    </el-card>
  </div>
</template>

<script>
import { color } from "echarts";

export default {
  name: "commoncustomer",
  data() {
    return {
      datalist: [],
      pageSize: 10,
      pageNum: 1,
    };
  },
  watch: {
    inputVal(newValue) {
      if (newValue) {
        this.searchData(true);
      } else {
        this.searchData(false);
      }
    },
  },
  created: function () {
    this.getData();
    this.loadPost();
  },
  methods: {
    getData() {
      this.$axios.get("http://localhost:8081/month/list").then((res) => {
        this.datalist = res.data.data;
        console.log(this.datalist);
      });
    },
    
    handleSizeChange(val) {
      console.log(`每页 ${val} 条`);
    },
    handleCurrentChange(val) {
      console.log(`当前页: ${val}`);
    },
  },
};
</script>

<style lang="less" scoped>
</style>