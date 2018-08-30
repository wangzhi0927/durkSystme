package com.dpm.unity.web.feigns.hystric;

import java.util.List;

import com.dpm.resource.common.enity.TOrganInfo;
import com.dpm.resource.common.enity.TResourceInfo;
import com.dpm.unity.web.feigns.IOrganFeignClient;

/**
 * @ Purpose:
 * @Package Name: com.dpm.unity.web.feigns.hystric
 * @Author: liuxiaoxin
 * @Date: 2018/5/15
 */
public class OrganFeignHystric implements IOrganFeignClient {
    @Override
    public List<TOrganInfo> getOrganListBySystemId(String systemId, String sex) {
    	return null;
    }

	@Override
	public List<TResourceInfo> getResourceInfoList(TResourceInfo tResourceInfo) {
		return null;
	}

	@Override
	public List<TOrganInfo> getOrganInfo(TOrganInfo tOrganInfo) {
		return null;
	}

}
