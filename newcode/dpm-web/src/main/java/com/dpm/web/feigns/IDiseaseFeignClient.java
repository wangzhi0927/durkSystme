package com.dpm.web.feigns;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dpm.resource.common.enity.TDiseaseInfo;
import com.dpm.resource.common.enity.TDiseaseRelCase;
import com.dpm.resource.common.enity.TDiseaseRelRes;
import com.dpm.resource.common.enity.disease.DiseaseConditionParam;
import com.dpm.web.feigns.hystric.DiseaseFeignHystric;
import com.github.pagehelper.PageInfo;

@FeignClient(value = "dpm-db", fallback = DiseaseFeignHystric.class)
public interface IDiseaseFeignClient {
    @RequestMapping("/disease/getDiseaseInfoByCondition")
    PageInfo<TDiseaseInfo> getDeptInfoByCondition(@RequestBody DiseaseConditionParam diseaseConditionParam);
    @RequestMapping("/disease/saveOrUpdateDiseaseInfo")
    TDiseaseInfo saveOrUpdateDiseaseInfo(@RequestBody TDiseaseInfo tDiseaseInfo);
    @RequestMapping("/disease/changDiseaseStateById")
    int changDiseaseStateById(@RequestBody TDiseaseInfo tDiseaseInfo);
    
    @RequestMapping("/disease/delDiseaseRelRes")
    int delDiseaseRelRes(@RequestBody TDiseaseRelRes tDiseaseRelRes);
    
    @RequestMapping("/disease/insertDiseaseRelResList")
    List<TDiseaseRelRes> insertDiseaseRelResList(@RequestBody List<TDiseaseRelRes> tDiseaseRelResList);

    @RequestMapping("/disease/getDiseaseRelResList")
    List<TDiseaseRelRes> getDiseaseRelResList(@RequestBody TDiseaseRelRes tDiseaseRelRes);
    
    @RequestMapping("/disease/getDiseaseRelCaseList")
    List<TDiseaseRelCase> getDiseaseRelCaseList(@RequestBody TDiseaseRelCase tDiseaseRelCase);
    
    @RequestMapping("/disease/saveDiseaseRelCase")
    void saveDiseaseRelCase(@RequestBody List<TDiseaseRelCase> tDiseaseRelCaseList);
    
    @RequestMapping("/disease/delDiseaseRelCase")
    int delDiseaseRelCase(@RequestBody TDiseaseRelCase tDiseaseRelCase);
}
