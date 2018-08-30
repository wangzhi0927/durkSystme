package com.dpm.db.web.user.controller;

import com.dpm.db.web.user.service.impl.UserServiceImpl;
import com.dpm.resource.common.enity.LoginUserInfo;
import com.dpm.resource.common.enity.TMenuInfo;
import com.dpm.resource.common.enity.TRecordInfo;
import com.dpm.resource.common.enity.TResourceInfo;
import com.dpm.resource.common.enity.resource.ResourceParam;
import com.dpm.resource.common.enity.userInfo.DeptAndRoleInfoResponse;
import com.dpm.resource.common.enity.userInfo.UserAddOrUpdateParams;
import com.dpm.resource.common.enity.userInfo.UserConditionParam;
import com.dpm.resource.common.enity.userInfo.UserSearchResult;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ Purpose:
 * @Package Name: com.dpm.db.web.user.controller
 * @Author: liuxiaoxin
 * @Date: 2018/5/14
 */
@RestController
@Api(description = "用户登录等相关操作")
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserServiceImpl userService;

    @ApiOperation(value = "用户登录", notes = "用户依据用户名密码登录")
    @RequestMapping(value = "/doLogin", method = RequestMethod.POST)
    LoginUserInfo doLogin(@RequestBody LoginUserInfo loginUserInfo) {
        return userService.doLogin(loginUserInfo);
    }

    @ApiOperation(value = "用户登出", notes = "用户退出系统，删除登录信息")
    @RequestMapping(value = "/doLogout", method = RequestMethod.POST)
    String doLogin(@RequestParam(value = "token") String token) {
        return userService.doLogout(token);
    }

    @ApiOperation(value = "获取Token", notes = "获取用户长令牌")
    @RequestMapping(value = "/getLoginToken", method = RequestMethod.GET)
    String getLoginToken(@RequestParam String userKey) {
        return userService.getLoginToken(userKey);
    }

    @ApiOperation(value = "获取医生最近操作的疾病信息", notes = "通过疾病编码和性别获取疾病信息")
    @RequestMapping(value = "/getRecentOperations", method = RequestMethod.GET)
    List<TRecordInfo> getRecentOperations(@RequestParam(value = "userId") String userId, @RequestParam(value = "hosCode") String hosCode) {
        return userService.getRecentOperations(userId, hosCode);
    }

    @ApiOperation(value = "查询登录用户权限菜单信息", notes = "查询登录用户权限菜单信息")
    @RequestMapping(value = "/getUserMenuInfo", method = RequestMethod.GET)
    List<TMenuInfo> getUserMenuInfo(@RequestParam(value = "roleId") String roleId) {
        return userService.getUserMenuInfo(roleId);
    }

    @ApiOperation(value = "查询登录用户权限菜单信息", notes = "查询登录用户权限菜单信息")
    @RequestMapping(value = "/getMenuByPage", method = RequestMethod.POST)
    List<TMenuInfo> getMenuByPage(@RequestParam(value = "pageSize") int pageSize, @RequestParam(value = "pageNum") int pageNum) {
        return userService.getMenuByPage(pageSize, pageNum);
    }

    @ApiOperation(value = "依据条件获取医务人员列表信息", notes = "查询医务人员列表信息")
    @RequestMapping(value = "/getUserInfoByCondition", method = RequestMethod.POST)
    PageInfo<UserSearchResult> getUserInfoByCondition(@RequestBody UserConditionParam userConditionParam) {
        return userService.getUserInfoByCondition(userConditionParam.getUserInfo(), userConditionParam.getPageSize(), userConditionParam.getPageNum());
    }

    @ApiOperation(value = "获取医务人员初始化面的科室和角色信息", notes = "供用户信息检索查询使用")
    @RequestMapping(value = "/getDeptAndRoleInfo", method = RequestMethod.GET)
    DeptAndRoleInfoResponse getDeptAndRoleInfo(@RequestParam(value = "hosCode") String hosCode){
        return userService.getDeptAndRoleInfo(hosCode);
    }

    @ApiOperation(value = "保存用户信息", notes = "用于保存或者更新用户信息")
    @RequestMapping(value = "/saveOrUpdateUserInfo",method = RequestMethod.POST)
    UserAddOrUpdateParams saveOrUpdateUserInfo(@RequestBody UserAddOrUpdateParams userAddOrUpdateParams) {
        return userService.saveOrUpdateUserInfo(userAddOrUpdateParams);
    }
    @ApiOperation(value = "更改用户状态", notes = "用于冻结或解冻用户信息")
    @RequestMapping(value = "/changUserStateById", method = RequestMethod.GET)
    int changUserStateById(@RequestParam(value = "userId")String userId){
        return userService.changUserStateById(userId);
    }

    @ApiOperation(value = "重置用户密码", notes = "用于将用户密码重置回初始状态")
    @RequestMapping(value = "/resetPassword", method = RequestMethod.GET)
    int resetPassword(@RequestParam(value = "userId")String userId){
        return userService.resetPassword(userId);
    }
}
