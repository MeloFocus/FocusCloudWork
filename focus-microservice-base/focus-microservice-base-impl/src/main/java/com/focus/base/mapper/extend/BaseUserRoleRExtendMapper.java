package com.focus.base.mapper.extend;

import com.focus.base.domain.basic.BaseRole;
import com.focus.base.domain.basic.BaseUserRoleR;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BaseUserRoleRExtendMapper {

    void batchInsert(@Param("list") List<BaseUserRoleR> list);

    void deleteByUserIds(@Param("list")List<String>list);

    List<BaseRole> roleOfUser(@Param("userId") String userId);
}