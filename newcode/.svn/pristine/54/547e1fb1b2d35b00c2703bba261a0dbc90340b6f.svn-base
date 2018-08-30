package com.dpm.db.common.mapper;

import com.dpm.db.common.example.TDiseaseRelResExample;
import com.dpm.resource.common.enity.TDiseaseRelRes;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TDiseaseRelResMapper {
    long countByExample(TDiseaseRelResExample example);

    int deleteByExample(TDiseaseRelResExample example);

    int deleteByPrimaryKey(String id);

    int insert(TDiseaseRelRes record);

    int insertSelective(TDiseaseRelRes record);

    List<TDiseaseRelRes> selectByExample(TDiseaseRelResExample example);

    TDiseaseRelRes selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TDiseaseRelRes record, @Param("example") TDiseaseRelResExample example);

    int updateByExample(@Param("record") TDiseaseRelRes record, @Param("example") TDiseaseRelResExample example);

    int updateByPrimaryKeySelective(TDiseaseRelRes record);

    int updateByPrimaryKey(TDiseaseRelRes record);
    
    List<TDiseaseRelRes> selectResByExample(TDiseaseRelResExample example);
}