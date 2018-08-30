package com.dpm.web.disease.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dpm.resource.common.enity.TDiseaseInfo;
import com.dpm.resource.common.enity.disease.DiseaseConditionParam;
import com.dpm.resource.common.enity.disease.DiseaseDTO;
import com.dpm.resource.freamwork.BusinessResult;
import com.dpm.web.disease.service.impl.DiseaseServiceImpl;
import com.dpm.web.model.service.impl.ModelServiceImpl;

import io.swagger.annotations.ApiOperation;

/**
 * @Auther: mapengfei
 * @Date: 2018/6/4
 * @Description:
 */
@RestController
@RequestMapping(value = "/disease")
public class DiseaseController {
    @Autowired
    private DiseaseServiceImpl diseaseService;
    
    @Autowired
    private ModelServiceImpl modelService;
    
    @ApiOperation(value = "依据条件获取疾病列表信息", notes = "查询疾病列表信息")
    @RequestMapping(value = "/getDiseaseInfoByCondition", method = RequestMethod.POST)
    public BusinessResult getDiseaseInfoByCondition(@RequestBody DiseaseConditionParam diseaseConditionParam){
        return BusinessResult.success(diseaseService.getDiseaseInfoByCondition(diseaseConditionParam));
    }

    @ApiOperation(value = "保存疾病信息", notes = "用于保存或者更新疾病信息")
    @RequestMapping(value = "/saveOrUpdateDiseaseInfo", method = RequestMethod.POST)
    public BusinessResult saveOrUpdateDiseaseInfo(@RequestBody DiseaseDTO diseaseDTO) {
        return BusinessResult.success(diseaseService.saveOrUpdateDiseaseInfo(diseaseDTO));
    }

    @ApiOperation(value = "获取疾病关联的器官信息", notes = "获取疾病关联的器官信息")
    @RequestMapping(value = "/getDiseaseRelation", method = RequestMethod.POST)
    public BusinessResult getDiseaseRelation(@RequestBody TDiseaseInfo tDiseaseInfo) {
        return BusinessResult.success(diseaseService.getDiseaseRelation(tDiseaseInfo));
    }

    @ApiOperation(value = "更改疾病信息状态", notes = "用于启用或停用疾病信息")
    @RequestMapping(value = "/changDiseaseStateById", method = RequestMethod.POST)
    public BusinessResult changDiseaseStateById(@RequestBody TDiseaseInfo tDiseaseInfo) {
        return BusinessResult.success(diseaseService.changDiseaseStateById(tDiseaseInfo));
    }
    
    @ApiOperation(value = "获取资源数据", notes = "获取资源数据")
    @RequestMapping(value = "/getResList", method = RequestMethod.GET)
    BusinessResult getResList(@RequestParam(value = "key", required = false) String key) {
        return BusinessResult.success(modelService.getResList(key));
    }
    
    @ApiOperation(value = "获取疾病关联的方案信息", notes = "获取疾病关联的方案信息")
    @RequestMapping(value = "/getDiseaseCaseRelation", method = RequestMethod.POST)
    public BusinessResult getDiseaseCaseRelation(@RequestBody TDiseaseInfo tDiseaseInfo) {
        return BusinessResult.success(diseaseService.getDiseaseCaseRelation(tDiseaseInfo));
    }
    
    @ApiOperation(value = "保存疾病关联的方案信息", notes = "获取疾病关联的方案信息")
    @RequestMapping(value = "/saveDiseaseRelCase", method = RequestMethod.POST)
    public BusinessResult saveDiseaseRelCase(@RequestBody DiseaseDTO dto) {
        return BusinessResult.success(diseaseService.saveDiseaseRelCase(dto));
    }
}
