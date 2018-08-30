package com.dpm.db.web.caseInfo.service;

import java.util.List;

import com.dpm.resource.common.enity.CaseInfo;
import com.dpm.resource.common.enity.PatientRecordInfo;
import com.dpm.resource.common.enity.TCaseInfo;
import com.dpm.resource.common.enity.TCaseRelRes;
import com.dpm.resource.common.enity.TRecordInfo;
import com.dpm.resource.common.enity.caseinfo.CaseInfoParam;
import com.github.pagehelper.PageInfo;

/**
 * @Auther: mapengfei
 * @Date: 2018/5/16
 * @Description:
 */
public interface ICaseService {
    List<CaseInfo> getCaseInfoByDisease(String diseaseCode);

    CaseInfo getCaseInfoByCaseId(String caseId);

    PatientRecordInfo getPatientRecordInfo(String inpNo,String hosCode,String talkType);

    int saveTalkRecordInfo(TRecordInfo tRecordInfo);
    
    TCaseInfo saveOrUpdateCaseInfo(TCaseInfo tCaseInfo);

	int delCaseInfo(TCaseInfo tCaseInfo);

	List<TCaseRelRes> getCaseRelResList(TCaseRelRes tCaseRelRes);

	int delCaseRelRes(TCaseRelRes tCaseRelRes);

	PageInfo<TCaseInfo> getCaseInfoByCondition(CaseInfoParam caseParam);

	List<TCaseRelRes> saveCaseRelResList(List<TCaseRelRes> tCaseRelResList);

}
