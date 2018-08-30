package com.dpm.web.feigns.hystric;

import com.dpm.resource.common.enity.TTnmInfo;
import com.dpm.resource.common.enity.tnm.TnmParam;
import com.dpm.web.feigns.ITnmFeignClient;
import com.github.pagehelper.PageInfo;

public class TnmFeignHystric implements ITnmFeignClient {

	@Override
	public PageInfo<TTnmInfo> getTnmInfoByCondition(TnmParam organParam) {
		return null;
	}

	@Override
	public TTnmInfo saveOrUpdateTnmInfo(TTnmInfo tTnmInfo) {
		return null;
	}

	@Override
	public int delTnmInfo(TTnmInfo tTnmInfo) {
		return 0;
	}

}
