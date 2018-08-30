package com.dpm.db.web.disease.service;

import com.dpm.resource.common.enity.*;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @Auther: mapengfei
 * @Date: 2018/5/14
 * @Description:
 */
public interface IDiseaseService {

	List<TOrganInfo> getOrganInfoBySystem(String systemId, String sex);

	List<TOrganInfo> getOrganInfoByOragan(String organCode, String sex);

	List<TDiseaseInfo> getDiseaseInfoByOrgan(String organCode, String sex);

	List<ResourceInfo> getRscInfoByOrgan(String organCode, String displayRate);

	List<ResourceInfo> getRscInfoByDisease(String diseaseCode, String displayRate, String resName);

	List<ResourceInfo> getRscInfoByRsc(String resourceId, String displayRate);

	TModelDisplayParam getModeDisplayParam(String resourceId, String displayRate);

	PageInfo<TDiseaseInfo> getDiseaseInfoByCondition(TDiseaseInfo diseaseInfo, int pageSize, int pageNum);

	TDiseaseInfo saveOrUpdateDiseaseInfo(TDiseaseInfo tDiseaseInfo);

	int changDiseaseStateById(TDiseaseInfo tDiseaseInfo);

	List<TTnmInfo> getTnmInfoByDisease(String diseaseCode, String type);

	List<TDiseaseInfo> getDiseaseInfoByConditions(TDiseaseInfo diseaseInfo);

	int delDiseaseRelRes(TDiseaseRelRes tDiseaseRelRes);

	List<TDiseaseRelRes> insertDiseaseRelResList(List<TDiseaseRelRes> tDiseaseRelResList);

	List<TDiseaseRelRes> getDiseaseRelResList(TDiseaseRelRes tDiseaseRelRes);

	List<TDiseaseRelCase> getDiseaseRelCaseList(TDiseaseRelCase tDiseaseRelCase);

	void saveDiseaseRelCase(List<TDiseaseRelCase> tDiseaseRelCaseList);

	int delDiseaseRelCase(TDiseaseRelCase tDiseaseRelCase);

}
