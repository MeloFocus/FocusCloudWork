<template>
  <div>
    <!--flex弹性盒子模型，justify-content：主抽 -->
    <div style="display: flex;justify-content: center;margin-top: 150px" :rules="fieldRules">
      <el-card style="width: 400px">
        <div slot="header" class="clearfix">
          <span>登录</span>
        </div>
        <table>
          <tr>
            <td>用户名</td>
            <td>
              <el-input v-model="user.username" placeholder="请输入用户名"></el-input>
            </td>
          </tr>
          <tr>
            <td>密码</td>
            <td>
              <el-input type="password" v-model="user.password" placeholder="请输入密码" @keydown.enter.native="doLogin"></el-input>
              <!-- @keydown.enter.native="doLogin"当按下enter键的时候也会执行doLogin方法-->
            </td>
          </tr>
          <tr>
            <!-- 占两行-->
            <td colspan="2">
              <!-- 点击事件的两种不同的写法v-on:click和 @click-->
              <!--<el-button style="width: 300px" type="primary" v-on:click="doLogin">登录</el-button>-->
              <!--<el-button style="width: 300px" type="primary" @click="doLogin">登录</el-button>-->
              <el-button style="width: 300px" type="primary" @click="login()">登录</el-button>
            </td>
          </tr>
        </table>
      </el-card>
    </div>
  </div>
</template>

<script>
import mock from '@/mock/index.js'
import Cookies from "js-cookie";
import router from '@/router'
import qs from 'qs';
  export default {
    name: 'Login',
    //单页面中不支持前面的data:{}方式
    data() {
      //相当于以前的function data(){},这是es5之前的写法，新版本可以省略掉function
      return{
        //之前是在里面直接写username，password等等，但是这里要写return
        //因为一个组件不管要不要被其他组件用，只要这样定义了，它就会认为可能这个组件会在其他的组件中使用
        //比如说在这里定义了一个变量，然后把这个组件引入到A组件中，A组件中修改了这个变量
        //同时这个组件也在B组件中引用了，这时候A里面一修改，B里面也变了，它们用的是一个值
        //可是一般来说可能希望在不同的组件中引用的时候，使用不同的值，所以这里要用return
        //这样在A组件和B组件分别引用这个变量的时候是不会互相影响的
        user:{
          username:'melo',
          password:'123456',
          //为了登录方便，可以直接在这里写好用户名和密码的值
        },
        fieldRules: {
          //校验规则
          username: [
            { required: true, message: '请输入账号', trigger: 'blur' },
          ],
          password: [
            { required: true, message: '请输入密码', trigger: 'blur' },
          ]
        }
      }
    },
    methods:{
      doLogin(){//一点击登录按钮，这个方法就会执行
        alert(JSON.stringify(this.user))//可以直接把this.user对象传给后端进行校验用户名和密码
        router.push({ path: '/' });
       //将当前用户名、密码存入数据库

      },
      login(){
        let userInfo = {loginName:this.user.username, password:this.user.password}
       this.$api.login.login(qs.stringify(userInfo)).then(function(res) {
       // this.$api.login.login(userInfo).then((res) => {
             Cookies.set('token', userInfo.password) // 放置token到Cookie
            
             sessionStorage.setItem('user', userInfo.loginName) // 保存用户到本地会话
             router.push({ path: '/' });  // 登录成功，跳转到主页
          }).catch(function(res) {
            alert(res);
          });
      }
    } 
  }
</script>
