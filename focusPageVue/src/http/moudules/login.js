import axios from '../axios'

/* 
 * 系统登录模块
 */

// 登录
export const login = data => {
    return axios({
        // url: 'http://:8080/login',
        // url: 'http://47.98.153.30:18900/base/login',
        url: '/base/login',
        method: 'post',
        data
    })
}

// 登出
export const logout = () => {
    return axios({
        url: 'logout',
        method: 'get'
    })
}
