package com.dpm.web.feigns;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dpm.resource.common.enity.TCaseInfo;
import com.dpm.resource.common.enity.TCaseRelRes;
import com.dpm.resource.common.enity.caseinfo.CaseInfoParam;
import com.dpm.web.feigns.hystric.OrganFeignHystric;
import com.github.pagehelper.PageInfo;

@FeignClient(value = "dpm-db", fallback = OrganFeignHystric.class)
public interface ICaseInfoFeignClient {
    @RequestMapping("/case/getCaseInfoByCondition")
    PageInfo<TCaseInfo> getCaseInfoByCondition(@RequestBody CaseInfoParam caseInfoParam);
    
    @RequestMapping(value = "/case/saveOrUpdateCaseInfo", method = RequestMethod.POST)
    TCaseInfo saveOrUpdateCaseInfo(@RequestBody TCaseInfo tCaseInfo);
    
    @RequestMapping(value = "/case/delCaseInfo", method = RequestMethod.POST)
    int delCaseInfo(@RequestBody TCaseInfo tCaseInfo);
    
    @RequestMapping(value = "/case/getCaseRelResList", method = RequestMethod.POST)
    List<TCaseRelRes> getCaseRelResList(TCaseRelRes tCaseRelRes);
    
    @RequestMapping("/case/delCaseRelRes")
    int delCaseRelRes(@RequestBody TCaseRelRes tCaseRelRes);
    
    @RequestMapping("/case/saveCaseRelResList")
    List<TCaseRelRes> saveCaseRelResList(@RequestBody List<TCaseRelRes> tCaseRelResList);
    
    @RequestMapping("/case/getCaseInfoList")
    List<TCaseInfo> getCaseInfoList(@RequestBody TCaseInfo tCaseInfo);

}
