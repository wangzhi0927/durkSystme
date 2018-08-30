package com.dpm.db.common.mapper;

import com.dpm.db.common.example.TMenuInfoExample;
import com.dpm.resource.common.enity.TMenuInfo;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TMenuInfoMapper {
    long countByExample(TMenuInfoExample example);

    int deleteByExample(TMenuInfoExample example);

    int deleteByPrimaryKey(String id);

    int insert(TMenuInfo record);

    int insertSelective(TMenuInfo record);

    List<TMenuInfo> selectByExample(TMenuInfoExample example);

    TMenuInfo selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TMenuInfo record, @Param("example") TMenuInfoExample example);

    int updateByExample(@Param("record") TMenuInfo record, @Param("example") TMenuInfoExample example);

    int updateByPrimaryKeySelective(TMenuInfo record);

    int updateByPrimaryKey(TMenuInfo record);
}