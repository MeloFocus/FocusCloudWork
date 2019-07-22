package com.focus.base.mapper.extend;

import com.focus.base.domain.basic.BaseResource;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BaseResourceExtendMapper {

    List<BaseResource> selectAllIndxResource();

    List<BaseResource> selectIndexResourceByUserId(@Param("userId")String userId);

    List<BaseResource> getResourcesByModule(@Param("moduleCode") String moduleCode);

    List<BaseResource> getResourcesByModuleAndUserId(@Param("moduleCode")String moduleCode,@Param("userId")String userId);
}