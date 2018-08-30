package com.dpm.db.web.organ.service;

import java.util.List;

import com.dpm.resource.common.enity.TOrganInfo;
import com.dpm.resource.common.enity.organ.OrganParam;
import com.github.pagehelper.PageInfo;

public interface IOrganService {
	List<TOrganInfo> getOrganListBySystemId(String systemId, String sex);

	PageInfo<TOrganInfo> getOrganInfoByCondition(OrganParam organParam);

	TOrganInfo saveOrUpdateOrganInfo(TOrganInfo tOrganInfo);

	int delOrganInfo(TOrganInfo tOrganInfo);
}
