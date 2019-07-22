package com.focus.base.service;

import com.focus.base.domain.basic.BaseUser;
import com.focus.base.vm.*;
import com.github.pagehelper.PageInfo;

public interface BaseUserService {

    BaseUser selectByLoginName(String loginName);

    PageInfo<BaseUserListVM> userList(BaseUserSearchVM serarch);

    void deletUser(String userIds);

    void createUser(BaseUserCreateVM userCreateVM);

    void updateUser(BaseUserUpdateVM userUpdateVM);

    BaseUserVM detail(String userId);
}
