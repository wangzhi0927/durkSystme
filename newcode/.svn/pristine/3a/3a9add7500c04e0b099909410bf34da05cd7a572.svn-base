package com.dpm.db.common.mapper;

import com.dpm.db.common.example.TCaseInfoExample;
import com.dpm.resource.common.enity.TCaseInfo;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TCaseInfoMapper {
    long countByExample(TCaseInfoExample example);

	int deleteByExample(TCaseInfoExample example);

	int deleteByPrimaryKey(String id);

	int insert(TCaseInfo record);

	int insertSelective(TCaseInfo record);

	List<TCaseInfo> selectByExample(TCaseInfoExample example);

	TCaseInfo selectByPrimaryKey(String id);

	int updateByExampleSelective(@Param("record") TCaseInfo record, @Param("example") TCaseInfoExample example);

	int updateByExample(@Param("record") TCaseInfo record, @Param("example") TCaseInfoExample example);

	int updateByPrimaryKeySelective(TCaseInfo record);

	int updateByPrimaryKey(TCaseInfo record);
}