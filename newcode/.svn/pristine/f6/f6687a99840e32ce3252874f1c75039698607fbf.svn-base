package com.dpm.db.common.mapper;

import com.dpm.db.common.example.TUserInfoExample;
import com.dpm.resource.common.enity.TUserInfo;
import java.util.List;

import com.dpm.resource.common.enity.userInfo.UserParam;
import com.dpm.resource.common.enity.userInfo.UserSearchResult;
import org.apache.ibatis.annotations.Param;

public interface TUserInfoMapper {
    long countByExample(TUserInfoExample example);

    int deleteByExample(TUserInfoExample example);

    int deleteByPrimaryKey(String id);

    int insert(TUserInfo record);

    int insertSelective(TUserInfo record);

    List<TUserInfo> selectByExample(TUserInfoExample example);

    TUserInfo selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TUserInfo record, @Param("example") TUserInfoExample example);

    int updateByExample(@Param("record") TUserInfo record, @Param("example") TUserInfoExample example);

    int updateByPrimaryKeySelective(TUserInfo record);

    int updateByPrimaryKey(TUserInfo record);

    List<UserSearchResult> getUserInfoByCondition(UserParam userParam);
}