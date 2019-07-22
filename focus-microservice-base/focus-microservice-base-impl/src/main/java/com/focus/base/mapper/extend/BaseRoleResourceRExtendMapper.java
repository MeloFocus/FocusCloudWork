package com.focus.base.mapper.extend;

import com.focus.base.domain.basic.BaseRoleResourceR;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BaseRoleResourceRExtendMapper {
    void batchInsert(@Param("list") List<BaseRoleResourceR> list);

    void deleteByRoleIds(@Param("list")List<String> roleIds);
}