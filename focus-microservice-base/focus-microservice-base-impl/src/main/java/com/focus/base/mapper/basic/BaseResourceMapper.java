package com.focus.base.mapper.basic;

import com.focus.base.domain.basic.BaseResource;
import java.util.List;

public interface BaseResourceMapper {
    int deleteByPrimaryKey(String id);

    int insert(BaseResource record);

    BaseResource selectByPrimaryKey(String id);

    List<BaseResource> selectAll();

    int updateByPrimaryKey(BaseResource record);
}