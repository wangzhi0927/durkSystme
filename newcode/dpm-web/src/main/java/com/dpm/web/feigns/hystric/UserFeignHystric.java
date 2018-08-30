package com.dpm.web.feigns.hystric;

import com.dpm.resource.common.enity.LoginUserInfo;
import com.dpm.resource.common.enity.TMenuInfo;
import com.dpm.resource.common.enity.userInfo.DeptAndRoleInfoResponse;
import com.dpm.resource.common.enity.userInfo.UserAddOrUpdateParams;
import com.dpm.resource.common.enity.userInfo.UserConditionParam;
import com.dpm.resource.common.enity.userInfo.UserSearchResult;
import com.dpm.web.feigns.IUserFeignClient;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @ Purpose:
 * @Package Name: com.dpm.unity.web.feigns.hystric
 * @Author: liuxiaoxin
 * @Date: 2018/5/15
 */
public class UserFeignHystric implements IUserFeignClient {
    @Override
    public String getLoginToken(String userKey) {
        return null;
    }

    @Override
    public LoginUserInfo doLogin(LoginUserInfo loginUserInfo) {
        return null;
    }

    @Override
    public String doLogout(String token) {
        return null;
    }

    @Override
    public List<TMenuInfo> getUserMenuInfo(String roleId) {
        return null;
    }

    @Override
    public PageInfo<UserSearchResult> getUserInfoByCondition(UserConditionParam userConditionParam) {
        return null;
    }

    @Override
    public DeptAndRoleInfoResponse getDeptAndRoleInfo(String hosCode) {
        return null;
    }

    @Override
    public UserAddOrUpdateParams saveOrUpdateUserInfo(UserAddOrUpdateParams userAddOrUpdateParams) {
        return null;
    }

    @Override
    public int changUserStateById(String userId) {
        return 0;
    }

    @Override
    public int resetPassword(String userId) {
        return 0;
    }
}
