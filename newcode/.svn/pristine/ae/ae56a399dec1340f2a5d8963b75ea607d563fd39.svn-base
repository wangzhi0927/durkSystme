package com.dpm.db.common.mapper;

import com.dpm.db.common.example.TRoleMenuExample;
import com.dpm.resource.common.enity.TRoleMenu;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TRoleMenuMapper {
    long countByExample(TRoleMenuExample example);

    int deleteByExample(TRoleMenuExample example);

    int deleteByPrimaryKey(String id);

    int insert(TRoleMenu record);

    int insertSelective(TRoleMenu record);

    List<TRoleMenu> selectByExample(TRoleMenuExample example);

    TRoleMenu selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TRoleMenu record, @Param("example") TRoleMenuExample example);

    int updateByExample(@Param("record") TRoleMenu record, @Param("example") TRoleMenuExample example);

    int updateByPrimaryKeySelective(TRoleMenu record);

    int updateByPrimaryKey(TRoleMenu record);
}