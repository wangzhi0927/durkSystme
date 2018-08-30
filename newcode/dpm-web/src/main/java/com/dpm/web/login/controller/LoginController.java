package com.dpm.web.login.controller;

import com.dpm.resource.common.enity.TUserInfo;
import com.dpm.resource.freamwork.BusinessException;
import com.dpm.resource.freamwork.BusinessResult;
import com.dpm.web.login.service.impl.LoginServiceImpl;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ Purpose:
 * @Package Name: com.dpm.web.login.controller
 * @Author: liuxiaoxin
 * @Date: 2018/5/18
 */
@RestController
@RequestMapping("/web")
public class LoginController {

    @Autowired
    LoginServiceImpl loginService;

    @ApiOperation(value = "用户登录", notes = "用户依据用户名密码登录")
    @RequestMapping(value = "/doLogin", method = RequestMethod.POST)
    BusinessResult doLogin(@RequestBody TUserInfo userInfo) throws Exception {
        return BusinessResult.success(loginService.doLogin(userInfo.getUserCode(), userInfo.getPassword()));
    }

    @ApiOperation(value = "用户登出", notes = "后台管理系统用户登出，清除登录信息")
    @RequestMapping(value = "/doLogout", method = RequestMethod.POST)
    BusinessResult doLogout(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String token = request.getHeader("token");
        loginService.doLogout(token);
        return BusinessResult.success("用户登出成功");
    }

    @ApiOperation(value = "获取用户菜单信息", notes = "")
    @RequestMapping(value = "/getUserMenuByRoleId", method = RequestMethod.GET)
    BusinessResult getUserMenuByRoleId(@RequestParam(value = "roleId") String roleId) throws Exception {
        return BusinessResult.success(loginService.getUserMenuByRoleId(roleId));
    }

    @ApiOperation(value = "校验用户信息是否有效", notes = "")
    @RequestMapping(value = "/validUser", method = RequestMethod.GET)
    BusinessResult validUser(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String token = request.getHeader("token");
        String longToken = loginService.getRefreshToken(token);
        if (StringUtils.isEmpty(longToken))
            throw new BusinessException("用户信息无效");
        return BusinessResult.success("用户信息有效");
    }
}
