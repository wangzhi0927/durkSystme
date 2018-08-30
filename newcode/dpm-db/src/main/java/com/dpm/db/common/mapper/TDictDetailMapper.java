package com.dpm.db.common.mapper;

import com.dpm.db.common.example.TDictDetailExample;
import com.dpm.resource.common.enity.TDictDetail;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TDictDetailMapper {
    long countByExample(TDictDetailExample example);

    int deleteByExample(TDictDetailExample example);

    int deleteByPrimaryKey(String id);

    int insert(TDictDetail record);

    int insertSelective(TDictDetail record);

    List<TDictDetail> selectByExample(TDictDetailExample example);

    TDictDetail selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TDictDetail record, @Param("example") TDictDetailExample example);

    int updateByExample(@Param("record") TDictDetail record, @Param("example") TDictDetailExample example);

    int updateByPrimaryKeySelective(TDictDetail record);

    int updateByPrimaryKey(TDictDetail record);
}