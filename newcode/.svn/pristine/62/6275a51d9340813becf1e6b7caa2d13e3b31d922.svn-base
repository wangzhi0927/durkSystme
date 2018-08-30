package com.dpm.unity.web.feigns;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.dpm.resource.common.enity.HisPatientRecord;
import com.dpm.resource.common.enity.TCaseInfo;
import com.dpm.resource.common.enity.TPatientTalk;
import com.dpm.resource.common.enity.TRecordInfo;
import com.dpm.resource.common.enity.TalkRecordInfo;
import com.dpm.resource.common.enity.record.RecordInfo;
import com.dpm.unity.web.feigns.hystric.PatientFeignHystric;

/**
 * @ Purpose: 用户服务类FeignsClient
 * @Package Name: com.dpm.unity.web.feigns
 * @Author: liuxiaoxin
 * @Date: 2018/5/15
 */
@FeignClient(value = "dpm-db", fallback = PatientFeignHystric.class)
public interface IPatientFeignClient {

    @RequestMapping("/patient/saveHisPatientRecord")
    HisPatientRecord savePatientInfo(@RequestBody HisPatientRecord tPatientInfo);

    @RequestMapping(value = "/patient/getOperationInfo",method = RequestMethod.POST)
    List<TCaseInfo> getOperationInfo(@RequestParam(value = "code") String code);

    @RequestMapping(value = "/patient/savePatientTalkInfo",method = RequestMethod.POST)
    int savePatientTalkInfo(@RequestBody TalkRecordInfo talkRecordInfo);
    
    @RequestMapping(value = "/patient/getPatientTalkInfoList",method = RequestMethod.POST)
    List<TPatientTalk> getPatientTalkInfoList(@RequestBody TPatientTalk tPatientTalk);
    
    @RequestMapping(value = "/patient/getRecordInfoByCondition",method = RequestMethod.POST)
    List<RecordInfo> getRecordInfoByCondition(@RequestBody TRecordInfo tRecordInfo);
}
