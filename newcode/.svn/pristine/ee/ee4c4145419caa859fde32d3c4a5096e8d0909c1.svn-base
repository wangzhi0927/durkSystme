package com.dpm.web.user.service.impl;

import com.dpm.resource.common.enity.userInfo.DeptAndRoleInfoResponse;
import com.dpm.resource.common.enity.userInfo.UserAddOrUpdateParams;
import com.dpm.resource.common.enity.userInfo.UserConditionParam;
import com.dpm.resource.common.enity.userInfo.UserSearchResult;
import com.dpm.resource.freamwork.BusinessException;
import com.dpm.web.feigns.IUserFeignClient;
import com.dpm.web.user.service.IUserService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

/**
 * @Auther: mapengfei
 * @Date: 2018/5/25
 * @Description:
 */
@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private IUserFeignClient iUserFeignClient;
    @Override
    public PageInfo<UserSearchResult> getUserInfoByCondition(UserConditionParam userConditionParam) {
        return iUserFeignClient.getUserInfoByCondition(userConditionParam);
    }

    @Override
    public DeptAndRoleInfoResponse getDeptAndRoleInfo(String hosCode) {
        return iUserFeignClient.getDeptAndRoleInfo(hosCode);
    }

    @Override
    public UserAddOrUpdateParams saveOrUpdateUserInfo(UserAddOrUpdateParams userAddOrUpdateParams) {
        if(ObjectUtils.isEmpty(userAddOrUpdateParams))
            throw new BusinessException("用户数据不能为空");
        return iUserFeignClient.saveOrUpdateUserInfo(userAddOrUpdateParams);
    }

    @Override
    public int changUserStateById(String userId) {
        return iUserFeignClient.changUserStateById(userId);
    }

    @Override
    public int resetPassword(String userId) {
        return iUserFeignClient.resetPassword(userId);
    }
}
