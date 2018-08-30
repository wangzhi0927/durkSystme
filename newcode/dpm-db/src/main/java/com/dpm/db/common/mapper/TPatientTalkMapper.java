package com.dpm.db.common.mapper;

import com.dpm.db.common.example.TPatientTalkExample;
import com.dpm.resource.common.enity.TPatientTalk;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TPatientTalkMapper {
    long countByExample(TPatientTalkExample example);

	int deleteByExample(TPatientTalkExample example);

	int deleteByPrimaryKey(String id);

	int insert(TPatientTalk record);

	int insertSelective(TPatientTalk record);

	List<TPatientTalk> selectByExample(TPatientTalkExample example);

	TPatientTalk selectByPrimaryKey(String id);

	int updateByExampleSelective(@Param("record") TPatientTalk record, @Param("example") TPatientTalkExample example);

	int updateByExample(@Param("record") TPatientTalk record, @Param("example") TPatientTalkExample example);

	int updateByPrimaryKeySelective(TPatientTalk record);

	int updateByPrimaryKey(TPatientTalk record);
}