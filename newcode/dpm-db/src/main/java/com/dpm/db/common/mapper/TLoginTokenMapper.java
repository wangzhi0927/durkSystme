package com.dpm.db.common.mapper;

import com.dpm.db.common.example.TLoginTokenExample;
import com.dpm.resource.common.enity.TLoginToken;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TLoginTokenMapper {
    long countByExample(TLoginTokenExample example);

    int deleteByExample(TLoginTokenExample example);

    int deleteByPrimaryKey(String id);

    int insert(TLoginToken record);

    int insertSelective(TLoginToken record);

    List<TLoginToken> selectByExample(TLoginTokenExample example);

    TLoginToken selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TLoginToken record, @Param("example") TLoginTokenExample example);

    int updateByExample(@Param("record") TLoginToken record, @Param("example") TLoginTokenExample example);

    int updateByPrimaryKeySelective(TLoginToken record);

    int updateByPrimaryKey(TLoginToken record);
}