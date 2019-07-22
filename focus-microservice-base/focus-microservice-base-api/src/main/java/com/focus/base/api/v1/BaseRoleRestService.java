package com.focus.base.api.v1;

import com.focus.base.FocusMicroBaseConstants;
import com.focus.base.vm.*;
import com.focus.framework.utils.Message;
import com.github.pagehelper.PageInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @Description
 * @Author Melo
 * @Date 2019/6/7 0007 下午 2:44
 */
@FeignClient(name = FocusMicroBaseConstants.SERVICE_APP_ID)
@RequestMapping("/baseRole")
public interface BaseRoleRestService {

    //角色列表
    @GetMapping("/roleList")
    Message<PageInfo<BaseRoleListVM>> roleList(BaseRoleSearchVM search);

    //新增角色
    @PostMapping("/role")
    Message<String> saveRole(BaseRoleCreateVM role);

    //修改角色
    @PutMapping("/role")
    Message<String> updateRole(BaseRoleUpdateVM roleUpdateVM);

    //删除角色
    @DeleteMapping("/role/{roleIds}")
    Message<String> deleteRole(@PathVariable("roleIds")String roleIds);

    @GetMapping("/detail")
    Message<BaseRoleVM> detail(String roleId);
}
