package com.focus.base.service;

import com.focus.base.vm.BaseAuthorityVM;

import java.util.List;

public interface BaseAuthorityService {

    List<BaseAuthorityVM> getAuthorityByUser(String userId);
}
