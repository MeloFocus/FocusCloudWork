<template>
  <div class="page">
    <h2 class="header">Vue Focus Cloud前端代码部署指导</h2>
    <div class="intro">
      <p>前端代码地址：<a href="https://github.com/MeloFocus/FocusCloudWork.git">https://github.com/MeloFocus/FocusCloudWork.git</a>
        , 项目使用指南如下图，具体环境搭建参考安装教程。
      </p>
    </div>
    <div>
      <div class="title">使用指南</div>
      <div class="step">
        <span>1.下载源码</span>
      </div>
      <div class="intro">
      <p>git clone https://github.com/MeloFocus/FocusCloudWork.git</p>
      </div>
    </div>
    <div>
      <div class="step">
        <span>2.编译代码</span>
      </div>
      <div class="intro">
      <p>进入项目focusPageVue目录下，执行 npm install, 下载和安装项目相关依赖包。</p>
      </div>
    </div>
    <div>
      <div class="step">
        <span>3.启动系统</span>
      </div>
      <div class="intro">
      <p>执行 npm run dev 命令，启动项目，通过 http://localhost:8080 访问。</p>
      </div>
    </div>
    <div>
      <div class="step">
        <span>3.修改配置</span>
      </div>
      <div class="intro">
      <p>如果想自定义端口（默认是8080），可以修改 config/index.js 下的 port 属性。</p>
      <p>后台接口和备份服务器地址配置在 src/utils/global.js，如有修改请做相应变更。</p>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: 'Intro'
}
</script>

<style>
.header {
  font-size: 28px;
  text-align: left;
  padding: 10px;
}
.intro {
  font-size: 18px;
  text-align: left;
  padding-left: 10px;
}
.title {
  font-size: 30px;
  text-align: left;
  padding: 10px;
}
.step {
  font-size: 18px;
  text-align: left;
  padding: 10px;
}

</style>
