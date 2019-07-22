package com.focus.base.mapper.basic;

import com.focus.base.domain.basic.BaseRole;
import java.util.List;

public interface BaseRoleMapper {
    int deleteByPrimaryKey(String id);

    int insert(BaseRole record);

    BaseRole selectByPrimaryKey(String id);

    List<BaseRole> selectAll();

    int updateByPrimaryKey(BaseRole record);
}