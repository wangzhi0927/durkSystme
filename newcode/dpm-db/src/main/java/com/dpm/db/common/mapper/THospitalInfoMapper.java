package com.dpm.db.common.mapper;

import com.dpm.db.common.example.THospitalInfoExample;
import com.dpm.resource.common.enity.THospitalInfo;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface THospitalInfoMapper {
    long countByExample(THospitalInfoExample example);

    int deleteByExample(THospitalInfoExample example);

    int deleteByPrimaryKey(String id);

    int insert(THospitalInfo record);

    int insertSelective(THospitalInfo record);

    List<THospitalInfo> selectByExample(THospitalInfoExample example);

    THospitalInfo selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") THospitalInfo record, @Param("example") THospitalInfoExample example);

    int updateByExample(@Param("record") THospitalInfo record, @Param("example") THospitalInfoExample example);

    int updateByPrimaryKeySelective(THospitalInfo record);

    int updateByPrimaryKey(THospitalInfo record);
}