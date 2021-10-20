<template>
  <div class="app-container">
    <!--查询表单-->
    <el-form :inline="true" class="demo-form-inline">
      <el-form-item>
        <el-input v-model="selectQuery.name" placeholder="姓名" />
      </el-form-item>
      <el-form-item>
        <el-date-picker
          v-model="selectQuery.createTime"
          type="datetime"
          placeholder="选择开始时间"
          value-format="yyyy-MM-dd HH:mm:ss"
          default-time="00:00:00"
        />
      </el-form-item>
      <el-form-item>
        <el-date-picker
          v-model="selectQuery.updateTime"
          type="datetime"
          placeholder="选择截止时间"
          value-format="yyyy-MM-dd HH:mm:ss"
          default-time="00:00:00"
        />
      </el-form-item>
      <el-button type="primary" icon="el-icon-search" @click="getAllList()">查询</el-button>
      <el-button type="default" @click="resetData()">清空</el-button>
       <router-link :to="'/save/'">
        <el-button type="default">新增</el-button>
           </router-link>    
    </el-form>
    <el-table :data="tableData" border style="width: 100%">
      <el-table-column fixed prop="id" label="id" width="200"></el-table-column>
      <el-table-column prop="name" label="姓名" width="120"></el-table-column>
      <el-table-column prop="sex" label="性别" width="120"></el-table-column>
      <el-table-column prop="time" label="日期" width="200"></el-table-column>

      <el-table-column label="操作" width="250">
        <template slot-scope="scope">
          <!-- <el-button @click="handleClick(scope.row.id)" type="text" size="small">查看</el-button> -->
           <router-link :to="'/edit/'+scope.row.id">
          <el-button 
          type="success"
           size="mini"
           icon="el-icon-edit"
           >编辑</el-button>
           </router-link>
          <el-button
            type="danger"
            size="mini"
            icon="el-icon-delete"
            @click="removeDataById(scope.row.id)"
          >删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    <!-- 分页 -->
    <template>
      <el-pagination
        background
        :current-page="page"
        :page-size="limit"
        :total="total"
        style="padding: 30px 0; text-align: center;"
        layout="total, prev, pager, next, jumper"
        @current-change="getAllList"
      />
    </template>
  </div>
</template>
<script>
import list from "@/api/table";
export default {
  data() {
    return {
      tableData: [],
      page: 1, //开始页
      limit: 5, //每页记录数
      total: 0, //总记录数
      selectQuery: {},
    }
  },
  created() {
    //页面渲染之前执行，一般调用methods定义的方法
    this.getAllList();
  },
  methods: {
    getAllList(page = 1) {
      this.page = page;
      list
        .getList(this.page,this.limit,this.selectQuery)
        .then(response => {
          this.tableData = response.data.records;
          console.log(response); //返回数据集合
          this.total = response.data.total;
        })
        .catch(error => {
          //请求失败
          console.log(error);
        });
    }, resetData(){//清空的方法
      //双向绑定输入框的数据清空
      this.selectQuery = {}
      this.getAllList()
    },
   removeDataById(id) {
            this.$confirm('此操作将永久删除, 是否继续?', '提示', {
                confirmButtonText: '确定',
                cancelButtonText: '取消',
                type: 'warning'
            }).then(() => {  //点击确定，执行then方法
                //调用删除的方法
                list.deleteinfo(id)
                    .then(response =>{//删除成功
                    //提示信息
                    this.$message({
                        type: 'success',
                        message: '删除成功!'
                    });
                    //回到列表页面
                    this.getAllList()
                })
            }) //点击取消，执行catch方法
        }
  }
};
</script>

