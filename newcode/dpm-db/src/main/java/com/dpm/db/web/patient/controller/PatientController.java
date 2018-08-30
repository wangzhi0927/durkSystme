package com.dpm.db.web.patient.controller;

import com.dpm.db.web.patient.service.impl.PatientServiceImpl;
import com.dpm.resource.common.enity.*;
import com.dpm.resource.common.enity.record.RecordInfo;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ Purpose:
 * @Package Name: com.dpm.db.web.user.controller
 * @Author: liuxiaoxin
 * @Date: 2018/5/14
 */
@RestController
@RequestMapping("/patient")
public class PatientController {
    @Autowired
    PatientServiceImpl patientService;

    @ApiOperation(value = "保存病人信息", notes = "保存病人基本信息,包括档案信息")
    @RequestMapping(value = "/saveHisPatientRecord", method = RequestMethod.POST)
    HisPatientRecord saveHisPatientRecord(@RequestBody HisPatientRecord hisPatientRecord) {
        return patientService.saveHisPatientRecord(hisPatientRecord);
    }

    @ApiOperation(value = "保存用户科室信息", notes = "从HIS读取用户科室信息并更新至本地")
    @RequestMapping(value = "/saveUserDeptInfo",method = RequestMethod.POST)
    UserDeptInfo saveUserDeptInfo(@RequestBody UserDeptInfo userDeptInfo) {
        return patientService.saveUserDeptInfo(userDeptInfo);
    }

    @ApiOperation(value = "检索手术信息接口接口",notes = "通过拼音码或五笔码检索手术信息")
    @RequestMapping(value = "/getOperationInfo",method = RequestMethod.POST)
    List<TCaseInfo> getOperationInfo(@RequestParam(value = "code")String code){
        return patientService.getOperationInfo(code);
    }
    
    @ApiOperation(value = "患者信息保存接口",notes = "保存患者信息、谈话人信息")
    @RequestMapping(value = "/savePatientTalkInfo",method = RequestMethod.POST)
    int savePatientTalkInfo(@RequestBody TalkRecordInfo talkRecordInfo){
        return patientService.savePatientTalkInfo(talkRecordInfo);
    }
    
    @ApiOperation(value = "获取谈话人信息",notes = "获取谈话人信息")
    @RequestMapping(value = "/getPatientTalkInfoList",method = RequestMethod.POST)
    public List<TPatientTalk> getPatientTalkInfoList(@RequestBody TPatientTalk tPatientTalk){
    	return patientService.getPatientTalkInfoList(tPatientTalk);
    }
    
    @ApiOperation(value = "获取沟通记录信息",notes = "获取沟通记录信息")
    @RequestMapping(value = "/getRecordInfoList",method = RequestMethod.POST)
    public List<TRecordInfo> getRecordInfoList(@RequestBody TRecordInfo tRecordInfo){
    	return patientService.getRecordInfoList(tRecordInfo);
    }

    @RequestMapping(value = "/getRecordInfoByCondition", method = RequestMethod.POST)
    List<RecordInfo> getRecordInfoByCondition(@RequestBody TRecordInfo recordInfo) {
        return patientService.getRecordInfoByCondition(recordInfo);
    }
}
