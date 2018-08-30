package com.dpm.db.common.mapper;

import com.dpm.db.common.example.TUserDeptExample;
import com.dpm.resource.common.enity.TUserDept;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TUserDeptMapper {
    long countByExample(TUserDeptExample example);

    int deleteByExample(TUserDeptExample example);

    int deleteByPrimaryKey(String id);

    int insert(TUserDept record);

    int insertSelective(TUserDept record);

    List<TUserDept> selectByExample(TUserDeptExample example);

    TUserDept selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TUserDept record, @Param("example") TUserDeptExample example);

    int updateByExample(@Param("record") TUserDept record, @Param("example") TUserDeptExample example);

    int updateByPrimaryKeySelective(TUserDept record);

    int updateByPrimaryKey(TUserDept record);
}