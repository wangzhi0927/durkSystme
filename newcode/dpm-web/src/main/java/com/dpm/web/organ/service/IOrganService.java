package com.dpm.web.organ.service;

import com.dpm.resource.common.enity.TOrganInfo;
import com.dpm.resource.common.enity.organ.OrganParam;
import com.dpm.web.organ.pojo.OrganRelation;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.pagehelper.PageInfo;

/**
 * @ Purpose:
 * @Package Name: com.dpm.web.model.service
 * @Author: liuxiaoxin
 * @Date: 2018/5/21
 */
public interface IOrganService {
    PageInfo<TOrganInfo> getOrganInfoByCondition(OrganParam organParam);
    
    OrganRelation getOrganRelation() throws JsonProcessingException;
    
    TOrganInfo saveOrUpdateOrganInfo(TOrganInfo tOrganInfo);
    
    int delOrganInfo(TOrganInfo tOrganInfo);
}
