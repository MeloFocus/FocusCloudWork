import axios from '../axios'

/* 
 * 角色管理模块
 */

 // 分页查询
export const findPage = () => {
    return axios({
        url: '/base/baseRole/roleList?page=1&limit=10',
        method: 'get'
    })
}

// 新增角色

export const save = (data) => {
    return axios({
        url: '/base/baseRole/role',
        method: 'post',
        data
    })
}

// 编辑当前角色
export const editRole = (data) => {
    return axios({
        url: '/base/baseRole/role',
        method: 'put',
        data
    })
}

// 删除单个数据
export const handleOneDelete = () => {
    return axios({
        url: 'base/baseRole/role/sdfefwertfe3br1234124412312',
        method: 'delete'
    })
}


// 查找权限管理下面的导航树(资源管理/角色管理下面的授权弹窗需展示)
export const findResourceTree = () => {
    return axios({
        url: '/base/baseResource/resourceTree',
        method: 'get'
    })
}

// 删除
export const batchDelete = (data) => {
    return axios({
        url: '/role/delete',
        method: 'post',
        data
    })
}

// 查询全部
export const findAll = () => {
    return axios({
        url: '/role/findAll',
        method: 'get'
    })
}
// 查询角色菜单集合
export const findRoleMenus = (params) => {
    return axios({
        url: '/role/findRoleMenus',
        method: 'get',
        params
    })
}
// 保存角色菜单集合
export const saveRoleMenus = (data) => {
    return axios({
        // url: '/role/saveRoleMenus',
        url: '/base/baseUserRole/authoiize',
        method: 'post',
        data
    })
}