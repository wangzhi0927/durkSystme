package com.dpm.unity.web.feigns.hystric;

import com.dpm.resource.common.enity.LoginUserInfo;
import com.dpm.resource.common.enity.TRecordInfo;
import com.dpm.unity.web.feigns.IUserFeignClient;

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
    public List<TRecordInfo> getRecentOperations(String userId, String hosCode) {
        return null;
    }
}
