package com.focus.base.service.impl;

import com.focus.base.domain.basic.BaseAuthority;
import com.focus.base.mapper.extend.BaseAuthorityExtendMapper;
import com.focus.base.service.BaseAuthorityService;
import com.focus.base.vm.BaseAuthorityVM;
import com.focus.framework.utils.Asserts;
import com.focus.framework.utils.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Description
 * @Author Melo
 * @Date 2019/6/9 0009 上午 9:34
 */
@Service
@Transactional
public class BaseAuthorityServiceImpl implements BaseAuthorityService {

    @Autowired
    private BaseAuthorityExtendMapper baseAuthorityExtendMapper;

    @Override
    public List<BaseAuthorityVM> getAuthorityByUser(String userId) {
        Asserts.notEmpty(userId,"用户Id不能为空");
        List<BaseAuthority> authorityList = baseAuthorityExtendMapper.getAuthorityByUser(userId);
        List<BaseAuthorityVM> baseAuthorityVMS = EntityUtils.entity2VMList(authorityList, BaseAuthorityVM.class, "");
        return baseAuthorityVMS;
    }
}
