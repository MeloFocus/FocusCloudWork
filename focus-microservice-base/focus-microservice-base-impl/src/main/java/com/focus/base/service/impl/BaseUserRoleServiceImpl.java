package com.focus.base.service.impl;

import com.focus.base.FocusMicroBaseConstants;
import com.focus.base.api.v1.BaseUserRoleRestService;
import com.focus.base.domain.basic.BaseRole;
import com.focus.base.domain.basic.BaseUserRoleR;
import com.focus.base.mapper.basic.BaseRoleMapper;
import com.focus.base.mapper.extend.BaseUserRoleRExtendMapper;
import com.focus.base.service.BaseUserRoleService;
import com.focus.base.vm.BaseRoleAuthorizeListVM;
import com.focus.base.vm.BaseRoleVM;
import com.focus.base.vm.BaseUserRoleSaveVM;
import com.focus.framework.utils.Asserts;
import com.focus.framework.utils.EntityUtils;
import com.focus.framework.utils.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
public class BaseUserRoleServiceImpl implements BaseUserRoleService {

    @Autowired
    BaseRoleMapper baseRoleMapper;

    @Autowired
    BaseUserRoleRExtendMapper baseUserRoleRExtendMapper;

    @Override
    public void authorize(BaseUserRoleSaveVM baseUserRoleSaveVM) {
        Asserts.validate(baseUserRoleSaveVM,"baseUserRoleSaveVM");
        if(baseUserRoleSaveVM.getRoleIds()==null){
            baseUserRoleRExtendMapper.deleteByUserIds(baseUserRoleSaveVM.getUserIds());
            return;
        }
        baseUserRoleRExtendMapper.deleteByUserIds(baseUserRoleSaveVM.getUserIds());
        List<BaseUserRoleR> list = new ArrayList<>();
        baseUserRoleSaveVM.getUserIds().forEach((userId)->{
            baseUserRoleSaveVM.getRoleIds().forEach((roleId)->{
                list.add(new BaseUserRoleR(UUID.randomUUID().toString(),userId,roleId,null));
            });
        });
        baseUserRoleRExtendMapper.batchInsert(list);
    }

    @Override
    public List<BaseRoleVM> roleOfUser(String userId) {
        Asserts.notEmpty(userId);
        List<BaseRole> list = baseUserRoleRExtendMapper.roleOfUser(userId);
        return EntityUtils.entity2VMList(list,BaseRoleVM.class);
    }

    @Override
    public List<BaseRoleAuthorizeListVM> roleAuthorizeList(String userId) {
        List<BaseRole> baseRoleList = baseRoleMapper.selectAll();
        List<BaseRoleAuthorizeListVM> collect = baseRoleList.stream()
                .filter(role -> role.getStatus().equals(FocusMicroBaseConstants.RoleStatus.NORMAL.getValue()))
                .sorted(Comparator.comparingInt(BaseRole::getSort))
                .map(role -> EntityUtils.entity2VM(role, BaseRoleAuthorizeListVM.class))
                .collect(Collectors.toList());

        List<String> list = baseUserRoleRExtendMapper.roleOfUser(userId).stream().map(BaseRole::getId).collect(Collectors.toList());
        for (BaseRoleAuthorizeListVM role:collect) {
            if (list.contains(role.getId()))
                role.setChecked(true);
        }
        return collect;
    }
}
