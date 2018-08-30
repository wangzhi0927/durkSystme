package com.dpm.unity.web.organ.service;

import java.util.List;

import com.dpm.resource.common.enity.TOrganInfo;
import com.dpm.resource.common.enity.organ.OrganResDTO;

/**
 * @Auther: gaolei
 * @Date: 2018/5/18
 * @Description:
 */
public interface IOrganService {

	List<TOrganInfo> getOrganListBySystemId(String systemId, String sex) throws Exception ;

	OrganResDTO getModelDisplayParaInfo(String organCode, String dispayRate);
}
