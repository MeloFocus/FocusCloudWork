package com.focus.base.mapper.basic;

import com.focus.base.domain.basic.BaseRoleResourceR;
import java.util.List;

public interface BaseRoleResourceRMapper {
    int deleteByPrimaryKey(String id);

    int insert(BaseRoleResourceR record);

    BaseRoleResourceR selectByPrimaryKey(String id);

    List<BaseRoleResourceR> selectAll();

    int updateByPrimaryKey(BaseRoleResourceR record);
}