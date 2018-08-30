package com.dpm.db.common.mapper;

import com.dpm.db.common.example.TRecordInfoExample;
import com.dpm.resource.common.enity.TRecordInfo;
import com.dpm.resource.common.enity.record.RecordInfo;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TRecordInfoMapper {
    long countByExample(TRecordInfoExample example);

	int deleteByExample(TRecordInfoExample example);

	int deleteByPrimaryKey(String id);

	int insert(TRecordInfo record);

	int insertSelective(TRecordInfo record);

	List<TRecordInfo> selectByExample(TRecordInfoExample example);

	TRecordInfo selectByPrimaryKey(String id);

	int updateByExampleSelective(@Param("record") TRecordInfo record, @Param("example") TRecordInfoExample example);

	int updateByExample(@Param("record") TRecordInfo record, @Param("example") TRecordInfoExample example);

	int updateByPrimaryKeySelective(TRecordInfo record);

	int updateByPrimaryKey(TRecordInfo record);
	
	List<RecordInfo> selectRecHosByExample(TRecordInfoExample example);
}