package com.focus.base.mapper.basic;

import com.focus.base.domain.basic.BaseUserRoleR;
import java.util.List;

public interface BaseUserRoleRMapper {
    int deleteByPrimaryKey(String id);

    int insert(BaseUserRoleR record);

    BaseUserRoleR selectByPrimaryKey(String id);

    List<BaseUserRoleR> selectAll();

    int updateByPrimaryKey(BaseUserRoleR record);
}