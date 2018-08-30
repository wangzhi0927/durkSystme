package com.dpm.unity.web.caseInfo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import com.dpm.resource.common.enity.CaseInfo;
import com.dpm.resource.common.enity.PatientRecordInfo;
import com.dpm.resource.common.enity.TCaseRelRes;
import com.dpm.resource.common.enity.TDiseaseInfo;
import com.dpm.resource.common.enity.TDiseaseRelCase;
import com.dpm.resource.common.enity.TRecordInfo;
import com.dpm.resource.common.enity.caseinfo.CaseInfoDTO;
import com.dpm.resource.freamwork.BusinessException;
import com.dpm.unity.common.validation.ValidationProperty;
import com.dpm.unity.web.caseInfo.pojo.request.GetCaseInfoByCaseIdRequestData;
import com.dpm.unity.web.caseInfo.pojo.request.GetCaseInfoByDiseaseRequestData;
import com.dpm.unity.web.caseInfo.pojo.request.GetPatientRecordInfoRequestData;
import com.dpm.unity.web.caseInfo.service.ICaseService;
import com.dpm.unity.web.feigns.ICaseFeignClient;
import com.dpm.unity.web.feigns.IDiseaseFeignClient;

/**
 * @Auther: mapengfei
 * @Date: 2018/5/16
 * @Description:
 */
@Service
public class CaseServiceImpl implements ICaseService {
    @Autowired
    ICaseFeignClient caseFeignClient;
    @Autowired
    IDiseaseFeignClient diseaseFeignClient;
    
    /** 
    * @Description: 获取某疾病下所有方案接口
    * @Param: [getCaseInfoByDiseaseRequestData] 
    * @return: java.util.List<com.dpm.resource.common.enity.caseInfo>
    * @Author: mapengfei 
    * @Date: 2018/5/16 
    */ 
    @Override
    public CaseInfoDTO getCaseInfoByDisease(GetCaseInfoByDiseaseRequestData getCaseInfoByDiseaseRequestData) {
        String checkResult = ValidationProperty.validate(getCaseInfoByDiseaseRequestData,ValidationProperty.GetCaseInfoByDiseaseCheckParams);
        if(!StringUtils.isEmpty(checkResult))
            throw new BusinessException("以下请求入参不可为空：" + checkResult);
        CaseInfoDTO dto = new CaseInfoDTO();
        String diseaseCode = getCaseInfoByDiseaseRequestData.getDiseaseCode();
        TDiseaseInfo diseaseInfo = new TDiseaseInfo();
        diseaseInfo.setDiseaseCode(diseaseCode);
        List<TDiseaseInfo> diseaseList = diseaseFeignClient.getDiseaseInfoByConditions(diseaseInfo);
        if(!ObjectUtils.isEmpty(diseaseList)) {
        	String diseaseId = diseaseList.get(0).getId();
        	TDiseaseRelCase tDiseaseRelCase = new TDiseaseRelCase();
        	tDiseaseRelCase.setDiseaseId(diseaseId);
        	List<TDiseaseRelCase> diseaseRelCaseList = diseaseFeignClient.getDiseaseRelCaseList(tDiseaseRelCase);
        	if(!ObjectUtils.isEmpty(diseaseRelCaseList)) {
        		List<TCaseRelRes> tCaseRelResList = new ArrayList<TCaseRelRes>();
        		for(TDiseaseRelCase tDiseaseRelCaseTmp : diseaseRelCaseList) {
        			TCaseRelRes tCaseRelRes = new TCaseRelRes();
        			tCaseRelRes.setCaseId(tDiseaseRelCaseTmp.getCaseId());
        			tCaseRelResList.addAll(caseFeignClient.getCaseRelResList(tCaseRelRes));
        		}
        		dto.setCaseRelResList(tCaseRelResList);
        	}
        }
        return dto;
    }

    /** 
    * @Description: 获取某方案信息接口
    * @Param: [getCaseInfoByCaseIdRequestData] 
    * @return: com.dpm.resource.common.enity.CaseInfo 
    * @Author: mapengfei 
    * @Date: 2018/5/17 
    */ 
    @Override
    public CaseInfo getCaseInfoByCaseId(GetCaseInfoByCaseIdRequestData getCaseInfoByCaseIdRequestData) {

        String checkResult = ValidationProperty.validate(getCaseInfoByCaseIdRequestData,ValidationProperty.GetCaseInfoByCaseIdCheckParams);
        if(!StringUtils.isEmpty(checkResult))
            throw new BusinessException("以下请求入参不可为空：" + checkResult);
        return caseFeignClient.getCaseInfoByCaseId(getCaseInfoByCaseIdRequestData.getCaseId());
    }
    
    /** 
    * @Description: 获取病人沟通记录信息
    * @Param: [getPatientRecordInfoRequestData] 
    * @return: com.dpm.resource.common.enity.PatientRecordInfo 
    * @Author: mapengfei 
    * @Date: 2018/5/17 
    */ 
    @Override
    public PatientRecordInfo getPatientRecordInfo(GetPatientRecordInfoRequestData getPatientRecordInfoRequestData) {
        String checkResult = ValidationProperty.validate(getPatientRecordInfoRequestData,ValidationProperty.GetPatientRecordInfoCheckParams);
        if(!StringUtils.isEmpty(checkResult))
            throw new BusinessException("以下请求入参不可为空：" + checkResult);
        return caseFeignClient.getPatientRecordInfo(getPatientRecordInfoRequestData.getInpNo(),getPatientRecordInfoRequestData.getHosCode(),getPatientRecordInfoRequestData.getTalkType());
    }
    
    /** 
    * @Description: 保存沟通记录信息
    * @Param: [tRecordInfo] 
    * @return: int 
    * @Author: mapengfei 
    * @Date: 2018/5/17 
    */ 
    @Override
    public int saveTalkRecordInfo(TRecordInfo tRecordInfo) {
        String checkResult = ValidationProperty.validate(tRecordInfo,ValidationProperty.SaveTalkRecordInfoCheckParams);
        if(!StringUtils.isEmpty(checkResult))
            throw new BusinessException("以下请求入参不可为空：" + checkResult);
        int result = caseFeignClient.saveTalkRecordInfo(tRecordInfo);
        if(result <=0)
            throw new BusinessException("保存沟通记录失败");
        return result;
    }
}
