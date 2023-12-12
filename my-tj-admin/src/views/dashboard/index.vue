<template>
  <div>
    <el-row>
      <el-col :span="11">
        <el-card class="box-card">
          <div class="user">
            <img src="@/assets/cat.jpg" />
            <div class="userinfo">
              <p class="name">fog</p>
              <p class="access">超级管理员</p>
            </div>
          </div>
          <div class="login-info">
            <p>上次登录的时间:<span>2022-10-20</span></p>
            <p>上次登录的地点:<span>湖南长沙</span></p>
          </div>
        </el-card>
        <el-card class="box-card" style="margin-top: 20px">
          <el-table :data="tableData" stripe style="width: 100%">
            <el-table-column prop="times" label="日期" width="180">
            </el-table-column>
            <el-table-column prop="name" label="姓名" width="120">
            </el-table-column>
            <el-table-column prop="address" label="地址"></el-table-column>
          </el-table>
        </el-card>
        <el-card class="box-card" style="margin-top: 20px">
          <!-- 统计图 -->
          上半年销售数量：
          <div id="myChart" :style="{ width: '350px', height: '300px' }"></div>
        </el-card>
      </el-col>
      <el-col :span="13" style="padding-left: 20px">
        <el-card class="box-card system_bulletin" style="margin-bottom: 20px">
          <div slot="header" class="system_title">
            <span>系统公告</span>
          </div>
          <div
            v-for="item in systemData"
            :key="item.id"
            class="system_context item">
            <div>
              {{ item.board }}
            </div>
            <div>
              <i :class="`el-icon-timer`"> {{ item.times }}</i>
            </div>
          </div>
        </el-card>
        <el-card class="qyqj">
          <div slot="header" class="system_title">
            <span>企业前景</span>
          </div>
          <ul>
            <li>
              智慧城市通过物联网基础设施、云计算基础设施、地理空间基础设施等新一代信息技术以及维基、社交网络、Fab
              Lab、Living
              Lab、综合集成法、网动全媒体融合通信终端等工具和方法的应用，实现全面透彻的感知、宽带泛在的互联、智能融合的应用以及以用户创新、开放创新、大众创新、协同创新为特征的可持续创新。伴随网络帝国的崛起、移动技术的融合发展以及创新的民主化进程，知识社会环境下的智慧城市是继数字城市之后信息化城市发展的高级形态。
            </li>
            <li>
              智慧城市从概念提出到落地实践，历经十多年建设与发展，我国智慧城市建设数量持续增长。截至
              2019 年，已有 100% 的副省级以上城市、95% 的地级以上城市，总计约
              700
              多个城市(含县级市)提出或在建智慧城市。从在建智慧城市的分布来看，我国已初步形成京津冀、长三角、粤港澳、中西部四大智慧城市群。新型智慧城市建设呈现“区域特色明显”“地域差异化显著”等发展态势，北京、上海、广州、深圳、杭州等城市发展水平相对较高，为全国智慧城市建设提供了借鉴样本。根据
              2017 年度、2019
              年度两次全国范围内的新型智慧城市评价工作，参评城市平均得分由 58.03
              分上升至 68.16 分，涨幅达
              17.46%，惠民服务、精准治理、生态宜居、信息资源、改革创新领域水平均有所提升。智慧城市作为一种新型城市发展形态和治理模式已被社会群体广泛认可和接受，建设新型智慧城市渐成风潮，方兴未艾。以
              5G、物联网、云计算、大数据、人工智能、区块链等为代表的信息技术与新型基础设施建设全面融合，助推智慧城市高质量建设发展。截至
              2022 年 2 月，我国已建成全球最大 5G 网络，累计已建成 5G 基站 150.6
              万个，已有多个 5G
              应用落地实践，涉及交通、教育、医疗、园区、社区、疫情防控等场景。国家层面已经设立江苏无锡、浙江杭州、福建福州、重庆南岸区、江西鹰潭等
              5
              个物联网特色的新型工业化产业示范区，物联网感知设施统筹部署已经成为智慧城市建设的重要内容。上海、兰州、合肥、南京等多地建立了云计算中心，并部署面向人工智能的计算加速资源和边缘计算布局，提供先进的计算技术服务。广东、贵州、浙江、吉林、山东、重庆、广西等大部分省份均成立了政府数据管理机构，承担大数据发展、大数据存储与分析技术研究、数据资源统筹共享等职责，支撑新型智慧城市建设。江苏、广东、山东、陕西等省深入布局“区块链
              +
              智慧城市”项目，其中，数字公民、数字金融、电子证照等领域的建设成效明显。
            </li>
          </ul>
        </el-card>
      </el-col>
    </el-row>
  </div>
