package com.dpm.web.dept.controller;

import com.dpm.resource.common.enity.TDeptInfo;
import com.dpm.resource.common.enity.dept.DeptParam;
import com.dpm.resource.common.enity.userInfo.UserAddOrUpdateParams;
import com.dpm.resource.common.enity.userInfo.UserConditionParam;
import com.dpm.resource.common.enity.userInfo.UserSearchResult;
import com.dpm.resource.freamwork.BusinessResult;
import com.dpm.web.dept.service.impl.DeptServiceImpl;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Auther: mapengfei
 * @Date: 2018/5/30
 * @Description:
 */
@RestController
@RequestMapping(value = "dept")
public class DeptController {
    @Autowired
    private DeptServiceImpl deptService;
    @ApiOperation(value = "依据条件获取科室列表信息", notes = "查询科室列表信息")
    @RequestMapping(value = "/getDeptInfoByCondition", method = RequestMethod.POST)
    public BusinessResult getDeptInfoByCondition(@RequestBody DeptParam deptParam){
        return BusinessResult.success(deptService.getDeptInfoByCondition(deptParam));
    }

    @ApiOperation(value = "保存科室信息", notes = "用于保存或者更新科室信息")
    @RequestMapping(value = "/saveOrUpdateDeptInfo", method = RequestMethod.POST)
    public BusinessResult saveOrUpdateDeptInfo(@RequestBody TDeptInfo tDeptInfo) {
        return BusinessResult.success(deptService.saveOrUpdateDeptInfo(tDeptInfo));
    }

    @ApiOperation(value = "更改用户状态", notes = "用于启用或停用科室信息")
    @RequestMapping(value = "/changDeptStateById", method = RequestMethod.POST)
    public BusinessResult changDeptStateById(@RequestBody TDeptInfo tDeptInfo) {
        BusinessResult success = BusinessResult.success(deptService.changDeptStateById(tDeptInfo));

        return BusinessResult.success(deptService.changDeptStateById(tDeptInfo));
    }
}
