<template> 
  <div class="container" :class="$store.state.app.collapse?'menu-bar-collapse-width':'menu-bar-width'">
    <!-- 导航菜单隐藏显示切换 -->
    <span class="collapse-switcher" @click.prevent="collapse">
      <i class="el-icon-menu"></i>
    </span>
    <!-- 导航菜单 -->
    <span class="nav-bar" v-for="headBarMenu in headBarData">
      <el-menu :default-active="activeIndex" class="el-menu-demo" text-color="#fff"
          active-text-color="#ffd04b" mode="horizontal" @select="selectNavBar()"
          v-loading="menuLoading">
        <el-menu-item :key="headBarMenu.id" 
                      :data="headBarMenu" 
                      :index="headBarMenu.name" 
                      @click="handleClickRoute(headBarMenu)" 
                       >{{headBarMenu.name}}
        </el-menu-item>
      </el-menu>
    </span>
    <span class="tool-bar">
      <!-- 主题切换 -->
    
      <!-- 语言切换 -->
        
      <!-- 用户信息 -->
      <el-dropdown class="user-info-dropdown" trigger="hover">
        <span class="el-dropdown-link"><img :src="this.userAvatar" /> {{username}}</span>
        <el-dropdown-menu slot="dropdown">
          <el-dropdown-item>用户信息</el-dropdown-item>
          <el-dropdown-item>设置</el-dropdown-item>
          <el-dropdown-item divided @click.native="logout">退出</el-dropdown-item>
        </el-dropdown-menu>
      </el-dropdown>
    </span>
  </div>
</template>

<script>
import mock from "@/mock/index.js";
import vuex from 'vuex'
export default {
  data() {
    return {
      isCollapse: false,
      username: "SmallRain",
      userAvatar: "",
      activeIndex: "",
      headBarData: [],//一级菜单展示
      headMenuData: [],//二级菜单展示
      menuLoading: false,
      moduleCode: ''
    };
  },
  methods: {
    // 获取横向展示导航栏
		findHeadBar: function () {
			this.menuLoading = true
			this.$api.menu.findHeadBar().then((res) => {
        if(res.status == 502){
           this.$message({ message: res.data, type: 'error' })
           return
        }else if(res.status == 200){
          //将后台传来的数据进行转换。转换成所需要的的数据 
          this.headBarData = res.data
          this.activeIndex = res.data[0].name
        }
				this.menuLoading = false
			})
		},
    // 点击横向菜单，跳转至对应的页面
    handleClickRoute: function (headBarMenu) {

      //修改高亮菜单
        this.activeIndex = headBarMenu.name
       //当前服务器反应，过慢，先把加载框取消
       // this.menuLoading = true
      	this.$api.menu.findClickRoute({'moduleCode':headBarMenu.code}).then((res) => {
          //跳转至对应页面
        if(res.status == 502){
           this.$message({ message: res.data, type: 'error' })
           return
        }else if(res.status == 200){
          //动态展示菜单并调转至对应路由
          this.headMenuData = res.data
          //存在无二级菜单时，展示展示404页面
          if(this.headMenuData.length == 0){
            this.headMenuData = [{
            "id": "fd2da964-f2d7-1037-9a77-451bb43a0465",
            "name": "待开发",
            "icon": "el-icon-more-outline",
            "menuRoute": "404"
        }]
        }
          this.$store.commit('setNavTree',this.headMenuData)
        }
				this.menuLoading = false
			})

    },
    selectNavBar(key, keyPath) {
      console.log(key, keyPath)
    },
    // 语言切换
    handleCommand(command) {
      let array = command.split(':')
      let lang = array[0] === '' ? 'zh_cn' : array[0]
      let label = array[1]
      document.getElementById("language").innerHTML = label
      this.$i18n.locale = lang
    },
    //折叠导航栏
    collapse: function() {
     this.$store.commit('collapse');
    },
    //退出登录
    logout: function() {
      var _this = this;
      this.$confirm("确认退出吗?", "提示", {
        type: "warning"
      })
      .then(() => {
        sessionStorage.removeItem("user");
        this.$router.push
        ("/login");
      })
      .catch(() => {});
    }
  },
  mounted() {
    this.findHeadBar()
    this.sysName = "Focus Cloud";
    var user = sessionStorage.getItem("user");
    if (user) {
      this.userName = user;
      this.userAvatar = require("@/assets/user.png");
    }
  }
};
</script>

<style scoped lang="scss">
.container {
  position: absolute;
  left: 200px;
  right: 0px;
  height: 60px;
  line-height: 60px;
  .collapse-switcher {
    width: 40px;
    float: left;
    cursor: pointer;
    border-color: rgba(111, 123, 131, 0.8);
    border-left-width: 1px;
    border-left-style: solid;
    border-right-width: 1px;
    border-right-style: solid;
    color: white;
    background: #504e6180;
  }
  .nav-bar {
    margin-left: auto;
    float: left;
    .el-menu {
      background: #504e6180;
    }
  }
  .tool-bar {
    float: right;
    .theme-picker {
      padding-right: 10px;
    }
    .lang-selector {
      padding-right: 10px;
      font-size: 15px;
      color: #fff;
      cursor: pointer;
    }
    .user-info-dropdown {
      font-size: 20px;
      padding-right: 20px;
      color: #fff;
      cursor: pointer;
      img {
        width: 40px;
        height: 40px;
        border-radius: 10px;
        margin: 10px 0px 10px 10px;
        float: right;
      }
    }
  }

 
}

.menu-bar-width {
  left: 200px;
}
.menu-bar-collapse-width {
  left: 65px;
}
</style>