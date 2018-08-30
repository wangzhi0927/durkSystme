package com.dpm.unity.web.login.service;

import com.dpm.resource.common.enity.LoginUserInfo;
import com.dpm.resource.common.enity.TUserInfo;

public interface ILoginService {

    /**
     * 用户登录
     *
     * @param userInfo
     * @return
     * @throws Exception
     */
    LoginUserInfo doLogin(TUserInfo userInfo) throws Exception;

    String getRefreshToken(String userKey);

    /**
     * 自动登录
     *
     * @param token
     * @return
     */
    LoginUserInfo autoLogin(String token) throws Exception;

    /**
     *
     * @param token
     * @return
     */
    void doLogout(String token);
}
