package com.dpm.web.feigns.hystric;

import java.util.List;

import com.dpm.resource.common.enity.TCaseInfo;
import com.dpm.resource.common.enity.TCaseRelRes;
import com.dpm.resource.common.enity.caseinfo.CaseInfoParam;
import com.dpm.web.feigns.ICaseInfoFeignClient;
import com.github.pagehelper.PageInfo;

public class CaseInfoFeignHystric implements ICaseInfoFeignClient {

	@Override
	public PageInfo<TCaseInfo> getCaseInfoByCondition(CaseInfoParam caseInfoParam) {
		return null;
	}

	@Override
	public TCaseInfo saveOrUpdateCaseInfo(TCaseInfo tCaseInfo) {
		return null;
	}

	@Override
	public int delCaseInfo(TCaseInfo tCaseInfo) {
		return 0;
	}

	@Override
	public List<TCaseRelRes> getCaseRelResList(TCaseRelRes tCaseRelRes) {
		return null;
	}

	@Override
	public int delCaseRelRes(TCaseRelRes tCaseRelRes) {
		return 0;
	}

	@Override
	public List<TCaseRelRes> saveCaseRelResList(List<TCaseRelRes> tCaseRelResList) {
		return null;
	}

	@Override
	public List<TCaseInfo> getCaseInfoList(TCaseInfo tCaseInfo) {
		return null;
	}

}
