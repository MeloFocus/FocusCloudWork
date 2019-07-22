package com.focus.base.mapper.basic;

import com.focus.base.domain.basic.BaseImage;
import java.util.List;

public interface BaseImageMapper {
    int deleteByPrimaryKey(String id);

    int insert(BaseImage record);

    BaseImage selectByPrimaryKey(String id);

    List<BaseImage> selectAll();

    int updateByPrimaryKey(BaseImage record);
}