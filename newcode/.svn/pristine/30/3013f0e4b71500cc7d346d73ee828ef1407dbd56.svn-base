package com.dpm.db.common.mapper;

import com.dpm.db.common.example.TDiseaseInfoExample;

import java.util.List;

import com.dpm.resource.common.enity.TDiseaseInfo;
import org.apache.ibatis.annotations.Param;

public interface TDiseaseInfoMapper {
    long countByExample(TDiseaseInfoExample example);

    int deleteByExample(TDiseaseInfoExample example);

    int deleteByPrimaryKey(String id);

    int insert(TDiseaseInfo record);

    int insertSelective(TDiseaseInfo record);

    List<TDiseaseInfo> selectByExample(TDiseaseInfoExample example);

    TDiseaseInfo selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TDiseaseInfo record, @Param("example") TDiseaseInfoExample example);

    int updateByExample(@Param("record") TDiseaseInfo record, @Param("example") TDiseaseInfoExample example);

    int updateByPrimaryKeySelective(TDiseaseInfo record);

    int updateByPrimaryKey(TDiseaseInfo record);

    String getMaxDiseaseCode();
}