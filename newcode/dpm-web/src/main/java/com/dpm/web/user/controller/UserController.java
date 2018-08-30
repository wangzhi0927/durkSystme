package com.dpm.web.user.controller;

import com.dpm.resource.common.enity.TResourceInfo;
import com.dpm.resource.common.enity.userInfo.UserAddOrUpdateParams;
import com.dpm.resource.common.enity.userInfo.UserConditionParam;
import com.dpm.resource.common.enity.userInfo.UserSearchResult;
import com.dpm.resource.freamwork.BusinessResult;
import com.dpm.web.user.service.impl.UserServiceImpl;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Auther: mapengfei
 * @Date: 2018/5/25
 * @Description:
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private UserServiceImpl userService;

    @ApiOperation(value = "依据条件获取医务人员列表信息", notes = "查询医务人员列表信息")
    @RequestMapping(value = "/getUserInfoByCondition", method = RequestMethod.POST)
    public BusinessResult getUserInfoByCondition(@RequestBody UserConditionParam userConditionParam){
         PageInfo<UserSearchResult> userSearchResultPageInfo = userService.getUserInfoByCondition(userConditionParam);
         return BusinessResult.success(userSearchResultPageInfo);
    }
    @ApiOperation(value = "获取医务人员初始化面的科室和角色信息", notes = "供用户信息检索查询使用")
    @RequestMapping(value = "/getDeptAndRoleInfo", method = RequestMethod.GET)
    public BusinessResult getDeptAndRoleInfo(@RequestParam(value = "hosCode") String hosCode){
        return BusinessResult.success(userService.getDeptAndRoleInfo(hosCode));
    }
    @ApiOperation(value = "保存用户信息", notes = "用于保存或者更新用户信息")
    @RequestMapping(value = "/saveOrUpdateUserInfo", method = RequestMethod.POST)
    public BusinessResult saveOrUpdateUserInfo(@RequestBody UserAddOrUpdateParams userAddOrUpdateParams) {
        return BusinessResult.success(userService.saveOrUpdateUserInfo(userAddOrUpdateParams));
    }

    @ApiOperation(value = "更改用户状态", notes = "用于冻结或解冻用户信息")
    @RequestMapping(value = "/changUserStateById", method = RequestMethod.GET)
    public BusinessResult changUserStateById(@RequestParam(value = "userId")String userId) {
        return BusinessResult.success(userService.changUserStateById(userId));
    }

    @ApiOperation(value = "重置用户密码", notes = "用于将用户密码重置回初始状态")
    @RequestMapping(value = "/resetPassword", method = RequestMethod.GET)
    public BusinessResult resetPassword(@RequestParam(value = "userId")String userId) {
        return BusinessResult.success(userService.resetPassword(userId));
    }
}
