package com.dpm.unity.web.caseInfo.service;

import com.dpm.resource.common.enity.CaseInfo;
import com.dpm.resource.common.enity.PatientRecordInfo;
import com.dpm.resource.common.enity.TRecordInfo;
import com.dpm.resource.common.enity.caseinfo.CaseInfoDTO;
import com.dpm.unity.web.caseInfo.pojo.request.GetCaseInfoByCaseIdRequestData;
import com.dpm.unity.web.caseInfo.pojo.request.GetCaseInfoByDiseaseRequestData;
import com.dpm.unity.web.caseInfo.pojo.request.GetPatientRecordInfoRequestData;

/**
 * @Auther: mapengfei
 * @Date: 2018/5/16
 * @Description:
 */
public interface ICaseService {

	CaseInfoDTO getCaseInfoByDisease(GetCaseInfoByDiseaseRequestData getCaseInfoByDiseaseRequestData);

    CaseInfo getCaseInfoByCaseId(GetCaseInfoByCaseIdRequestData getCaseInfoByCaseIdRequestData);

    PatientRecordInfo getPatientRecordInfo(GetPatientRecordInfoRequestData getPatientRecordInfoRequestData);

    int saveTalkRecordInfo(TRecordInfo tRecordInfo);

}
