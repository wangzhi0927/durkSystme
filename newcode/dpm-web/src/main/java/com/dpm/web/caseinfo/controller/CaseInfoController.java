package com.dpm.web.caseinfo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dpm.resource.common.enity.TCaseInfo;
import com.dpm.resource.common.enity.caseinfo.CaseInfoDTO;
import com.dpm.resource.common.enity.caseinfo.CaseInfoParam;
import com.dpm.resource.freamwork.BusinessResult;
import com.dpm.web.caseinfo.service.impl.CaseInfoServiceImpl;

import io.swagger.annotations.ApiOperation;

/**
 * @Auther: mapengfei
 * @Date: 2018/6/4
 * @Description:
 */
@RestController
@RequestMapping(value = "/case")
public class CaseInfoController {
    @Autowired
    private CaseInfoServiceImpl caseInfoService;
    
    @ApiOperation(value = "依据条件获取器官列表信息", notes = "查询器官列表信息")
    @RequestMapping(value = "/getCaseInfoByCondition", method = RequestMethod.POST)
    public BusinessResult getCaseInfoByCondition(@RequestBody CaseInfoParam CaseInfoParam){
        return BusinessResult.success(caseInfoService.getCaseInfoByCondition(CaseInfoParam));
    }
    
    @ApiOperation(value = "获取方案关联信息", notes = "获取方案关联信息")
    @RequestMapping(value = "/getCaseInfoRelation", method = RequestMethod.POST)
    public BusinessResult getCaseInfoRelation(@RequestBody TCaseInfo tCaseInfo){
        return BusinessResult.success(caseInfoService.getCaseInfoRelation(tCaseInfo));
    }

    @ApiOperation(value = "保存器官信息", notes = "用于保存或者更新器官信息")
    @RequestMapping(value = "/saveOrUpdateCaseInfo", method = RequestMethod.POST)
    public BusinessResult saveOrUpdateCaseInfo(@RequestBody CaseInfoDTO caseInfoDTO) {
        return BusinessResult.success(caseInfoService.saveOrUpdateCaseInfo(caseInfoDTO));
    }
    
    @ApiOperation(value = "删除器官信息", notes = "用于删除器官信息")
    @RequestMapping(value = "/delCaseInfo", method = RequestMethod.POST)
    public BusinessResult delCaseInfo(@RequestBody TCaseInfo tCaseInfo) {
        return BusinessResult.success(caseInfoService.delCaseInfo(tCaseInfo));
    }
    
    @ApiOperation(value = "依据条件获取器官列表信息", notes = "依据条件获取器官列表信息")
    @RequestMapping(value = "/getCaseInfoList", method = RequestMethod.POST)
    public BusinessResult getCaseInfoList(@RequestBody TCaseInfo tCaseInfo){
        return BusinessResult.success(caseInfoService.getCaseInfoList(tCaseInfo));
    }
}
