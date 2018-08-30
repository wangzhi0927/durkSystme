package com.dpm.unity.web.patient.controller;

import com.dpm.resource.common.enity.PatientTalkInfo;
import com.dpm.resource.freamwork.BusinessResult;
import com.dpm.unity.web.patient.pojo.request.GetAnamnesisByInpNoRequestData;
import com.dpm.unity.web.patient.pojo.request.GetOperationInfoRequestData;
import com.dpm.unity.web.patient.service.impl.PatientServiceImpl;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: mapengfei
 * @Date: 2018/5/18
 * @Description:
 */
@RestController
@RequestMapping(value = "/patient")
public class PatientController {
    @Autowired
    private PatientServiceImpl patientService;

    @ApiOperation(value = "获取病例信息接口",notes = "通过病历号或住院号检索")
    @RequestMapping(value = "getAnamnesisByInpno",method=RequestMethod.POST,consumes = "application/json", produces = "application/json; charset=UTF-8")
    public BusinessResult getAnamnesisByInpno(@RequestBody GetAnamnesisByInpNoRequestData getAnamnesisByInpNoRequestData) throws Exception{
        return BusinessResult.success(patientService.getAnamnesisByInpNo(getAnamnesisByInpNoRequestData));
    }

    @ApiOperation(value = "检索手术信息接口",notes = "通过拼音码或五笔码检索手术信息")
    @RequestMapping(value = "getOperationInfo",method=RequestMethod.POST,consumes = "application/json", produces = "application/json; charset=UTF-8")
    public BusinessResult getOperationInfo(@RequestBody GetOperationInfoRequestData getOperationInfoRequestData) throws Exception{
        return BusinessResult.success(patientService.getOperationInfo(getOperationInfoRequestData));
    }

    @ApiOperation(value = "患者信息保存接口",notes = "保存患者信息、谈话人信息")
    @RequestMapping(value = "savePatientTalkInfo",method=RequestMethod.POST,consumes = "application/json", produces = "application/json; charset=UTF-8")
    public BusinessResult savePatientTalkInfo(@RequestBody PatientTalkInfo patientTalkInfo)throws Exception{
        return BusinessResult.success(patientService.savePatientTalkInfo(patientTalkInfo));
    }

}
