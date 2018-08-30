package com.dpm.db.common.mapper;

import com.dpm.db.common.example.TRoleInfoExample;
import com.dpm.resource.common.enity.TRoleInfo;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TRoleInfoMapper {
    long countByExample(TRoleInfoExample example);

    int deleteByExample(TRoleInfoExample example);

    int deleteByPrimaryKey(String id);

    int insert(TRoleInfo record);

    int insertSelective(TRoleInfo record);

    List<TRoleInfo> selectByExample(TRoleInfoExample example);

    TRoleInfo selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TRoleInfo record, @Param("example") TRoleInfoExample example);

    int updateByExample(@Param("record") TRoleInfo record, @Param("example") TRoleInfoExample example);

    int updateByPrimaryKeySelective(TRoleInfo record);

    int updateByPrimaryKey(TRoleInfo record);
}