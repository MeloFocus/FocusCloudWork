import axios from '../axios'

/* 
 * 用户管理模块
 */
// 分页查询
export const findPage = () => {
    return axios({
        url: '/base/baseUser/user/list?page=1&limit=10',
        method: 'get'
    })
}
// 新增用户

export const save = (data) => {
    return axios({
        url: '/base/baseUser/user',
        method: 'post',
        data
    })
}

// 编辑用户
export const editUser = (data) => {
    return axios({
        url: '/base/baseUser/user',
        method: 'put',
        data
    })
}

// 删除单个数据
export const handleOneDelete = () => {
    return axios({
        // url: '/user/delete',
        url: 'base/baseUser/user/userIds=ae1ac855-8ce3-459f-8522-5dd3167cdc0f',
        method: 'delete',
    })
}

// 查询用户授权列表
export const findUserAuth = (params) => {
    return axios({
        url: '/base/baseUserRole/roleList',
        method: 'get',
        params
    })
}

// 保存用户授权列表
export const saveUserAuth = (data) => {
    return axios({
        url: '/base/baseUserRole/authoiize',
        method: 'post',
        data
    })
}

// 批量删除
export const batchDelete = (data) => {
    return axios({
        url: '/user/delete',
        method: 'post',
        data
    })
}


// 查找用户的菜单权限标识集合
export const findPermissions = (params) => {
    return axios({
        url: '/user/findPermissions',
        method: 'get',
        params
    })
}