package com.focus.base.service;

import com.focus.base.vm.BaseRoleAuthorizeListVM;
import com.focus.base.vm.BaseRoleVM;
import com.focus.base.vm.BaseUserRoleSaveVM;

import java.util.List;

public interface BaseUserRoleService {

    void authorize(BaseUserRoleSaveVM baseUserRoleSaveVM);

    List<BaseRoleVM> roleOfUser(String userId);

    List<BaseRoleAuthorizeListVM> roleAuthorizeList(String userId);
}
