<template>
  <div class="home">
    <h3>2023及其往年利润分析展示图</h3>
    <!-- 限定空间的大小，及其id绑定 -->
    <el-col :span="12">
      <div id="myChart" :style="{ width: '650px', height: '500px' }"></div>
      <div id="myGather" :style="{ width: '650px', height: '500px' }"></div>
    </el-col>
    <el-col :span="12">
      <div id="Chart02" :style="{ width: '650px', height: '500px' }"></div>
      <div id="myGather2" :style="{ width: '650px', height: '500px' }"></div>
    </el-col>
  </div>
</template>

<script>
export default {
  name: "customerlist",
  data() {
    return {
      // 要显示的数据进行数据map展示
      data: [
        { month: "xiaohh", num: "1" },
        { month: "xiaohh", num: "4" },
        { month: "xiaohh", num: "5" },
        { month: "xiaohh", num: "2" },
      ],
      data1: [],
      data02: [
        { month: "xiaohh", personnel: "1" },
        { month: "xiaohh", personnel: "4" },
        { month: "xiaohh", personnel: "5" },
        { month: "xiaohh", personnel: "2" },
      ],
      gatherdata: [
        { year: "xiaohh", yearnum: "1" },
        { year: "xiaohh", yearnum: "4" },
        { year: "xiaohh", yearnum: "5" },
        { year: "xiaohh", yearnum: "2" },
      ],
      gatherdata02: [
        { gatheruser: "xiaohh", gatherusernum: "1" },
        { gatheruser: "xiaohh", gatherusernum: "4" },
        { gatheruser: "xiaohh", gatherusernum: "5" },
        { gatheruser: "xiaohh", gatherusernum: "2" },
      ],
    };
  },
  mounted() {
    // 调用并且改方法
    this.Draw();
    this.Draw2();
    // axios调用后端接口
    this.$axios
      .get("http://localhost:8081/month/list")
      .then((res) => {
        // 获取后台数据，进行查看，看看是什么形式的数据，必要时进行转换
        console.log(res.data.data);
        // 读取接口请求成功回传回来的数据
        var books = res.data.data;
        // 定义数组，存放一会覆盖echarts图形的数据
        var data = [];
        // 循环遍历数组，取出数据，转成和data一样的格式
        for (var i = 0; i < books.length; i++) {
          var d = { month: "", num: 0, personnel: 0 };
          d.month = books[i].month;
          d.personnel = books[i].personnel;
          d.num = books[i].num;
          // 往data数组中添加数据
          data.push(d);
        }
        // 排序，b - a降序——a - b升序
        //  data.sort((a , b) => b.num - a.num)
        // 覆盖data(){}中全局变量的数据
        this.data = data;
        // 画出图形
        this.Draw();
        this.Draw2();
      })
      .catch((err) => {
        console.log(err);
        alert("请求失败，接口错误！");
      });
    this.Gather();
    this.$axios
      .get("http://localhost:8081/gather/list")
      .then((res) => {
        // 获取后台数据，进行查看，看看是什么形式的数据，必要时进行转换
        console.log(res.data.data);
        // 读取接口请求成功回传回来的数据
        var gathers = res.data.data;
        // 定义数组，存放一会覆盖echarts图形的数据
        var data = [];
        // 循环遍历数组，取出数据，转成和data一样的格式
        for (var i = 0; i < gathers.length; i++) {
          var d = { year: "", yearnum: 0 };
          d.year = gathers[i].year;
          d.yearnum = gathers[i].yearnum;
          // 往data数组中添加数据
          data.push(d);
        }
        // 排序，b - a降序——a - b升序
        //  data.sort((a , b) => b.num - a.num)
        // 覆盖data(){}中全局变量的数据
        this.gatherdata = data;
        // 画出图形
        this.Gather();
      })
      .catch((err) => {
        console.log(err);
        alert("请求失败，接口错误！");
      });
    this.Gather2();
    this.$axios
      .get("http://localhost:8081/gather/list")
      .then((res) => {
        // 获取后台数据，进行查看，看看是什么形式的数据，必要时进行转换
        console.log(res.data.data);
        // 读取接口请求成功回传回来的数据
        var gathers = res.data.data;
        // 定义数组，存放一会覆盖echarts图形的数据
        var data = [];
        // 循环遍历数组，取出数据，转成和data一样的格式
        for (var i = 0; i < gathers.length; i++) {
          var d = { gatheruser: "", gatherusernum: 0 };
          d.gatheruser = gathers[i].gatheruser;
          d.gatherusernum = gathers[i].gatherusernum;
          // 往data数组中添加数据
          data.push(d);
        }
        // 排序，b - a降序——a - b升序
        //  data.sort((a , b) => b.num - a.num)
        // 覆盖data(){}中全局变量的数据
        this.gatherdata02 = data;
        // 画出图形
        this.Gather2();
      })
      .catch((err) => {
        console.log(err);
        alert("请求失败，接口错误！");
      });
  },
  methods: {
    // 定义echarts的方法进行显示
    Draw() {
      // axios调用后端接口
      this.$axios
        .get("http://localhost:8081/month/list")
        .then((res) => {
          // 获取后台数据，进行查看，看看是什么形式的数据，必要时进行转换
          console.log(res.data.data);
          // 读取接口请求成功回传回来的数据
          let getFunc = res.data.data;
          console.log(getFunc);
          var max = getFunc[0].num;
          for (var i = 0; i < getFunc.length; i++) {
            if (getFunc[i].num > max) {
              max = getFunc[i].num;
            }
          }
          console.log(max);
          // console.log(getFunc.itemStyle.color);
          console.log(getFunc);
          // 定义数组，存放一会覆盖echarts图形的数据
          var data_data = [];
          var data_tx = [],
            k;
          // 循环遍历数组，取出数据，转成和data一样的格式
          for (var i = 0; i < getFunc.length; i++) {
            var d = { month: "", num: 0, personnel: 0 };
            d.month = getFunc[i].month;
            d.personnel = getFunc[i].personnel;
            d.num = getFunc[i].num;
            // 往data数组中添加数据
            if (max == getFunc[i].num) {
              data_data.push({
                value: getFunc[i].num,
                itemStyle: {
                  color: "#a90000",
                },
              });
            } else {
              data_data.push({ value: getFunc[i].num });
            }
            data_tx.push({ value: getFunc[i].month });
          }
          // 基于准备好的dom，初始化echarts，绘制图表
          let myChart = this.$echarts.init(document.getElementById("myChart"));
          //  配置项
          myChart.setOption({
            title: {
              text: "2023数量销售分析图",
            },
            tooltip: {},
            legend: {
              data: ["月份销售数量"],
            },
            xAxis: {
              type: "category",
              data: data_tx,
            },
            yAxis: {
              type: "value",
            },
            series: [
              {
                name: "月份销售数量",
                data: data_data,
                type: "bar",
              },
            ],
          });
        })
        .catch((err) => {
          console.log(err);
          alert("请求失败，接口错误！");
        });
    },
    Draw2() {
      let myChart = this.$echarts.init(document.getElementById("Chart02"));
      myChart.setOption({
        title: {
          text: "2023用户数量分布图",
        },
        tooltip: {},
        legend: {
          data: ["用户数量"],
        },
        xAxis: {
          type: "category",
          data: this.data.map((d) => d.month),
        },
        yAxis: {
          type: "value",
        },
        series: [
          {
            name: "用户数量",
            type: "bar",
            data: this.data.map((d) => d.personnel),
            type: "line",
            // 弯曲
            // smooth: true,
          },
        ],
      });
    },
    Gather() {
      let myGather = this.$echarts.init(document.getElementById("myGather"));
      myGather.setOption({
        title: {
          text: "往年销售量数据分析",
        },
        tooltip: {},
        legend: {
          data: ["销售额总额"],
        },
        xAxis: {
          type: "category",
          data: this.gatherdata.map((d) => d.year),
        },
        yAxis: {
          type: "value",
        },
        series: [
          {
            name: "销售额总额",
            type: "bar",
            data: this.gatherdata.map((d) => d.yearnum),
            type: "line",
          },
        ],
      });
    },
    Gather2() {
      let myGather2 = this.$echarts.init(document.getElementById("myGather2"));
      myGather2.setOption({
        title: {
          text: "往年用户数据分析",
        },
        tooltip: {
          trigger: "axis",
          axisPointer: {
            type: "shadow",
          },
        },
        legend: {
          data: ["用户数量"],
        },
        grid: {
          left: "3%",
          right: "4%",
          bottom: "3%",
          containLabel: true,
        },
        xAxis: [
          {
            type: "category",
            data: this.gatherdata02.map((d) => d.gatheruser),
            axisTick: {
              alignWithLabel: true,
            },
          },
        ],
        yAxis: [
          {
            type: "value",
          },
        ],
        series: [
          {
            name: "用户数量",
            type: "bar",
            barWidth: "60%",
            data: this.gatherdata02.map((d) => d.gatherusernum),
          },
        ],
      });
    },
  },
};
</script>
<style lang="less">
.home {
  h3 {
    text-align: center;
  }
}
</style>