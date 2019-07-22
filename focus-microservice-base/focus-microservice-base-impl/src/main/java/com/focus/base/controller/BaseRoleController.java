package com.focus.base.controller;

import com.focus.base.FocusMicroBaseConstants;
import com.focus.base.api.v1.BaseRoleRestService;
import com.focus.base.service.BaseRoleService;
import com.focus.base.vm.*;
import com.focus.framework.utils.Message;
import com.github.pagehelper.PageInfo;
import com.netflix.discovery.converters.Auto;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BaseRoleController implements BaseRoleRestService {

    @Autowired
    BaseRoleService baseRoleService;

    @RequiresPermissions(value={"baseRole_roleList","administrator"},logical= Logical.OR)
    @Override
    public Message<PageInfo<BaseRoleListVM>> roleList(BaseRoleSearchVM search) {
        return Message.ok(baseRoleService.roleList(search));
    }


    @Override
    @RequiresPermissions(value={"baseRole_saveRole","administrator"},logical= Logical.OR)
    public Message<String> saveRole(BaseRoleCreateVM role) {
        baseRoleService.saveRole(role);
        return Message.ok(FocusMicroBaseConstants.SUCCESS);
    }

    @Override
    @RequiresPermissions(value={"baseRole_updateRole","administrator"},logical= Logical.OR)
    public Message<String> updateRole(BaseRoleUpdateVM roleUpdateVM) {
        baseRoleService.updateRole(roleUpdateVM);
        return Message.ok(FocusMicroBaseConstants.SUCCESS);
    }

    @Override
    @RequiresPermissions(value={"baseRole_deleteRole","administrator"},logical= Logical.OR)
    public Message<String> deleteRole(String roleIds) {
        baseRoleService.deleteRole(roleIds);
        return Message.ok(FocusMicroBaseConstants.SUCCESS);
    }

    @Override
    @RequiresPermissions(value={"baseRole_detail","administrator"},logical= Logical.OR)
    public Message<BaseRoleVM> detail(String roleId) {
        return Message.ok(baseRoleService.detail(roleId));
    }
}
