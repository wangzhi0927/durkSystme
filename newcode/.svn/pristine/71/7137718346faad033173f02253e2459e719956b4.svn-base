package com.dpm.unity.web.feigns;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.dpm.resource.common.enity.CaseInfo;
import com.dpm.resource.common.enity.PatientRecordInfo;
import com.dpm.resource.common.enity.TCaseRelRes;
import com.dpm.resource.common.enity.TRecordInfo;
import com.dpm.unity.web.feigns.hystric.CaseFeignHystric;

@FeignClient(value = "dpm-db", fallback = CaseFeignHystric.class)
public interface ICaseFeignClient {

    @RequestMapping(value = "/case/getCaseInfoByDisease",method = RequestMethod.POST)
    List<CaseInfo> getOrganInfoBySystem(@RequestParam(value = "diseaseCode") String diseaseCode);

    @RequestMapping(value = "/case/getCaseInfoByCaseId",method = RequestMethod.POST)
    CaseInfo getCaseInfoByCaseId(@RequestParam(value = "caseId") String caseId);

    @RequestMapping(value = "/case/getPatientRecordInfo",method = RequestMethod.POST)
    PatientRecordInfo getPatientRecordInfo(@RequestParam(value = "inpNo") String inpNo,
                                           @RequestParam(value = "hosCode") String hosCode,
                                           @RequestParam(value = "talkType",required = false) String talkType);
    @RequestMapping(value = "/case/saveTalkRecordInfo",method = RequestMethod.POST)
    int saveTalkRecordInfo(TRecordInfo tRecordInfo);
    
    @RequestMapping(value = "/case/getCaseRelResList")
    List<TCaseRelRes> getCaseRelResList(@RequestBody TCaseRelRes tCaseRelRes);

}
