package com.focus.base.mapper.basic;

import com.focus.base.domain.basic.BaseResourceAuthorityR;
import java.util.List;

public interface BaseResourceAuthorityRMapper {
    int deleteByPrimaryKey(String id);

    int insert(BaseResourceAuthorityR record);

    BaseResourceAuthorityR selectByPrimaryKey(String id);

    List<BaseResourceAuthorityR> selectAll();

    int updateByPrimaryKey(BaseResourceAuthorityR record);
}