package com.dpm.db.common.mapper;

import com.dpm.db.common.example.TOrganInfoExample;
import com.dpm.resource.common.enity.TOrganInfo;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TOrganInfoMapper {
    long countByExample(TOrganInfoExample example);

    int deleteByExample(TOrganInfoExample example);

    int deleteByPrimaryKey(String id);

    int insert(TOrganInfo record);

    int insertSelective(TOrganInfo record);

    List<TOrganInfo> selectByExample(TOrganInfoExample example);

    TOrganInfo selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TOrganInfo record, @Param("example") TOrganInfoExample example);

    int updateByExample(@Param("record") TOrganInfo record, @Param("example") TOrganInfoExample example);

    int updateByPrimaryKeySelective(TOrganInfo record);

    int updateByPrimaryKey(TOrganInfo record);
}