package com.dpm.db.web.user.service;

import java.util.List;

import com.dpm.resource.common.enity.LoginUserInfo;
import com.dpm.resource.common.enity.TMenuInfo;
import com.dpm.resource.common.enity.TRecordInfo;
import com.dpm.resource.common.enity.userInfo.DeptAndRoleInfoResponse;
import com.dpm.resource.common.enity.userInfo.UserAddOrUpdateParams;
import com.dpm.resource.common.enity.userInfo.UserParam;
import com.dpm.resource.common.enity.userInfo.UserSearchResult;
import com.github.pagehelper.PageInfo;

/**
 * @ Purpose:
 * @Package Name: com.dpm.db.web.user.service
 * @Author: liuxiaoxin
 * @Date: 2018/5/14
 */
public interface IUserService {
    LoginUserInfo doLogin(LoginUserInfo loginUserInfo);


    /**
     * @param userKey
     */
    public String getLoginToken(String userKey);

    String doLogout(String token);

    List<TRecordInfo> getRecentOperations(String userId,String hosCode);

    List<TMenuInfo> getUserMenuInfo(String roleId);

    List<TMenuInfo> getMenuByPage(int pageSize,int pageNum);

    PageInfo<UserSearchResult> getUserInfoByCondition(UserParam userParam, int pageSize, int pageNum);

    DeptAndRoleInfoResponse getDeptAndRoleInfo( String hosCode);

    UserAddOrUpdateParams saveOrUpdateUserInfo(UserAddOrUpdateParams userAddOrUpdateParams);

    int changUserStateById(String userId);

    int resetPassword(String userId);
}
