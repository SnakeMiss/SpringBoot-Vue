import Vue from "vue";
import Router from "vue-router";
import Layout from "@/pages/layout/layout.vue";

Vue.use(Router);

var router = new Router({
  routes: [
    // 刚进入页面时，进入homePage页面
    // {
    //   path: "/",
    //   redirect: "/homePage"
    // },
    {
      path: "/",
      redirect: "/homePage"
    },
    // 输入不匹配此页面中定义的路由时，跳转到homePage页面
    // 防止在导航栏随便输入，进入空白页，这里重定向到homePage页面
    // 侧边栏 首页 路由地址
    {
      path: "/",
      name: "Layout",
      component: Layout,
      children: [
        {
          path: "homePage",
          name: "homePage",
          component: () => import("@/pages/home/homePage")
        }
      ]
    },
    // 侧边栏 导航一 路由地址
    {
      path: "/",
      name: "Layout",
      component: Layout,
      // 三个 子路由 路由地址
      children: [
        {
          path: "list",
          name: "list",
          component: () => import("@/pages/views/list")
        },
        {
          path: "save",
          name: "save",
          component: () => import("@/pages/views/save")
        },
        {
          path: 'edit/:id',   
          name: 'EduTeacherEdit',
          component: () => import('@/pages/views/save'),
          meta: { title: '编辑', noCache: true },
          hidden: true
        }
      ]
    }

  ]
});

//解决重复点击路由时，控制台报错
//获取原型对象上的push函数
const originalPush = Router.prototype.push;
//修改原型对象中的push方法
Router.prototype.push = function push(location) {
  return originalPush.call(this, location).catch(err => err);
};

// router.beforeEach((to, from, next) => {
// })

// 全局前置守卫
// 当一个导航触发时，全局前置守卫按照创建顺序调用。
// 守卫是异步解析执行，此时导航在所有守卫 resolve 完之前一直处于 等待中
export default router;
