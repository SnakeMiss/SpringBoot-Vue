<template>
  <div class="app-container">
    <el-form label-width="50px">
      <el-form-item label="名称">
        <el-input v-model="persons.name" />
      </el-form-item>
      <el-form-item label="年龄">
        <el-input-number v-model="persons.age" controls-position="right" min="0" />
      </el-form-item>
      <el-form-item label="性别">
        <el-select v-model="persons.sex" clearable placeholder="请选择">
          <!--
            数据类型一定要和取出的json中的一致，否则没法回填
            因此，这里value使用动态绑定的值，保证其数据类型是number
          -->
          <el-option :value="1" label="男" />
          <el-option :value="0" label="女" />
        </el-select>
      </el-form-item>
      <el-form-item label="时间">
    <el-form-item>
        <el-date-picker
          v-model="persons.time"
          type="datetime"
          placeholder="时间"
          value-format="yyyy-MM-dd HH:mm:ss"
          default-time="00:00:00"
        />
      </el-form-item>
       </el-form-item>
      <el-form-item>
        <el-button :disabled="saveBtnDisabled" type="primary" @click="saveOrUpdate">保存</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
import PersonApi from "@/api/table";
export default {
  data() {
    return {
      persons: {
        name: "",
        sex: 0,
        time: "",
        age: "",
      }
    };
  },

  created() {
    console.log("created");
    this.init();
  },

  watch: {
    //监听
    $route(to, from) {
      //路由变化方式，路由发生变化，方法就会执行
      this.init();
    }
  },

  methods: {
    init() {
      if (this.$route.params && this.$route.params.id) {
        const id = this.$route.params.id;
        this.getInfo(id);
      } else {
        this.persons = {};
      }
    },
    //根据id查询讲师的信息
    getInfo(id) {
      PersonApi.getpersonsInfo(id).then(Response => {
        this.persons = Response.data;
      });
    },
    //修改讲师的方法
    saveOrUpdate() {
      PersonApi.saveOrUpdate(this.persons).then(Response => {
            console.log(this.persons.id)
            let state;  
          if(this.persons.id==null){
             state="新增成功"
          }else{
              state="修改成功"
          }
        this.$message({
          type: "success",
          message: state
        });
        //回到列表页面，路由跳转
        this.$router.push({ path: "/list" });
      });
    },
  }
};
</script>
