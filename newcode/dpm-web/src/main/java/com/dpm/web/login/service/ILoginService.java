package com.dpm.web.login.service;

import com.dpm.web.login.pojo.LoginUserResult;
import com.dpm.web.login.pojo.UserMenu;

import java.util.List;

/**
 * @ Purpose:
 * @Package Name: com.dpm.web.login.service
 * @Author: liuxiaoxin
 * @Date: 2018/5/18
 */
public interface ILoginService {
    String getRefreshToken(String userKey);

    LoginUserResult doLogin(String userCode, String password) throws Exception;

    void doLogout(String token);

    List<UserMenu> getUserMenuByRoleId(String roleId);
}
