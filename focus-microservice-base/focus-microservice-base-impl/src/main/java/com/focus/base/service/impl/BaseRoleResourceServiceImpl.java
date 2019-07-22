package com.focus.base.service.impl;

import com.focus.base.domain.basic.BaseRoleResourceR;
import com.focus.base.mapper.extend.BaseRoleResourceRExtendMapper;
import com.focus.base.service.BaseRoleResourceService;
import com.focus.base.vm.BaseRoleResourceSaveVM;
import com.focus.framework.utils.Asserts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class BaseRoleResourceServiceImpl implements BaseRoleResourceService {

    @Autowired
    BaseRoleResourceRExtendMapper baseRoleResourceRExtendMapper;

    @Override
    public void authorize(BaseRoleResourceSaveVM roleResourceSaveVM) {
        Asserts.validate(roleResourceSaveVM,"roleResourceSaveVM");
        if(roleResourceSaveVM.getResourceIds()==null){
            baseRoleResourceRExtendMapper.deleteByRoleIds(roleResourceSaveVM.getRoleIds());
            return;
        }

        List<BaseRoleResourceR> list = new ArrayList<>();
        roleResourceSaveVM.getResourceIds().forEach((reourceId)->{
            roleResourceSaveVM.getRoleIds().forEach((roleId)->{
                list.add(new BaseRoleResourceR(UUID.randomUUID().toString(),roleId,reourceId));
            });
        });
        baseRoleResourceRExtendMapper.deleteByRoleIds(roleResourceSaveVM.getRoleIds());
        baseRoleResourceRExtendMapper.batchInsert(list);
    }
}
