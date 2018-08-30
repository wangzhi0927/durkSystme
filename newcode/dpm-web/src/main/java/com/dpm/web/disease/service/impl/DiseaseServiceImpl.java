package com.dpm.web.disease.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import com.dpm.resource.common.enity.TCaseInfo;
import com.dpm.resource.common.enity.TDiseaseInfo;
import com.dpm.resource.common.enity.TDiseaseRelCase;
import com.dpm.resource.common.enity.TDiseaseRelRes;
import com.dpm.resource.common.enity.disease.DiseaseConditionParam;
import com.dpm.resource.common.enity.disease.DiseaseDTO;
import com.dpm.resource.freamwork.BusinessException;
import com.dpm.web.disease.service.IDiseaseService;
import com.dpm.web.feigns.ICaseInfoFeignClient;
import com.dpm.web.feigns.IDiseaseFeignClient;
import com.dpm.web.feigns.IResourceFeignClient;
import com.github.pagehelper.PageInfo;

/**
 * @Auther: mapengfei
 * @Date: 2018/6/4
 * @Description:
 */
@Service
public class DiseaseServiceImpl implements IDiseaseService {
    @Autowired
    private IDiseaseFeignClient iDiseaseFeignClient;
    @Autowired
    private IResourceFeignClient resourceFeignClient;
    @Autowired
    private ICaseInfoFeignClient iCaseFeignClient;
    
    @Override
    public PageInfo<TDiseaseInfo> getDiseaseInfoByCondition(DiseaseConditionParam diseaseConditionParam) {
        return iDiseaseFeignClient.getDeptInfoByCondition(diseaseConditionParam);
    }

    @Override
    @Transactional
    public DiseaseDTO saveOrUpdateDiseaseInfo(DiseaseDTO diseaseDTO) {
    	TDiseaseInfo diseaseInfo = diseaseDTO.getDiseaseInfo();
        if(ObjectUtils.isEmpty(diseaseInfo))
            throw new BusinessException("疾病信息不可为空");
        diseaseInfo = iDiseaseFeignClient.saveOrUpdateDiseaseInfo(diseaseInfo);
        List<TDiseaseRelRes> tDiseaseRelResList = diseaseDTO.getDiseaseRelResList();
        if(!ObjectUtils.isEmpty(tDiseaseRelResList)) {
        	TDiseaseRelRes tmp = new TDiseaseRelRes();
        	tmp.setDiseaseId(diseaseInfo.getId());
        	iDiseaseFeignClient.delDiseaseRelRes(tmp);
        	for(TDiseaseRelRes tDiseaseRelRes : tDiseaseRelResList) {
        		tDiseaseRelRes.setDiseaseId(diseaseInfo.getId());
        	}
        	tDiseaseRelResList = iDiseaseFeignClient.insertDiseaseRelResList(tDiseaseRelResList);
        }
        return diseaseDTO;
    }

    @Override
    public DiseaseDTO getDiseaseRelation(TDiseaseInfo tDiseaseInfo) {
    	DiseaseDTO diseaseDTO = new DiseaseDTO();
    	diseaseDTO.setOrganInfoList(resourceFeignClient.getOrganList(tDiseaseInfo.getOrganCode()));
    	TDiseaseRelRes tDiseaseRelRes = new TDiseaseRelRes();
    	tDiseaseRelRes.setDiseaseId(tDiseaseInfo.getId());
    	diseaseDTO.setDiseaseRelResList(iDiseaseFeignClient.getDiseaseRelResList(tDiseaseRelRes));
        return diseaseDTO;
    }

    @Override
    public int changDiseaseStateById(TDiseaseInfo tDiseaseInfo) {
        return iDiseaseFeignClient.changDiseaseStateById(tDiseaseInfo);
    }
    
    @Override
    public DiseaseDTO getDiseaseCaseRelation(TDiseaseInfo tDiseaseInfo) {
    	DiseaseDTO diseaseDTO = new DiseaseDTO();
    	diseaseDTO.setCaseInfoList(iCaseFeignClient.getCaseInfoList(new TCaseInfo()));
    	TDiseaseRelCase tDiseaseRelCase = new TDiseaseRelCase();
    	tDiseaseRelCase.setDiseaseId(tDiseaseInfo.getId());
    	diseaseDTO.setDiseaseRelCaseList(iDiseaseFeignClient.getDiseaseRelCaseList(tDiseaseRelCase));
        return diseaseDTO;
    }
    
    @Override
    public DiseaseDTO saveDiseaseRelCase(DiseaseDTO dto) {
    	if(ObjectUtils.isEmpty(dto)) {
    		throw new BusinessException("疾病信息不可为空");
    	}
    	TDiseaseInfo tDiseaseInfo = dto.getDiseaseInfo();
    	String[] relCaseArray = dto.getRelCaseArray();
    	if(!ObjectUtils.isEmpty(tDiseaseInfo) && StringUtils.isNotEmpty(tDiseaseInfo.getId())) {
    		if(!ObjectUtils.isEmpty(relCaseArray)) {
    			TDiseaseRelCase diseaseRelCase = new TDiseaseRelCase();
    			diseaseRelCase.setDiseaseId(tDiseaseInfo.getId());
    			iDiseaseFeignClient.delDiseaseRelCase(diseaseRelCase);
    			List<TDiseaseRelCase> tDiseaseRelCaseList = new ArrayList<TDiseaseRelCase>();
    			for(String id : relCaseArray) {
    				TDiseaseRelCase tDiseaseRelCase = new TDiseaseRelCase();
    				tDiseaseRelCase.setDiseaseId(tDiseaseInfo.getId());
    				tDiseaseRelCase.setCaseId(id);
    				tDiseaseRelCaseList.add(tDiseaseRelCase);
    			}
    			iDiseaseFeignClient.saveDiseaseRelCase(tDiseaseRelCaseList);
    		}
    	}
    	return dto;
    }
}
