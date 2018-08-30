package com.dpm.db.common.mapper;

import com.dpm.db.common.example.TDiseaseRelCaseExample;
import com.dpm.resource.common.enity.TDiseaseRelCase;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TDiseaseRelCaseMapper {
    long countByExample(TDiseaseRelCaseExample example);

    int deleteByExample(TDiseaseRelCaseExample example);

    int deleteByPrimaryKey(String id);

    int insert(TDiseaseRelCase record);

    int insertSelective(TDiseaseRelCase record);

    List<TDiseaseRelCase> selectByExample(TDiseaseRelCaseExample example);

    TDiseaseRelCase selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TDiseaseRelCase record, @Param("example") TDiseaseRelCaseExample example);

    int updateByExample(@Param("record") TDiseaseRelCase record, @Param("example") TDiseaseRelCaseExample example);

    int updateByPrimaryKeySelective(TDiseaseRelCase record);

    int updateByPrimaryKey(TDiseaseRelCase record);
}