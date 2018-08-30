package com.dpm.web.caseinfo.service;

import java.util.List;

import com.dpm.resource.common.enity.TCaseInfo;
import com.dpm.resource.common.enity.caseinfo.CaseInfoDTO;
import com.dpm.resource.common.enity.caseinfo.CaseInfoParam;
import com.dpm.web.caseinfo.pojo.CaseInfoRelation;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.pagehelper.PageInfo;

/**
 * @ Purpose:
 * @Package Name: com.dpm.web.model.service
 * @Author: liuxiaoxin
 * @Date: 2018/5/21
 */
public interface ICaseInfoService {
    PageInfo<TCaseInfo> getCaseInfoByCondition(CaseInfoParam caseInfoParam);
    
    CaseInfoRelation getCaseInfoRelation(TCaseInfo tCaseInfo) throws JsonProcessingException;
    
    CaseInfoDTO saveOrUpdateCaseInfo(CaseInfoDTO caseInfoDTO);
    
    int delCaseInfo(TCaseInfo tCaseInfo);

	List<TCaseInfo> getCaseInfoList(TCaseInfo tCaseInfo);
}
