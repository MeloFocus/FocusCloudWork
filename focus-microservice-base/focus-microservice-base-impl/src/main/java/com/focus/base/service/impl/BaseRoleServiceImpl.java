package com.focus.base.service.impl;

import com.focus.base.FocusMicroBaseConstants;
import com.focus.base.domain.basic.BaseRole;
import com.focus.base.mapper.basic.BaseRoleMapper;
import com.focus.base.mapper.extend.BaseRoleExtendMapper;
import com.focus.base.service.BaseRoleService;
import com.focus.base.util.ShiroUtils;
import com.focus.base.vm.*;
import com.focus.framework.utils.Asserts;
import com.focus.framework.utils.EntityUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class BaseRoleServiceImpl implements BaseRoleService {

    @Autowired
    BaseRoleMapper baseRoleMapper;

    @Autowired
    BaseRoleExtendMapper baseRoleExtendMapper;

    @Override
    public void saveRole(BaseRoleCreateVM role) {
        Asserts.validate(role,"role");
        BaseRole baseRole = EntityUtils.vm2Entity(role, BaseRole.class);

        Date now = new Date();
        String userId = ShiroUtils.currentUser().getId();
        baseRole.setId(UUID.randomUUID().toString());
        baseRole.setCreatDate(now);
        baseRole.setUpdateDate(now);
        baseRole.setCreatUser(userId);
        baseRole.setUpdateUser(userId);
        baseRole.setType(FocusMicroBaseConstants.RoleType.CUSTOMIZE.getValue());
        baseRole.setStatus(FocusMicroBaseConstants.RoleStatus.NORMAL.getValue());

        baseRoleMapper.insert(baseRole);
    }

    @Override
    public void updateRole(BaseRoleUpdateVM roleUpdateVM) {
        Asserts.validate(roleUpdateVM,"roleUpdateVM");

        BaseRole baseRole = EntityUtils.vm2Entity(roleUpdateVM, BaseRole.class);
        baseRole.setUpdateUser(ShiroUtils.currentUser().getId());
        baseRole.setUpdateDate(new Date());

        baseRoleExtendMapper.updateRole(baseRole);
    }

    @Override
    public void deleteRole(String roleIds) {
        Asserts.notEmpty(roleIds);
        List<String> list = Arrays.asList(roleIds.split(","));
        baseRoleExtendMapper.deleteRole(list);
    }

    @Override
    public PageInfo<BaseRoleListVM> roleList(BaseRoleSearchVM search) {
        PageHelper.startPage(search.getPage(),search.getLimit());
        List<BaseRole> baseRoleList = baseRoleMapper.selectAll();
        List<BaseRoleListVM> collect = baseRoleList.stream()
                .parallel()
                .filter(r -> r.getStatus().equals(FocusMicroBaseConstants.RoleStatus.NORMAL.getValue()))
                .sorted(Comparator.comparingInt(BaseRole::getSort))
                .map(r -> EntityUtils.entity2VM(r, BaseRoleListVM.class))
                .collect(Collectors.toList());

        ListIterator<BaseRoleListVM> baseRoleListVMListIterator = collect.listIterator();
        List<BaseRoleListVM> vms = new ArrayList<>();
        while(baseRoleListVMListIterator.hasNext()){
            if (baseRoleListVMListIterator.nextIndex()>=(search.getPage()-1)*search.getLimit())
                vms.add(baseRoleListVMListIterator.next());
            else
                break;
        }


        PageInfo<BaseRoleListVM> list = new PageInfo<>();
        list.setList(vms.stream().limit(search.getLimit()).collect(Collectors.toList()));
        list.setTotal(baseRoleList.size());
        return list;
    }

    @Override
    public BaseRoleVM detail(String roleId) {
        return EntityUtils.entity2VM(baseRoleMapper.selectByPrimaryKey(roleId),BaseRoleVM.class);
    }
}
