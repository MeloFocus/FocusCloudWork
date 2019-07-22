package com.focus.base.mapper.basic;

import com.focus.base.domain.basic.BaseAuthority;
import java.util.List;

public interface BaseAuthorityMapper {
    int deleteByPrimaryKey(String id);

    int insert(BaseAuthority record);

    BaseAuthority selectByPrimaryKey(String id);

    List<BaseAuthority> selectAll();

    int updateByPrimaryKey(BaseAuthority record);
}