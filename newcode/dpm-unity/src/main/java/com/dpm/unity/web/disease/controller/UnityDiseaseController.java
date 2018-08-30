package com.dpm.unity.web.disease.controller;

import com.dpm.resource.common.enity.ResourceInfo;
import com.dpm.resource.common.enity.TDiseaseInfo;
import com.dpm.resource.common.enity.TOrganInfo;
import com.dpm.resource.common.enity.TResourceInfo;
import com.dpm.resource.freamwork.BusinessResult;
import com.dpm.unity.web.disease.pojo.request.*;
import com.dpm.unity.web.disease.pojo.response.GetDiseaseInfoResponseData;
import com.dpm.unity.web.disease.pojo.response.GetOrganInfoResponseData;
import com.dpm.unity.web.disease.pojo.response.GetRscInfoResponseData;
import com.dpm.unity.web.disease.service.impl.UnityDiseaseServiceImpl;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Auther: mapengfei
 * @Date: 2018/5/14
 * @Description:疾病模块控制器
 */
@RestController
@RequestMapping(value = "/disease")
public class UnityDiseaseController {

    @Autowired
    private UnityDiseaseServiceImpl diseaseService;

    @ApiOperation(value = "获取指定系统下对应的器官信息", notes = "通过系统编号和性别获取器官信息")
    @RequestMapping(value = "/getOrganInfoBySystem",method = RequestMethod.POST,consumes = "application/json", produces = "application/json; charset=UTF-8")
    public BusinessResult getOrganInfoBySystem(@RequestBody GetOrganInfoBySystemRequestData getOrganInfoBySystemRequestData) throws Exception {
        List<TOrganInfo> organInfos = diseaseService.getOrganInfoBySystem(getOrganInfoBySystemRequestData);
        GetOrganInfoResponseData responseData = new GetOrganInfoResponseData();
        responseData.setOrganInfo(organInfos);
        return BusinessResult.success(responseData);
    }
    @ApiOperation(value = "获取指定器官下对应的器官信息", notes = "通过器官编码和性别获取器官信息")
    @RequestMapping(value = "/getOrganInfoByOrgan",method = RequestMethod.POST,consumes = "application/json", produces = "application/json; charset=UTF-8")
    public BusinessResult getOrganInfoByOrgan(@RequestBody GetOrganInfoByOrganRequestData getOrganInfoByOraganRequestData ) throws Exception{
        List<TOrganInfo> organInfos = diseaseService.getOrganInfoByOrgan(getOrganInfoByOraganRequestData);
        GetOrganInfoResponseData responseData = new GetOrganInfoResponseData();
        responseData.setOrganInfo(organInfos);
        return BusinessResult.success(responseData);
    }
    @ApiOperation(value = "获取指定器官下对应的疾病信息", notes = "通过器官编码和性别获取疾病信息")
    @RequestMapping(value = "/getDiseaseInfoByOrgan",method = RequestMethod.POST,consumes = "application/json", produces = "application/json; charset=UTF-8")
    public BusinessResult getDiseInfoByOrgan(@RequestBody GetDiseaseInfoByOrganRequestData getDiseaseInfoByOraganRequestData)throws Exception{
        List<TDiseaseInfo> diseaseInfos = diseaseService.getDiseaseInfoByOrgan(getDiseaseInfoByOraganRequestData);
        GetDiseaseInfoResponseData responseData = new GetDiseaseInfoResponseData();
        responseData.setDiseaseInfo(diseaseInfos);
        return BusinessResult.success(responseData);
    }
    @ApiOperation(value = "获取指定器官下对应的生理模型资源信息", notes = "通过器官编码获取生理模型资源信息")
    @RequestMapping(value = "/getRscInfoByOrgan",method = RequestMethod.POST,consumes = "application/json", produces = "application/json; charset=UTF-8")
    public BusinessResult getRscInfoByOrgan(@RequestBody GetRscInfoByOrganRequestData getRscInfoByOrganRequestData)throws Exception{
        List<ResourceInfo> resourceInfos = diseaseService.getRscInfoByOrgan(getRscInfoByOrganRequestData);
        GetRscInfoResponseData responseData = new GetRscInfoResponseData();
        responseData.setNormalRsc(resourceInfos);
        return BusinessResult.success(responseData);
    }
    @ApiOperation(value = "获取某疾病或某需要被替换的资源下病理模型资源信息", notes = "通过疾病编码和资源名称获取病理模型资源信息")
    @RequestMapping(value = "/getRscInfoByDiseaseAndResName",method = RequestMethod.POST,consumes = "application/json", produces = "application/json; charset=UTF-8")
    public  BusinessResult getRscInfoByDiseaseAndResName(@RequestBody GetRscInfoByDiseaseRequestData getRscInfoByDiseaseRequestData) throws Exception{
        List<ResourceInfo> resourceInfos = diseaseService.getRscInfoByDisease(getRscInfoByDiseaseRequestData);
        GetRscInfoResponseData responseData = new GetRscInfoResponseData();
        responseData.setNRsc(resourceInfos);
        return BusinessResult.success(responseData);
    }
    @ApiOperation(value = "获取指定资源下对应的病理资源信息", notes = "通过生理资源ID获取对应得病理资源信息")
    @RequestMapping(value = "/getRscInfoByRsc",method = RequestMethod.POST,consumes = "application/json", produces = "application/json; charset=UTF-8")
    public BusinessResult getRscInfoByRsc(@RequestBody GetRscInfoByRscRequestData getRscInfoByRscRequestData) throws Exception{
        List<ResourceInfo> resourceInfos = diseaseService.getRscInfoByRsc(getRscInfoByRscRequestData);
        GetRscInfoResponseData responseData = new GetRscInfoResponseData();
        responseData.setNRsc(resourceInfos);
        return BusinessResult.success(responseData);
    }
    @ApiOperation(value = "获取资源显示参数信息", notes = "通过资源ID和屏幕长宽比获取显示参数信息")
    @RequestMapping(value = "/getModelDisplayParam",method = RequestMethod.POST,consumes = "application/json", produces = "application/json; charset=UTF-8")
    public BusinessResult getModelDisplayParam(@RequestBody GetModeDisplayParamRequestData getModeDisplayParamRequestData)throws Exception{
        return BusinessResult.success(diseaseService.getModeDisplayParam(getModeDisplayParamRequestData));
    }

    @ApiOperation(value = "获取TNM信息", notes = "通过疾病编码和类型获取TNM信息")
    @RequestMapping(value = "/getTnmInfoByDisease",method = RequestMethod.POST,consumes = "application/json", produces = "application/json; charset=UTF-8")
    public BusinessResult getTnmInfoByDisease(@RequestBody GetTnmInfoByDiseaseRequestData getTnmInfoByDiseaseRequestData)throws Exception{
        return BusinessResult.success(diseaseService.getTnmInfoByDisease(getTnmInfoByDiseaseRequestData));
    }
    
    @ApiOperation(value = "获取资源信息",notes = "通过疾病编码，屏幕比例和平台获取资源信息(platform 1：windows 2：android 3：ios)")
    @RequestMapping(value = "getResourceInfo",method=RequestMethod.GET)
    public BusinessResult getResourceInfo(String diseaseCode, String dispayRate, String platform) throws Exception{
        return BusinessResult.success(diseaseService.getResourceInfo(diseaseCode, dispayRate, platform));
    }


}
