package com.dpm.unity.web.feigns;

import com.dpm.resource.common.enity.*;
import com.dpm.unity.web.feigns.hystric.DiseaseFeignHystric;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value = "dpm-db", fallback = DiseaseFeignHystric.class)
public interface IDiseaseFeignClient {

    @RequestMapping(value = "/disease/getOrganInfoBySystem",method = RequestMethod.POST)
    List<TOrganInfo> getOrganInfoBySystem(@RequestParam(value = "systemId") String systemId, @RequestParam(value = "sex",required = false) String sex);

    @RequestMapping(value = "/disease/getOrganInfoByOragan",method =  RequestMethod.POST)
    List<TOrganInfo> getOrganInfoByOragan(@RequestParam(value = "organCode") String organCode, @RequestParam(value = "sex",required = false) String sex);

    @RequestMapping(value = "/disease/getDiseaseInfoByOrgan",method = RequestMethod.POST)
    List<TDiseaseInfo> getDiseaseInfoByOrgan(@RequestParam(value = "organCode") String organCode, @RequestParam(value = "sex",required = false) String sex);

    @RequestMapping(value = "/disease/getRscInfoByOrgan",method = RequestMethod.POST)
    List<ResourceInfo> getRscInfoByOrgan(@RequestParam(value = "organCode") String organCode, @RequestParam(value = "displayRate") String displayRate);

    @RequestMapping(value = "/disease/getRscInfoByDisease",method = RequestMethod.POST)
    List<ResourceInfo> getRscInfoByDisease(@RequestParam(value = "diseaseCode") String diseaseCode,@RequestParam(value = "displayRate") String displayRate,
                                           @RequestParam(value = "resName",required = false)String resName);

    @RequestMapping(value = "/disease/getRscInfoByRsc",method = RequestMethod.POST)
    List<ResourceInfo> getRscInfoByRsc(@RequestParam(value = "resourceId") String resourceId,@RequestParam(value = "displayRate") String displayRate);

    @RequestMapping(value = "/disease/getModeDisplayParam",method = RequestMethod.POST)
    TModelDisplayParam getModeDisplayParam(@RequestParam(value = "resourceId") String resourceId,@RequestParam(value = "displayRate") String displayRate);

    @RequestMapping(value = "/disease/getTnmInfoByDisease",method = RequestMethod.POST)
    List<TTnmInfo> getTnmInfoByDisease(@RequestParam(value = "diseaseCode") String diseaseCode,@RequestParam(value = "type",required = false) String type);
    
    @RequestMapping(value = "/disease/getDiseaseInfoByConditions",method = RequestMethod.POST)
    List<TDiseaseInfo> getDiseaseInfoByConditions(@RequestBody TDiseaseInfo diseaseInfo);

    @RequestMapping("/disease/getDiseaseRelResList")
    List<TDiseaseRelRes> getDiseaseRelResList(@RequestBody TDiseaseRelRes tDiseaseRelRes);
    
    @RequestMapping("/disease/getDiseaseRelCaseList")
    List<TDiseaseRelCase> getDiseaseRelCaseList(@RequestBody TDiseaseRelCase tDiseaseRelCase);
}
