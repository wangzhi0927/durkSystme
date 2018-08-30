package com.dpm.db.web.disease.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dpm.db.web.disease.service.impl.DiseaseServiceImpl;
import com.dpm.resource.common.enity.ResourceInfo;
import com.dpm.resource.common.enity.TDiseaseInfo;
import com.dpm.resource.common.enity.TDiseaseRelCase;
import com.dpm.resource.common.enity.TDiseaseRelRes;
import com.dpm.resource.common.enity.TModelDisplayParam;
import com.dpm.resource.common.enity.TOrganInfo;
import com.dpm.resource.common.enity.TTnmInfo;
import com.dpm.resource.common.enity.disease.DiseaseConditionParam;
import com.github.pagehelper.PageInfo;

import io.swagger.annotations.ApiOperation;

/**
 * @Auther: mapengfei
 * @Date: 2018/5/14
 * @Description:
 */
@RestController
@RequestMapping(value = "/disease")
public class DiseaseController {
    @Autowired
    DiseaseServiceImpl diseaseService;

    @ApiOperation(value = "获取指定系统下对应的器官信息", notes = "通过系统编号和性别获取器官信息")
    @RequestMapping(value = "/getOrganInfoBySystem",method = RequestMethod.POST)
    public List<TOrganInfo> getOrganInfoBySystem(@RequestParam(value = "systemId") String systemId,
                                                 @RequestParam(value = "sex",required = false) String sex){
        return diseaseService.getOrganInfoBySystem(systemId,sex);
    }
    @ApiOperation(value = "获取指定器官下对应的器官信息", notes = "通过器官编码和性别获取器官信息")
    @RequestMapping(value = "/getOrganInfoByOragan",method = RequestMethod.POST)
    public List<TOrganInfo>  getOrganInfoByOragan(@RequestParam(value = "organCode")String organCode,
                                                  @RequestParam(value = "sex",required = false) String sex){
        return diseaseService.getOrganInfoByOragan(organCode,sex);
    }
    @ApiOperation(value = "获取指定器官下对应的疾病信息", notes = "通过器官编码和性别获取疾病信息")
    @RequestMapping(value = "/getDiseaseInfoByOrgan",method = RequestMethod.POST)
    public List<TDiseaseInfo> getDiseaseInfoByOrgan(@RequestParam(value = "organCode")String organCode,
                                                     @RequestParam(value = "sex",required = false) String sex){
        return diseaseService.getDiseaseInfoByOrgan(organCode,sex);
    }
    @ApiOperation(value = "获取指定器官下对应的生理模型资源信息", notes = "通过器官编码获取生理模型资源信息")
    @RequestMapping(value = "/getRscInfoByOrgan",method = RequestMethod.POST)
    public List<ResourceInfo> getRscInfoByOrgan(@RequestParam(value = "organCode")String organCode,@RequestParam(value = "displayRate") String displayRate){

        return diseaseService.getRscInfoByOrgan(organCode,displayRate);
    }
    @ApiOperation(value = "获取某疾病或某需要被替换的资源下病理模型资源信息", notes = "通过疾病编码和资源名称获取病理模型资源信息")
    @RequestMapping(value = "/getRscInfoByDisease",method = RequestMethod.POST)
    public List<ResourceInfo> getRscInfoByDisease(@RequestParam(value = "diseaseCode") String diseaseCode,@RequestParam(value = "displayRate") String displayRate,
                                                  @RequestParam(value = "resName",required = false)String resName){
        return diseaseService.getRscInfoByDisease(diseaseCode,displayRate,resName);
    }
    @ApiOperation(value = "获取指定资源下对应的病理资源信息", notes = "通过生理资源ID获取对应得病理资源信息")
    @RequestMapping(value = "/getRscInfoByRsc",method = RequestMethod.POST)
    public List<ResourceInfo> getRscInfoByRsc(@RequestParam(value = "resourceId") String resourceId,@RequestParam(value = "displayRate") String displayRate){
        return diseaseService.getRscInfoByRsc(resourceId,displayRate);
    }

    @ApiOperation(value = "获取资源显示参数信息", notes = "通过资源ID和屏幕长宽比获取显示参数信息")
    @RequestMapping(value = "/getModelDisplayParam",method = RequestMethod.POST)
    public TModelDisplayParam getModelDisplayParam(@RequestParam(value = "resourceId") String resourceId,
                                                   @RequestParam(value = "displayRate") String displayRate){
        return diseaseService.getModeDisplayParam(resourceId,displayRate);
    }

