package com.dpm.db.web.patient.service;

import java.util.List;

import com.dpm.resource.common.enity.HisPatientRecord;
import com.dpm.resource.common.enity.TCaseInfo;
import com.dpm.resource.common.enity.TPatientTalk;
import com.dpm.resource.common.enity.TRecordInfo;
import com.dpm.resource.common.enity.TalkRecordInfo;
import com.dpm.resource.common.enity.UserDeptInfo;
import com.dpm.resource.common.enity.record.RecordInfo;

/**
 * @ Purpose:
 * @Package Name: com.dpm.db.web.user.service
 * @Author: liuxiaoxin
 * @Date: 2018/5/14
 */
public interface IPatientService {
    /**
     *
     * @param hisPatientRecord
     * @return
     */
    HisPatientRecord saveHisPatientRecord(HisPatientRecord hisPatientRecord);


    /**
     * @param userDeptInfo
     * @return
     */
    UserDeptInfo saveUserDeptInfo(UserDeptInfo userDeptInfo);


    /**
     * @param code
     * @return
     */
    List<TCaseInfo> getOperationInfo(String code);

	int savePatientTalkInfo(TalkRecordInfo talkRecordInfo);

	List<TPatientTalk> getPatientTalkInfoList(TPatientTalk tPatientTalk);

	List<TRecordInfo> getRecordInfoList(TRecordInfo tRecordInfo);
	
	List<RecordInfo> getRecordInfoByCondition(TRecordInfo recordInfo);
}
