package com.dpm.web.feigns.hystric;

import java.util.List;

import com.dpm.resource.common.enity.TDiseaseInfo;
import com.dpm.resource.common.enity.TDiseaseRelCase;
import com.dpm.resource.common.enity.TDiseaseRelRes;
import com.dpm.resource.common.enity.disease.DiseaseConditionParam;
import com.dpm.web.feigns.IDiseaseFeignClient;
import com.github.pagehelper.PageInfo;

public class DiseaseFeignHystric implements IDiseaseFeignClient {

    @Override
    public PageInfo<TDiseaseInfo> getDeptInfoByCondition(DiseaseConditionParam diseaseConditionParam) {
        return null;
    }

    @Override
    public TDiseaseInfo saveOrUpdateDiseaseInfo(TDiseaseInfo tDiseaseInfo) {
        return null;
    }

    @Override
    public int changDiseaseStateById(TDiseaseInfo tDiseaseInfo) {
        return 0;
    }

	@Override
	public int delDiseaseRelRes(TDiseaseRelRes tDiseaseRelRes) {
		return 0;
	}

	@Override
	public List<TDiseaseRelRes> insertDiseaseRelResList(List<TDiseaseRelRes> tDiseaseRelResList) {
		return null;
	}

	@Override
	public List<TDiseaseRelRes> getDiseaseRelResList(TDiseaseRelRes tDiseaseRelRes) {
		return null;
	}

	@Override
	public List<TDiseaseRelCase> getDiseaseRelCaseList(TDiseaseRelCase tDiseaseRelCase) {
		return null;
	}

	@Override
	public int delDiseaseRelCase(TDiseaseRelCase tDiseaseRelCase) {
		return 0;
	}

	@Override
	public void saveDiseaseRelCase(List<TDiseaseRelCase> tDiseaseRelCaseList) {
		
	}
}
