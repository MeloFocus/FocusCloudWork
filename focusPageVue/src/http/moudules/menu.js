import axios from '../axios'

/* 
 * 菜单管理模块
 */
// 查找横向导航菜单树
export const findHeadBar = () => {
    return axios({
        url: '/base/baseResource/indexResource',
        method: 'get'
    })
}

// 查询当前横向带单对应的左侧列表
export const findClickRoute = (params) => {
    return axios({
        url: '/base/baseResource/resourcesInModule',
        method: 'get',
        params
    })
}