    @ApiOperation(value = "依据条件获取疾病列表信息", notes = "查询疾病列表信息")
    @RequestMapping(value = "/getDiseaseInfoByCondition", method = RequestMethod.POST)
    public PageInfo<TDiseaseInfo> getDiseaseInfoByCondition(@RequestBody DiseaseConditionParam diseaseConditionParam){
        return diseaseService.getDiseaseInfoByCondition(diseaseConditionParam.getDiseaseInfo(),diseaseConditionParam.getPageSize(),diseaseConditionParam.getPageNum());

    }

    @ApiOperation(value = "保存疾病信息", notes = "用于保存或者更新疾病信息")
    @RequestMapping(value = "/saveOrUpdateDiseaseInfo", method = RequestMethod.POST)
    public TDiseaseInfo saveOrUpdateDiseaseInfo(@RequestBody TDiseaseInfo tDiseaseInfo) {
        return diseaseService.saveOrUpdateDiseaseInfo(tDiseaseInfo);
    }

    @ApiOperation(value = "更改疾病信息状态", notes = "用于启用或停用疾病信息")
    @RequestMapping(value = "/changDiseaseStateById", method = RequestMethod.POST)
    public int changDiseaseStateById(@RequestBody TDiseaseInfo tDiseaseInfo) {
        return diseaseService.changDiseaseStateById(tDiseaseInfo);
    }

    @ApiOperation(value = "获取TNM信息", notes = "通过疾病编码和类型获取TNM信息")
    @RequestMapping(value = "/getTnmInfoByDisease",method = RequestMethod.POST)
    public List<TTnmInfo> getTnmInfoByDisease(@RequestParam(value = "diseaseCode")String diseaseCode,
                                              @RequestParam(value = "type",required = false)String type){
        return diseaseService.getTnmInfoByDisease(diseaseCode,type);
    }
    
    @ApiOperation(value = "获取疾病信息", notes = "获取疾病信息")
    @RequestMapping(value = "/getDiseaseInfoByConditions",method = RequestMethod.POST)
    public List<TDiseaseInfo> getDiseaseInfoByConditions(@RequestBody TDiseaseInfo diseaseInfo){
        return diseaseService.getDiseaseInfoByConditions(diseaseInfo);
    }
    
    @ApiOperation(value = "删除疾病关联模型", notes = "删除疾病关联模型")
    @RequestMapping(value = "/delDiseaseRelRes",method = RequestMethod.POST)
    public int delDiseaseRelRes(@RequestBody TDiseaseRelRes tDiseaseRelRes){
        return diseaseService.delDiseaseRelRes(tDiseaseRelRes);
    }
    
    @ApiOperation(value = "保存疾病关联资源信息", notes = "保存疾病关联资源信息")
    @RequestMapping(value = "/insertDiseaseRelResList", method = RequestMethod.POST)
    public List<TDiseaseRelRes> insertDiseaseRelResList(@RequestBody List<TDiseaseRelRes> tDiseaseRelResList) {
        return diseaseService.insertDiseaseRelResList(tDiseaseRelResList);
    }
    
    @ApiOperation(value = "获取疾病关联资源信息", notes = "获取疾病关联资源信息")
    @RequestMapping(value = "/getDiseaseRelResList", method = RequestMethod.POST)
    public List<TDiseaseRelRes> getDiseaseRelResList(@RequestBody TDiseaseRelRes tDiseaseRelRes) {
        return diseaseService.getDiseaseRelResList(tDiseaseRelRes);
    }
    
    @ApiOperation(value = "获取疾病关联方案信息", notes = "获取疾病关联方案信息")
    @RequestMapping(value = "/getDiseaseRelCaseList", method = RequestMethod.POST)
    public List<TDiseaseRelCase> getDiseaseRelCaseList(@RequestBody TDiseaseRelCase tDiseaseRelCase) {
        return diseaseService.getDiseaseRelCaseList(tDiseaseRelCase);
    }
    
    @ApiOperation(value = "保存疾病关联方案信息", notes = "保存疾病关联方案信息")
    @RequestMapping(value = "/saveDiseaseRelCase", method = RequestMethod.POST)
    public void saveDiseaseRelCase(@RequestBody List<TDiseaseRelCase> tDiseaseRelCaseList) {
    	diseaseService.saveDiseaseRelCase(tDiseaseRelCaseList);
    }

    @ApiOperation(value = "删除疾病关联方案", notes = "删除疾病关联方案")
    @RequestMapping(value = "/delDiseaseRelCase",method = RequestMethod.POST)
    public int delDiseaseRelCase(@RequestBody TDiseaseRelCase tDiseaseRelCase){
        return diseaseService.delDiseaseRelCase(tDiseaseRelCase);
    }
    
}