</template>
<script>
import * as echarts from "echarts";
export default {
  name: "dashboard",
  data() {
    return {
      tableData: [],
      systemData: [
        {
          id: 1,
          date: "2022-10-21 09:00",
          title: "【内部分享】如何建立良好的客户关系1",
          icon: "timer",
        },
        {
          id: 2,
          date: "2022-10-21 09:00",
          title: "【内部分享】如何建立良好的客户关系2",
          icon: "timer",
        },
        {
          id: 3,
          date: "2022-10-21 09:00",
          title: "【内部分享】如何建立良好的客户关系3",
          icon: "timer",
        },
        {
          id: 4,
          date: "2022-10-21 09:00",
          title: "【内部分享】如何建立良好的客户关系4",
          icon: "timer",
        },
        {
          id: 5,
          date: "2022-10-21 09:00",
          title: "【内部分享】如何建立良好的客户关系5",
          icon: "timer",
        },
        {
          id: 6,
          date: "2022-10-21 09:00",
          title: "【内部分享】如何建立良好的客户关系6",
          icon: "timer",
        },
      ],
      data: [
        { value: 1048, name: "Search Engine" },
        { value: 735, name: "Direct" },
        { value: 580, name: "Email" },
        { value: 484, name: "Union Ads" },
        { value: 300, name: "Video Ads" },
      ],
    };
  },
  created: function () {
    this.getData();
    this.getSysData();
  },
  mounted() {
    this.Draw(),
      this.$axios
        .get("http://127.0.0.1:8081/book")
        .then((res) => {
          // 读取接口请求成功回传回来的数据
          var books = res.data.data;
          // 定义数组，存放一会覆盖echarts图形的数据
          var data = [];
          // 循环遍历数组，取出数据，转成和data一样的格式
          for (var i = 0; i < books.length; i++) {
            var d = { name: "", value: 0 };
            d.name = books[i].name;
            d.value = books[i].num;
            // 往data数组中添加数据
            data.push(d);
          }
          // 排序，b - a降序——a - b升序
          //  data.sort((a , b) => b.value - a.value)
          // 覆盖data(){}中全局变量的数据
          this.data = data;
          // 画出图形
          this.Draw();
        })
        .catch((err) => {
          console.log(err);
          alert("请求失败！请检查后端接口！！！！");
        });
    this.$axios.get("http:127.0.0.1:8081/list").then((res) => {
      console.log(res.data);
    });
  },
  methods: {
    getSysData() {
      this.$axios.get("http://localhost:8081/za/list").then((res) => {
        this.systemData = res.data.data;
      });
    },
    getData() {
      this.$axios.get("http://localhost:8081/za/list").then((res) => {
        this.tableData = res.data.data;
      });
    },
    Draw() {
      let myChart = this.$echarts.init(document.getElementById("myChart"));

      myChart.setOption({
        tooltip: {
          trigger: "item",
        },
        legend: {
          top: "5%",
          left: "center",
        },
        series: [
          {
            name: "Access From",
            type: "pie",
            radius: ["40%", "70%"],
            avoidLabelOverlap: false,
            itemStyle: {
              borderRadius: 10,
              borderColor: "#fff",
              borderWidth: 2,
            },
            label: {
              show: false,
              position: "center",
            },
            emphasis: {
              label: {
                show: true,
                fontSize: 40,
                fontWeight: "bold",
              },
            },
            labelLine: {
              show: false,
            },
            data: this.data,
          },
        ],
      });
    },
  },
};
</script>
<style lang="less" scoped>
.qyqj {
  line-height: 30x;
  text-indent: 24px;
}
.user {
  padding-bottom: 20px;
  margin-bottom: 20px;
  border-bottom: 1px solid #999;
  display: flex;
  align-items: center;
  img {
    margin-left: 30px;
    width: 100px;
    height: 100px;
    border-radius: 40%;
  }
  .userinfo {
    margin-left: 40px;
    .name {
      font-size: 32px;
      margin-bottom: 10px;
    }
    .access {
      color: #999;
      margin-top: 0px;
    }
  }
}
.login-info {
  margin: 0px 0px;
  .el-table__row {
    td {
      height: 60px;
    }
  }
  p {
    font-size: 14px;
    color: #999999;
    line-height: 20px;
    span {
      color: #666666;
      margin-left: 20px;
    }
  }
  .el-card__body {
    padding: 10px;
  }
}

.system_bulletin {
  .system_title {
    font-size: 22px;
    color: #000000;
  }
  .system_context {
    padding-bottom: 10px;
    border-bottom: 1px #f2f2f2 solid;
    margin-bottom: 10px;
    display: flex;
    justify-content: space-between; //两端对齐
    align-items: center;
  }
}
</style>