package com.dpm.web.disease.service;

import com.dpm.resource.common.enity.TDiseaseInfo;
import com.dpm.resource.common.enity.disease.DiseaseConditionParam;
import com.dpm.resource.common.enity.disease.DiseaseDTO;
import com.github.pagehelper.PageInfo;

/**
 * @Auther: mapengfei
 * @Date: 2018/6/4
 * @Description:
 */
public interface IDiseaseService {
    PageInfo<TDiseaseInfo> getDiseaseInfoByCondition(DiseaseConditionParam diseaseConditionParam);

    DiseaseDTO saveOrUpdateDiseaseInfo(DiseaseDTO diseaseDTO);

    DiseaseDTO getDiseaseRelation(TDiseaseInfo tDiseaseInfo);

    int changDiseaseStateById(TDiseaseInfo tDiseaseInfo);

	DiseaseDTO getDiseaseCaseRelation(TDiseaseInfo tDiseaseInfo);

	DiseaseDTO saveDiseaseRelCase(DiseaseDTO dto);
}
