package com.dpm.web.organ.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dpm.resource.common.enity.TOrganInfo;
import com.dpm.resource.common.enity.TResourceInfo;
import com.dpm.resource.common.enity.organ.OrganParam;
import com.dpm.resource.common.utils.DictUtil;
import com.dpm.web.feigns.IOrganFeignClient;
import com.dpm.web.organ.pojo.OrganRelation;
import com.dpm.web.organ.service.IOrganService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.pagehelper.PageInfo;

/**
 * @Auther: mapengfei
 * @Date: 2018/6/4
 * @Description:
 */
@Service
public class OrganServiceImpl implements IOrganService{
    @Autowired
    private IOrganFeignClient iOrganFeignClient;
    
    @Autowired
    private DictUtil dictUtil;
    
    public PageInfo<TOrganInfo> getOrganInfoByCondition(OrganParam organParam) {
        return iOrganFeignClient.getOrganInfoByCondition(organParam);
    }
    
    @Override
    public OrganRelation getOrganRelation() throws JsonProcessingException {
    	OrganRelation organRelation = new OrganRelation();
    	organRelation.setSysInfo(dictUtil.getSysteminfo());
    	TResourceInfo tResourceInfo = new TResourceInfo();
    	tResourceInfo.setType("0");//3D
    	tResourceInfo.setBussinessType("1");//生理
    	List<TResourceInfo> tresourceInfoList = iOrganFeignClient.getResourceInfoList(tResourceInfo);
    	organRelation.setRelModelList(tresourceInfoList);
    	return organRelation;
    }
    
    @Transactional
    @Override
    public TOrganInfo saveOrUpdateOrganInfo(TOrganInfo tOrganInfo) {
    	tOrganInfo = iOrganFeignClient.saveOrUpdateOrganInfo(tOrganInfo);
    	return tOrganInfo;
    }

	@Override
	public int delOrganInfo(TOrganInfo tOrganInfo) {
		return iOrganFeignClient.delOrganInfo(tOrganInfo);
	}


}
