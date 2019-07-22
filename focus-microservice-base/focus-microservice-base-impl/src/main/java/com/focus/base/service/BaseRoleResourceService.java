package com.focus.base.service;


import com.focus.base.vm.BaseRoleResourceSaveVM;

public interface BaseRoleResourceService {

    void authorize(BaseRoleResourceSaveVM roleResourceSaveVM);
}
