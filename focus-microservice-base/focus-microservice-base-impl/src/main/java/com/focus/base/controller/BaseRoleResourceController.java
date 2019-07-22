package com.focus.base.controller;

import com.focus.base.FocusMicroBaseConstants;
import com.focus.base.api.v1.BaseRoleResourceRestService;
import com.focus.base.service.BaseRoleResourceService;
import com.focus.base.vm.BaseRoleResourceSaveVM;
import com.focus.framework.utils.Message;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BaseRoleResourceController implements BaseRoleResourceRestService {

    @Autowired
    BaseRoleResourceService baseRoleResourceService;

    @Override
    @RequiresPermissions(value={"baseRoleResource_authorize","administrator"},logical= Logical.OR)
    public Message<String> authorize(BaseRoleResourceSaveVM roleResourceSaveVM) {
        baseRoleResourceService.authorize(roleResourceSaveVM);
        return Message.ok(FocusMicroBaseConstants.SUCCESS);
    }
}
