package com.focus.base.service;

import com.focus.base.vm.BaseResourceTreeVM;
import com.focus.base.vm.BaseResourceVM;

import java.util.List;

public interface BaseResourceService {
    List<BaseResourceVM> indexResource();

    List<BaseResourceVM> resourcesInModule(String moduleCode);

    List<BaseResourceTreeVM> resourceTree();
}
