package com.dpm.unity.web.feigns.hystric;

import java.util.List;

import com.dpm.resource.common.enity.HisPatientRecord;
import com.dpm.resource.common.enity.TCaseInfo;
import com.dpm.resource.common.enity.TPatientTalk;
import com.dpm.resource.common.enity.TRecordInfo;
import com.dpm.resource.common.enity.TalkRecordInfo;
import com.dpm.resource.common.enity.record.RecordInfo;
import com.dpm.unity.web.feigns.IPatientFeignClient;

/**
 * @ Purpose:
 * @Package Name: com.dpm.unity.web.feigns.hystric
 * @Author: liuxiaoxin
 * @Date: 2018/5/15
 */
public class PatientFeignHystric implements IPatientFeignClient {
    @Override
    public HisPatientRecord savePatientInfo(HisPatientRecord tPatientInfo) {
        return null;
    }

    @Override
    public List<TCaseInfo> getOperationInfo(String code) {
        return null;
    }

	@Override
	public int savePatientTalkInfo(TalkRecordInfo talkRecordInfo) {
		return 0;
	}

	@Override
	public List<TPatientTalk> getPatientTalkInfoList(TPatientTalk tPatientTalk) {
		return null;
	}

	@Override
	public List<RecordInfo> getRecordInfoByCondition(TRecordInfo tRecordInfo) {
		return null;
	}
}
