package com.dpm.web.organ.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dpm.resource.common.enity.TOrganInfo;
import com.dpm.resource.common.enity.organ.OrganParam;
import com.dpm.resource.freamwork.BusinessResult;
import com.dpm.web.organ.service.impl.OrganServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;

import io.swagger.annotations.ApiOperation;

/**
 * @Auther: mapengfei
 * @Date: 2018/6/4
 * @Description:
 */
@RestController
@RequestMapping(value = "/organ")
public class OrganController {
    @Autowired
    private OrganServiceImpl organService;
    
    @ApiOperation(value = "依据条件获取器官列表信息", notes = "查询器官列表信息")
    @RequestMapping(value = "/getOrganInfoByCondition", method = RequestMethod.POST)
    public BusinessResult getOrganInfoByCondition(@RequestBody OrganParam organParam){
        return BusinessResult.success(organService.getOrganInfoByCondition(organParam));
    }
    
    @ApiOperation(value = "获取器官列表信息", notes = "查询器官列表信息")
    @RequestMapping(value = "/getOrganRelation", method = RequestMethod.POST)
    public BusinessResult getOrganRelation() throws JsonProcessingException{
        return BusinessResult.success(organService.getOrganRelation());
    }

    @ApiOperation(value = "保存器官信息", notes = "用于保存或者更新器官信息")
    @RequestMapping(value = "/saveOrUpdateOrganInfo", method = RequestMethod.POST)
    public BusinessResult saveOrUpdateOrganInfo(@RequestBody TOrganInfo tOrganInfo) {
        return BusinessResult.success(organService.saveOrUpdateOrganInfo(tOrganInfo));
    }
    
    @ApiOperation(value = "删除器官信息", notes = "用于删除器官信息")
    @RequestMapping(value = "/delOrganInfo", method = RequestMethod.POST)
    public BusinessResult delOrganInfo(@RequestBody TOrganInfo tOrganInfo) {
        return BusinessResult.success(organService.delOrganInfo(tOrganInfo));
    }
}
