package com.dpm.unity.web.feigns.hystric;

import com.dpm.resource.common.enity.CaseInfo;
import com.dpm.resource.common.enity.PatientRecordInfo;
import com.dpm.resource.common.enity.TCaseRelRes;
import com.dpm.resource.common.enity.TRecordInfo;
import com.dpm.unity.web.feigns.ICaseFeignClient;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CaseFeignHystric implements ICaseFeignClient {
    @Override
    public List<CaseInfo> getOrganInfoBySystem(String diseaseCode) {
        return null;
    }

    @Override
    public CaseInfo getCaseInfoByCaseId(String caseId) {
        return null;
    }
    @Override
    public PatientRecordInfo getPatientRecordInfo(String inpNo, String hosCode, String talkType) {
        return null;
    }

    @Override
    public int saveTalkRecordInfo(TRecordInfo tRecordInfo) {
        return 0;
    }

	@Override
	public List<TCaseRelRes> getCaseRelResList(TCaseRelRes tCaseRelRes) {
		return null;
	}
}
