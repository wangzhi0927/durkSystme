package com.dpm.unity.web.login.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.dpm.resource.common.enity.LoginUserInfo;
import com.dpm.resource.common.enity.TUserInfo;
import com.dpm.resource.freamwork.BusinessResult;
import com.dpm.unity.web.login.service.ILoginService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ Purpose:
 * @Package Name: com.dpm.unity.web.login.controller
 * @Author: liuxiaoxin
 * @Date: 2018/5/9
 */
@RestController
public class LoginController {
    @Autowired
    ILoginService loginService;

    /**
     * @param userInfo
     * @return
     * @throws Exception
     */
    @ApiOperation(value = "移动端用户登录", notes = "移动端用户通过用户名密码登录")
    @RequestMapping(value = "/doLogin", method = RequestMethod.POST)
    BusinessResult doLogin(@RequestBody TUserInfo userInfo) throws Exception {
        LoginUserInfo loginUserInfo = loginService.doLogin(userInfo);
        return BusinessResult.success("用户登录成功", loginUserInfo, loginUserInfo.getToken());
    }

    @ApiOperation(value = "移动端用户自动登录", notes = "移动端用户自动登录，返回信息与登录接口一致")
    @RequestMapping(value = "/autoLogin", method = RequestMethod.POST)
    BusinessResult autoLogin(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String token = request.getHeader("token");
        LoginUserInfo loginUserInfo = loginService.autoLogin(token);
        return BusinessResult.success("用户自动登录成功", loginUserInfo, loginUserInfo.getToken());
    }

    @ApiOperation(value = "移动端用户登出", notes = "移动端用户登出，清除登录信息")
    @RequestMapping(value = "/doLogout", method = RequestMethod.POST)
    BusinessResult doLogout(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String token = request.getHeader("token");
        loginService.doLogout(token);
        return BusinessResult.success("用户登出成功");
    }

    @ApiOperation(value = "getDictDetail", notes = "用户获取接口")
    @RequestMapping(value = "/getDictDetail", method = RequestMethod.GET)
    public BusinessResult getDictDetail() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("a", "123456789");
        jsonObject.put("b", "987654321");
        return BusinessResult.success(JSON.toJSONString(jsonObject));
    }

    ;
}
