package com.focus.base.mapper.basic;

import com.focus.base.domain.basic.BaseRoleBusinessR;
import java.util.List;

public interface BaseRoleBusinessRMapper {
    int deleteByPrimaryKey(String id);

    int insert(BaseRoleBusinessR record);

    BaseRoleBusinessR selectByPrimaryKey(String id);

    List<BaseRoleBusinessR> selectAll();

    int updateByPrimaryKey(BaseRoleBusinessR record);
}