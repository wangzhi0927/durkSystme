package com.dpm.web.feigns;

import java.util.List;
import java.util.Map;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dpm.resource.common.enity.RecordCondition;
import com.dpm.resource.common.enity.TDiseaseInfo;
import com.dpm.resource.common.enity.TModelDisplayParam;
import com.dpm.resource.common.enity.TOrganInfo;
import com.dpm.resource.common.enity.TRecordInfo;
import com.dpm.resource.common.enity.TResourceInfo;
import com.dpm.resource.common.enity.resource.ResourceParam;
import com.dpm.web.feigns.hystric.ResourceFeignHystric;
import com.github.pagehelper.PageInfo;

/**
 * @ Purpose:
 * @Package Name: com.dpm.web.feigns
 * @Author: liuxiaoxin
 * @Date: 2018/5/23
 */
@FeignClient(value = "dpm-db", fallback = ResourceFeignHystric.class)
public interface IResourceFeignClient {
    @RequestMapping("/resource/getModelResourceByCondition")
    PageInfo<TResourceInfo> getModelResourceByCondition(@RequestBody ResourceParam resourceParam);

    @RequestMapping("/resource/getDiseaseList")
    List<TDiseaseInfo> getDiseaseList(@RequestParam(value = "key", required = false) String key);
    
    @RequestMapping("/resource/getDiseaseList")
    List<TDiseaseInfo> getDiseaseList(@RequestBody TDiseaseInfo tDiseaseInfo);

    @RequestMapping("/resource/getOrganList")
    List<TOrganInfo> getOrganList(@RequestParam(value = "key", required = false) String key);

    @RequestMapping(value = "/resource/getRelOrganList")
    List<TResourceInfo> getRefOrganList(@RequestParam(value = "organCode") String organCode);

    @RequestMapping(value = "/resource/getBoneTypeList")
    List<Map<String, String>> getBoneTypeList(@RequestParam(value = "organCode") String organCode);

    @RequestMapping(value = "/resource/saveOrUpdateResourceInfo")
    TResourceInfo saveOrUpdateResourceInfo(@RequestBody TResourceInfo tResourceInfo);
    
    @RequestMapping(value = "/resource/delResourceList")
    int delResourceList(List<String> resourceId);

    @RequestMapping("/sys/record/getRecordInfoByCondition")
    PageInfo<TRecordInfo> getRecordInfoByCondition(@RequestBody RecordCondition resourceParam);
    
    @RequestMapping(value = "/resource/delTModelDisplayParam")
    int delTModelDisplayParam(@RequestBody TModelDisplayParam tModelDisplayParam);
    
    @RequestMapping(value = "/resource/insertDisplayParam")
    List<TModelDisplayParam> insertDisplayParam(@RequestBody List<TModelDisplayParam> tModelDisplayParamList);
    
    @RequestMapping(value = "/resource/getModelDisplayParaList")
    List<TModelDisplayParam> getModelDisplayParaList(@RequestParam(value = "resId", required = false) String resId, @RequestParam(value = "dispayRate", required = false) String dispayRate);
}
