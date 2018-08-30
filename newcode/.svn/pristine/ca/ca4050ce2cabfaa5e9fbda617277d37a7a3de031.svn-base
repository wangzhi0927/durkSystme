package com.dpm.db.web.caseInfo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dpm.db.web.caseInfo.service.impl.CaseServiceImpl;
import com.dpm.resource.common.enity.CaseInfo;
import com.dpm.resource.common.enity.PatientRecordInfo;
import com.dpm.resource.common.enity.TCaseInfo;
import com.dpm.resource.common.enity.TCaseRelRes;
import com.dpm.resource.common.enity.TRecordInfo;
import com.dpm.resource.common.enity.caseinfo.CaseInfoParam;
import com.github.pagehelper.PageInfo;

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
    @RequestMapping(value = "/getCaseInfoByDisease",method = RequestMethod.POST)
    public List<CaseInfo> getCaseInfoByDisease(@RequestParam(value = "diseaseCode") String diseaseCode){
        return caseServiceImpl.getCaseInfoByDisease(diseaseCode);
    }
    @ApiOperation(value = "获取某方案信息接口", notes = "通过主键获取方案信息")
    @RequestMapping(value = "/getCaseInfoByCaseId",method = RequestMethod.POST)
    public CaseInfo getCaseInfoByCaseId(@RequestParam(value = "caseId") String caseId){
        return caseServiceImpl.getCaseInfoByCaseId(caseId);
    }
    @ApiOperation(value = "获取病人沟通记录信息", notes = "通过住院号、医院编码和谈话类型获取沟通记录信息")
    @RequestMapping(value = "/getPatientRecordInfo",method = RequestMethod.POST)
    public PatientRecordInfo getPatientRecordInfo(@RequestParam(value = "inpNo") String inpNo,
                                                  @RequestParam(value = "hosCode") String hosCode,
                                                  @RequestParam(value = "talkType",required = false) String talkType){
        return caseServiceImpl.getPatientRecordInfo(inpNo,hosCode,talkType);
    }
    @ApiOperation(value = "保存沟通记录信息", notes = "沟通结束将谈话类型和沟通结果存放路径保存")
    @RequestMapping(value = "/saveTalkRecordInfo",method = RequestMethod.POST)
    public int saveTalkRecordInfo(@RequestBody TRecordInfo tRecordInfo){
        return caseServiceImpl.saveTalkRecordInfo(tRecordInfo);
    }
    
    @ApiOperation(value = "依据条件获取手术方案列表信息", notes = "查询器官列表信息")
	@RequestMapping(value = "/getCaseInfoByCondition", method = RequestMethod.POST)
	public PageInfo<TCaseInfo> getCaseInfoByCondition(@RequestBody CaseInfoParam caseParam) {
		return caseServiceImpl.getCaseInfoByCondition(caseParam);
	}
    
    @ApiOperation(value = "保存手术方案", notes = "用于保存或者更新手术方案")
    @RequestMapping(value = "/saveOrUpdateCaseInfo", method = RequestMethod.POST)
    public TCaseInfo saveOrUpdateCaseInfo(@RequestBody TCaseInfo tCaseInfo) {
        return caseServiceImpl.saveOrUpdateCaseInfo(tCaseInfo);
    }
	
	@ApiOperation(value = "删除手术方案", notes = "用于删除手术方信息")
    @RequestMapping(value = "/delCaseInfo", method = RequestMethod.POST)
    public int delCaseInfo(@RequestBody TCaseInfo tCaseInfo) {
        return caseServiceImpl.delCaseInfo(tCaseInfo);
    }
	
	@ApiOperation(value = "获取方案关联资源信息", notes = "获取方案关联资源信息")
    @RequestMapping(value = "/getCaseRelResList", method = RequestMethod.POST)
    public List<TCaseRelRes> getCaseRelResList(@RequestBody TCaseRelRes tCaseRelRes) {
        return caseServiceImpl.getCaseRelResList(tCaseRelRes);
    }
	
	@ApiOperation(value = "删除方案关联模型", notes = "删除方案关联模型")
    @RequestMapping(value = "/delCaseRelRes",method = RequestMethod.POST)
    public int delCaseRelRes(@RequestBody TCaseRelRes tCaseRelRes){
        return caseServiceImpl.delCaseRelRes(tCaseRelRes);
    }
    
    @ApiOperation(value = "保存方案关联资源信息", notes = "保存方案关联资源信息")
    @RequestMapping(value = "/saveCaseRelResList", method = RequestMethod.POST)
    public List<TCaseRelRes> saveCaseRelResList(@RequestBody List<TCaseRelRes> tCaseRelResList) {
        return caseServiceImpl.saveCaseRelResList(tCaseRelResList);
    }
    
    @ApiOperation(value = "依据条件获取手术方案列表信息", notes = "依据条件获取手术方案列表信息")
	@RequestMapping(value = "/getCaseInfoList", method = RequestMethod.POST)
	public List<TCaseInfo> getCaseInfoList(@RequestBody TCaseInfo tCaseInfo) {
		return caseServiceImpl.getCaseInfoList(tCaseInfo);
	}

}
