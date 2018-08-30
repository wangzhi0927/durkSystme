package com.dpm.db.common.mapper;

import com.dpm.db.common.example.TTnmInfoExample;
import com.dpm.resource.common.enity.TTnmInfo;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TTnmInfoMapper {
    long countByExample(TTnmInfoExample example);

	int deleteByExample(TTnmInfoExample example);

	int deleteByPrimaryKey(String id);

	int insert(TTnmInfo record);

	int insertSelective(TTnmInfo record);

	List<TTnmInfo> selectByExample(TTnmInfoExample example);

	TTnmInfo selectByPrimaryKey(String id);

	int updateByExampleSelective(@Param("record") TTnmInfo record, @Param("example") TTnmInfoExample example);

	int updateByExample(@Param("record") TTnmInfo record, @Param("example") TTnmInfoExample example);

	int updateByPrimaryKeySelective(TTnmInfo record);

	int updateByPrimaryKey(TTnmInfo record);
}