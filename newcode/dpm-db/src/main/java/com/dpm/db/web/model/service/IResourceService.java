package com.dpm.db.web.model.service;

import java.util.List;
import java.util.Map;

import com.dpm.resource.common.enity.TDiseaseInfo;
import com.dpm.resource.common.enity.TModelDisplayParam;
import com.dpm.resource.common.enity.TOrganInfo;
import com.dpm.resource.common.enity.TResourceInfo;
import com.github.pagehelper.PageInfo;

/**
 * @ Purpose:
 * 
 * @Package Name: com.dpm.db.web.model.service
 * @Author: liuxiaoxin
 * @Date: 2018/5/23
 */
public interface IResourceService {
	PageInfo<TResourceInfo> getModelResourceByCondition(TResourceInfo resourceInfo, int pageSize, int pageNum);

	List<TDiseaseInfo> getDiseaseList(String key);

	List<TOrganInfo> getOrganList(String key);

	List<TResourceInfo> getRelOrganList(String organCode);

	List<Map<String, String>> getBoneTypeList(String organCode);

	TResourceInfo saveOrUpdateResourceInfo(TResourceInfo tResourceInfo);

	int delResourceList(List<String> resourceIds);

	List<TModelDisplayParam> getModelDisplayParaList(String resId, String dispayRate);

	List<TResourceInfo> getResourceInfoList(TResourceInfo tResourceInfo) ;

	List<TDiseaseInfo> getDiseaseList(TDiseaseInfo tDiseaseInfo);

	int delTModelDisplayParam(TModelDisplayParam tModelDisplayParam);

	List<TModelDisplayParam> insertDisplayParam(List<TModelDisplayParam> tModelDisplayParamList);
}
