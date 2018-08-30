package com.dpm.unity.web.caseInfo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.dpm.resource.common.enity.TRecordInfo;
import com.dpm.resource.freamwork.BusinessResult;
import com.dpm.unity.web.caseInfo.pojo.request.GetCaseInfoByCaseIdRequestData;
import com.dpm.unity.web.caseInfo.pojo.request.GetCaseInfoByDiseaseRequestData;
import com.dpm.unity.web.caseInfo.pojo.request.GetPatientRecordInfoRequestData;
import com.dpm.unity.web.caseInfo.service.impl.CaseServiceImpl;

import io.swagger.annotations.ApiOperation;

/**
 * @Auther: mapengfei
 * @Date: 2018/5/16
 * @Description:
 */
@RestController
@RequestMapping(value = "/case")
public class CaseController {
	@Autowired
	private CaseServiceImpl caseServiceImpl;

	@ApiOperation(value = "获取指定疾病下所有方案接口", notes = "通过疾病编码获取方案信息")
	@RequestMapping(value = "/getCaseInfoByDisease", method = RequestMethod.POST, consumes = "application/json", produces = "application/json; charset=UTF-8")
	public BusinessResult getCaseInfoByDisease(
			@RequestBody GetCaseInfoByDiseaseRequestData getCaseInfoByDiseaseRequestData) throws Exception {
		return BusinessResult.success(caseServiceImpl.getCaseInfoByDisease(getCaseInfoByDiseaseRequestData));
	}

	@ApiOperation(value = "获取某方案信息接口", notes = "通过主键获取方案信息")
	@RequestMapping(value = "/getCaseInfoByCaseId", method = RequestMethod.POST, consumes = "application/json", produces = "application/json; charset=UTF-8")
	public BusinessResult getCaseInfoByCaseId(
			@RequestBody GetCaseInfoByCaseIdRequestData getCaseInfoByCaseIdRequestData) throws Exception {
		return BusinessResult.success(caseServiceImpl.getCaseInfoByCaseId(getCaseInfoByCaseIdRequestData));
	}

	@ApiOperation(value = "获取病人沟通记录信息", notes = "通过住院号、医院编码和谈话类型获取沟通记录信息")
	@RequestMapping(value = "/getPatientRecordInfo", method = RequestMethod.POST, consumes = "application/json", produces = "application/json; charset=UTF-8")
	public BusinessResult getPatientRecordInfo(
			@RequestBody GetPatientRecordInfoRequestData getPatientRecordInfoRequestData) throws Exception {
		return BusinessResult.success(caseServiceImpl.getPatientRecordInfo(getPatientRecordInfoRequestData));
	}

	@ApiOperation(value = "保存沟通记录信息", notes = "沟通结束将谈话类型和沟通结果存放路径保存")
	@RequestMapping(value = "/saveTalkRecordInfo", method = RequestMethod.POST, consumes = "application/json", produces = "application/json; charset=UTF-8")
	public BusinessResult saveTalkRecordInfo(@RequestBody TRecordInfo tRecordInfo) throws Exception {
		return BusinessResult.success(caseServiceImpl.saveTalkRecordInfo(tRecordInfo));
	}
}
