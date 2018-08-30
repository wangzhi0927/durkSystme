package com.dpm.db.common.mapper;

import com.dpm.db.common.example.TDeptInfoExample;
import com.dpm.resource.common.enity.TDeptInfo;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface TDeptInfoMapper {
    long countByExample(TDeptInfoExample example);

    int deleteByExample(TDeptInfoExample example);

    int deleteByPrimaryKey(String id);

    int insert(TDeptInfo record);

    int insertSelective(TDeptInfo record);

    List<TDeptInfo> selectByExample(TDeptInfoExample example);

    TDeptInfo selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TDeptInfo record, @Param("example") TDeptInfoExample example);

    int updateByExample(@Param("record") TDeptInfo record, @Param("example") TDeptInfoExample example);

    int updateByPrimaryKeySelective(TDeptInfo record);

    int updateByPrimaryKey(TDeptInfo record);

    List<TDeptInfo> getDeptListByUserId(@Param("userId") String userId);

    String getMaxDeptCode(@Param("hosCode") String hosCode);
}