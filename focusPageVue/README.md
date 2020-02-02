#前端架构

#开发环境
 IDE : VS Code 1.27
 NODE: Node 8.9.x
 NPM : NPM 6.4.x

#技术选型
 前端框架：Vue 2.x
 页面组件：Element 2.x
 状态管理：Vuex 2.x
 后台交互：axios 0.18.x

#项目结构
vue-authui

assets： 图标、字体、图片等静态信息
components： 组件库，对常用组件进行封装
http： 后台交互模块，统一后台接口请求API
mock： Mock模块，模拟接口调用并返回定制数据
router： 路由管理模块，负责页面各种路由配置
store： 状态管理模块，提供组件间状态共享
utils： 工具模块，提供一些通用的工具方法
views： 页面模块，主要放置各种页面视图组件


#1.下载源码
git clone https://github.com/MeloFocus/FocusCloudWork.git

#2.编译代码
进入项目focusPageVue目录下，执行 npm install, 下载和安装项目相关依赖包。


#3.启动系统
执行 npm run dev 命令，启动项目，通过 http://localhost:8080 访问。

#4.修改配置

如果想自定义端口（默认是8080），可以修改 config/index.js 下的 port 属性。

后台接口和备份服务器地址配置在 src/utils/global.js，如有修改请做相应变更。
