package com.dpm.db.web.organ.service.impl;

import java.util.List;
import java.util.Objects;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.dpm.db.common.example.TOrganInfoExample;
import com.dpm.db.common.mapper.TOrganInfoMapper;
import com.dpm.db.web.organ.service.IOrganService;
import com.dpm.resource.common.enity.TOrganInfo;
import com.dpm.resource.common.enity.organ.OrganParam;
import com.dpm.resource.common.utils.UUIDUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * @ Purpose:
 * @Package Name: com.dpm.db.web.user.service.impl
 * @Author: liuxiaoxin
 * @Date: 2018/5/14
 */
@Service
public class OrganServiceImpl implements IOrganService{

    @Autowired
    TOrganInfoMapper organInfoMapper;
    
    @Override
    public List<TOrganInfo> getOrganListBySystemId(String systemId, String sex) {
        TOrganInfoExample organInfoExample = new TOrganInfoExample();
        TOrganInfoExample.Criteria criteria = organInfoExample.createCriteria();
        criteria.andBelongIdEqualTo(systemId);
        if(StringUtils.isNotEmpty(sex)) {
        	criteria.andTypeDefaultEqualTo(sex);
        }
        
        TOrganInfoExample.Criteria criteria1 = organInfoExample.createCriteria();
        criteria1.andBelongIdEqualTo(systemId);
        if(StringUtils.isNotEmpty(sex)) {
        	criteria1.andTypeDefaultEqualTo("0");//通用
        }
        organInfoExample.or(criteria1);
        List<TOrganInfo> result = organInfoMapper.selectByExample(organInfoExample);
        return result;
    }
    
    @Override
    public PageInfo<TOrganInfo> getOrganInfoByCondition(OrganParam organParam) {
        PageHelper.startPage(organParam.getPageNum(), organParam.getPageSize());
        TOrganInfoExample tOrganInfoExample = new TOrganInfoExample();
        TOrganInfoExample.Criteria criteria = tOrganInfoExample.createCriteria();
        TOrganInfo organInfo = organParam.getOrganInfo();
        if(!ObjectUtils.isEmpty(organInfo)){
            if(!StringUtils.isEmpty(organInfo.getOrganName()))
                criteria.andOrganNameLike("%" + organInfo.getOrganName()+"%");
            if(!StringUtils.isEmpty(organInfo.getOrganCode()))
            	criteria.andOrganCodeLike("%" + organInfo.getOrganCode()+"%");
        }
        List<TOrganInfo> tOrganInfoList = organInfoMapper.selectByExample(tOrganInfoExample);
        return new PageInfo<>(tOrganInfoList);
    }
    
    @Override
    public TOrganInfo saveOrUpdateOrganInfo(TOrganInfo tOrganInfo) {
        if(StringUtils.isEmpty(tOrganInfo.getId())){
        	tOrganInfo.setId(UUIDUtils.getUUID());
        	organInfoMapper.insert(tOrganInfo);
        }else{
        	organInfoMapper.updateByPrimaryKey(tOrganInfo);
        }
        return tOrganInfo;
    }
    
    @Override
    public int delOrganInfo(TOrganInfo tOrganInfo) {
    	int ret = 0;
        if(StringUtils.isNotEmpty(tOrganInfo.getId())){
        	ret = organInfoMapper.deleteByPrimaryKey(tOrganInfo.getId());
        }
        return ret;
    }
    
    public List<TOrganInfo> getOrganInfo(TOrganInfo tOrganInfo) {
    	List<TOrganInfo> ret = null;
    	if(Objects.nonNull(tOrganInfo) && StringUtils.isNotEmpty(tOrganInfo.getOrganCode())) {
    		TOrganInfoExample tOrganInfoExample = new TOrganInfoExample();
            TOrganInfoExample.Criteria criteria = tOrganInfoExample.createCriteria();
            criteria.andOrganCodeEqualTo(tOrganInfo.getOrganCode());
            ret = organInfoMapper.selectByExample(tOrganInfoExample);
    	}
    	return  ret;
    }
}
