package com.focus.base.mapper.extend;

import com.focus.base.domain.basic.BaseAuthority;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Description
 * @Author Melo
 * @Date 2019/6/9 0009 上午 9:36
 */
@Mapper
public interface BaseAuthorityExtendMapper {

    List<BaseAuthority> getAuthorityByUser(@Param("userId") String userId);
}
