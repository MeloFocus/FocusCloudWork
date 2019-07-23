
# FocusCloud简介
一个以SpringCloud和Shiro为基础的管理系统，已经实现了基础权限功能，后续会开发其他功能</br>

1.可供微服务权限方案的一个参考</br>
[博客介绍了简要搭建过程：](https://blog.csdn.net/u014203449/article/details/88087516)</br>
https://blog.csdn.net/u014203449/article/details/88087516
2.权限前端页面和一些接口还有待完善</br>

# 现有模块
base服务：提供登录、用户角色授权等基础服务</br>
zuul：网关</br>
eureka:注册中心</br>
uaa:其他普通业务服务依赖于uaa，提供授权请求重定向到base</br>
common：公用模块</br>
parent：父pom</br>
notice服务:目前业务没有写，但可以完成服务的登录授权测试，单点登录到base认证，并且调用base服务接口。</br>

# 系统架构
![](https://github.com/MeloFocus/FocusCloudWork/blob/master/img/6.png) 

# 使用框架
SpringCloud Finchley.BUILD-SNAPSHOT,Shiro,Mysql,Redisson,jdk1.8,layiui

# 部署过程
1.将zuul、base、notice服务的application-dev配置文件中的数据库和redis地址改为自己的</br>
2.执行sql，sql这里还不完整，角色资源和权限码的关系还没调整好，可以先用超级管理员实验</br>
3.访问localhost:18900/base/loginpage 超级管理员用户melo 密码123456</br>

#一些截图
![](https://github.com/MeloFocus/FocusCloudWork/blob/master/img/2.png)  
![](https://github.com/MeloFocus/FocusCloudWork/blob/master/img/3.png)  

 
