package com.focus.base.controller;

import com.focus.base.FocusMicroBaseConstants;
import com.focus.base.api.v1.BaseUserRestService;
import com.focus.base.service.BaseUserService;
import com.focus.base.vm.*;
import com.focus.framework.utils.Message;
import com.github.pagehelper.PageInfo;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BaseUserController implements BaseUserRestService {

    @Autowired
    private BaseUserService userService;

    @Override
    public String getUser() {
        return "test feign";
    }

    @Override
    @RequiresPermissions(value={"baseUser_createUser","administrator"},logical= Logical.OR)
    public Message<String> createUser(BaseUserCreateVM userCreateVM) {
        userService.createUser(userCreateVM);
        return Message.ok(FocusMicroBaseConstants.SUCCESS);
    }

    @Override
    @RequiresPermissions(value={"baseUser_updateUser","administrator"},logical= Logical.OR)
    public Message<String> updateUser(BaseUserUpdateVM userUpdateVM) {
        userService.updateUser(userUpdateVM);
        return Message.ok(FocusMicroBaseConstants.SUCCESS);
    }

    @Override
    @RequiresPermissions(value={"baseUser_deleteUser","administrator"},logical= Logical.OR)
    public Message<String> deleteUser(String userIds) {
        userService.deletUser(userIds);
        return Message.ok(FocusMicroBaseConstants.SUCCESS);
    }

    @Override
    @RequiresPermissions(value={"baseUser_userList","administrator"},logical= Logical.OR)
    public Message<PageInfo<BaseUserListVM>> userList(BaseUserSearchVM serarch) {
        return  Message.ok(userService.userList(serarch));
    }

    @Override
    @RequiresPermissions(value={"baseUser_detail","administrator"},logical= Logical.OR)
    public Message<BaseUserVM> detail(String userId) {
        return Message.ok(userService.detail(userId));
    }

}
