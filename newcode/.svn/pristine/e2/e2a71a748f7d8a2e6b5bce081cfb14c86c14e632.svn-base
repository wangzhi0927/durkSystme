package com.dpm.db.common.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.dpm.db.common.example.TCaseRelResExample;
import com.dpm.resource.common.enity.TCaseRelRes;

public interface TCaseRelResMapper {
    long countByExample(TCaseRelResExample example);

    int deleteByExample(TCaseRelResExample example);

    int deleteByPrimaryKey(String id);

    int insert(TCaseRelRes record);

    int insertSelective(TCaseRelRes record);

    List<TCaseRelRes> selectByExample(TCaseRelResExample example);

    TCaseRelRes selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TCaseRelRes record, @Param("example") TCaseRelResExample example);

    int updateByExample(@Param("record") TCaseRelRes record, @Param("example") TCaseRelResExample example);

    int updateByPrimaryKeySelective(TCaseRelRes record);

    int updateByPrimaryKey(TCaseRelRes record);
    
    List<TCaseRelRes> selectResByExample(TCaseRelResExample example);
}