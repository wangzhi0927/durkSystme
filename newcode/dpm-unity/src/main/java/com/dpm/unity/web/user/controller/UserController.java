package com.dpm.unity.web.user.controller;

import com.dpm.resource.common.enity.TOrganInfo;
import com.dpm.resource.freamwork.BusinessResult;
import com.dpm.unity.web.disease.pojo.request.GetOrganInfoBySystemRequestData;
import com.dpm.unity.web.disease.pojo.response.GetOrganInfoResponseData;
import com.dpm.unity.web.login.service.ILoginService;
import com.dpm.unity.web.user.pojo.request.GetRecentOperationsRequestData;
import com.dpm.unity.web.user.service.impl.UserServiceImpl;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Auther: mapengfei
 * @Date: 2018/5/17
 * @Description:
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private UserServiceImpl userService;

    @ApiOperation(value = "获取医生最近操作的疾病信息", notes = "通过疾病编码和性别获取疾病信息")
    @RequestMapping(value = "/getRecentOperations",method = RequestMethod.POST,consumes = "application/json", produces = "application/json; charset=UTF-8")
    public BusinessResult getRecentOperations(@RequestBody GetRecentOperationsRequestData getRecentOperationsRequestData) throws Exception {
        return BusinessResult.success(userService.getRecentOperations(getRecentOperationsRequestData));
    }

}
