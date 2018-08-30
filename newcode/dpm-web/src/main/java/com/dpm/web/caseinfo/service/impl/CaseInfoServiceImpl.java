package com.dpm.web.caseinfo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import com.dpm.resource.common.enity.TCaseInfo;
import com.dpm.resource.common.enity.TCaseRelRes;
import com.dpm.resource.common.enity.caseinfo.CaseInfoDTO;
import com.dpm.resource.common.enity.caseinfo.CaseInfoParam;
import com.dpm.resource.freamwork.BusinessException;
import com.dpm.web.caseinfo.pojo.CaseInfoRelation;
import com.dpm.web.caseinfo.service.ICaseInfoService;
import com.dpm.web.feigns.ICaseInfoFeignClient;
import com.github.pagehelper.PageInfo;

/**
 * @Auther: mapengfei
 * @Date: 2018/6/4
 * @Description:
 */
@Service
public class CaseInfoServiceImpl implements ICaseInfoService{
    @Autowired
    private ICaseInfoFeignClient iCaseFeignClient;
    
    @Override
    public PageInfo<TCaseInfo> getCaseInfoByCondition(CaseInfoParam caseInfoParam) {
        return iCaseFeignClient.getCaseInfoByCondition(caseInfoParam);
    }
    
    @Transactional
    @Override
    public CaseInfoDTO saveOrUpdateCaseInfo(CaseInfoDTO caseInfoDTO) {
    	TCaseInfo tCaseInfo = caseInfoDTO.getCaseInfo();
    	if(ObjectUtils.isEmpty(tCaseInfo)) {
    		throw new BusinessException("方案信息不可为空");
    	}
    	tCaseInfo = iCaseFeignClient.saveOrUpdateCaseInfo(tCaseInfo);
    	List<TCaseRelRes> caseRelResList = caseInfoDTO.getCaseRelResList();
    	if(!ObjectUtils.isEmpty(caseRelResList)) {
        	TCaseRelRes tmp = new TCaseRelRes();
        	tmp.setCaseId(tCaseInfo.getId());
        	iCaseFeignClient.delCaseRelRes(tmp);
        	for(TCaseRelRes tCaseRelRes : caseRelResList) {
        		tCaseRelRes.setCaseId(tCaseInfo.getId());
        	}
        	caseRelResList = iCaseFeignClient.saveCaseRelResList(caseRelResList);
        }
    	return caseInfoDTO;
    }

	@Override
	public int delCaseInfo(TCaseInfo tCaseInfo) {
		return iCaseFeignClient.delCaseInfo(tCaseInfo);
	}

	@Override
	public CaseInfoRelation getCaseInfoRelation(TCaseInfo tCaseInfo) {
		if(ObjectUtils.isEmpty(tCaseInfo)) {
			return null;
		}
		CaseInfoRelation caseInfoRelation = new CaseInfoRelation();
		TCaseRelRes tCaseRelRes = new TCaseRelRes();
		tCaseRelRes.setCaseId(tCaseInfo.getId());
		caseInfoRelation.setCaseRelResList(iCaseFeignClient.getCaseRelResList(tCaseRelRes));
		return caseInfoRelation;
	}

	@Override
    public List<TCaseInfo> getCaseInfoList(TCaseInfo tCaseInfo) {
        return iCaseFeignClient.getCaseInfoList(tCaseInfo);
    }
	    
}
