package com.dpm.db.common.mapper;

import com.dpm.db.common.example.TLymphInfoExample;
import com.dpm.resource.common.enity.TLymphInfo;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TLymphInfoMapper {
    long countByExample(TLymphInfoExample example);

    int deleteByExample(TLymphInfoExample example);

    int deleteByPrimaryKey(String id);

    int insert(TLymphInfo record);

    int insertSelective(TLymphInfo record);

    List<TLymphInfo> selectByExample(TLymphInfoExample example);

    TLymphInfo selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TLymphInfo record, @Param("example") TLymphInfoExample example);

    int updateByExample(@Param("record") TLymphInfo record, @Param("example") TLymphInfoExample example);

    int updateByPrimaryKeySelective(TLymphInfo record);

    int updateByPrimaryKey(TLymphInfo record);
}