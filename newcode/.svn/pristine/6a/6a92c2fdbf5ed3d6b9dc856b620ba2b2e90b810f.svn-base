package com.dpm.web.user.service;

import com.dpm.resource.common.enity.userInfo.DeptAndRoleInfoResponse;
import com.dpm.resource.common.enity.userInfo.UserAddOrUpdateParams;
import com.dpm.resource.common.enity.userInfo.UserConditionParam;
import com.dpm.resource.common.enity.userInfo.UserSearchResult;
import com.github.pagehelper.PageInfo;

/**
 * @Auther: mapengfei
 * @Date: 2018/5/25
 * @Description:
 */
public interface IUserService {
    PageInfo<UserSearchResult> getUserInfoByCondition(UserConditionParam userConditionParam);
    DeptAndRoleInfoResponse getDeptAndRoleInfo(String hosCode);
    UserAddOrUpdateParams saveOrUpdateUserInfo(UserAddOrUpdateParams userAddOrUpdateParams);
    int changUserStateById(String userId);
    int resetPassword(String userId);
}
