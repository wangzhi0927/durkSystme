package com.dpm.db.common.mapper;

import com.dpm.db.common.example.TResourceInfoExample;
import com.dpm.resource.common.enity.TResourceInfo;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TResourceInfoMapper {
    long countByExample(TResourceInfoExample example);

    int deleteByExample(TResourceInfoExample example);

    int deleteByPrimaryKey(String id);

    int insert(TResourceInfo record);

    int insertSelective(TResourceInfo record);

    List<TResourceInfo> selectByExample(TResourceInfoExample example);

    TResourceInfo selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TResourceInfo record, @Param("example") TResourceInfoExample example);

    int updateByExample(@Param("record") TResourceInfo record, @Param("example") TResourceInfoExample example);

    int updateByPrimaryKeySelective(TResourceInfo record);

    int updateByPrimaryKey(TResourceInfo record);
}