package com.dpm.unity.web.patient.service;

import com.dpm.resource.common.enity.PatientTalkInfo;
import com.dpm.unity.web.patient.pojo.request.GetAnamnesisByInpNoRequestData;
import com.dpm.unity.web.patient.pojo.request.GetOperationInfoRequestData;
import com.dpm.unity.web.patient.pojo.response.GetAnamnesisByInpNoResponseData;
import com.dpm.unity.web.patient.pojo.response.GetOperationInfoResponseData;

/**
 * @Auther: mapengfei
 * @Date: 2018/5/18
 * @Description:
 */
public interface IPatientService {

    GetAnamnesisByInpNoResponseData getAnamnesisByInpNo(GetAnamnesisByInpNoRequestData getAnamnesisByInpNoRequestData) throws Exception ;

    GetOperationInfoResponseData getOperationInfo(GetOperationInfoRequestData getOperationInfoRequestData);

    int savePatientTalkInfo(PatientTalkInfo patientTalkInfo);

}
