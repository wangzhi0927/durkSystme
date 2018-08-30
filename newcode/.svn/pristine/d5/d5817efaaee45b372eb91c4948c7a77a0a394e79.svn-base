package com.dpm.db.web.model.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import com.dpm.db.common.example.TDiseaseInfoExample;
import com.dpm.db.common.example.TModelDisplayParamExample;
import com.dpm.db.common.example.TOrganInfoExample;
import com.dpm.db.common.example.TResourceInfoExample;
import com.dpm.db.common.mapper.TDiseaseInfoMapper;
import com.dpm.db.common.mapper.TModelDisplayParamMapper;
import com.dpm.db.common.mapper.TOrganInfoMapper;
import com.dpm.db.common.mapper.TResourceInfoMapper;
import com.dpm.db.web.model.service.IResourceService;
import com.dpm.resource.common.enity.TDiseaseInfo;
import com.dpm.resource.common.enity.TModelDisplayParam;
import com.dpm.resource.common.enity.TOrganInfo;
import com.dpm.resource.common.enity.TResourceInfo;
import com.dpm.resource.common.utils.UUIDUtils;
import com.dpm.resource.freamwork.BusinessException;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.util.StringUtil;

/**
 * @ Purpose:
 * 
 * @Package Name: com.dpm.db.web.model.service.impl
 * @Author: liuxiaoxin
 * @Date: 2018/5/23
 */
@Service
public class ResourceServiceImpl implements IResourceService {
	@Autowired
	TResourceInfoMapper tResourceInfoMapper;
	@Autowired
	TDiseaseInfoMapper tDiseaseInfoMapper;
	@Autowired
	TOrganInfoMapper tOrganInfoMapper;
	@Autowired
	TModelDisplayParamMapper tModelDisplayParamMapper;

	@Override
	public PageInfo<TResourceInfo> getModelResourceByCondition(TResourceInfo resourceInfo, int pageSize, int pageNum) {

		PageHelper.startPage(pageNum, pageSize);
		List<TResourceInfo> resourceInfoList = tResourceInfoMapper.selectByExample(initResourceExample(resourceInfo));
		PageInfo<TResourceInfo> page = new PageInfo<>(resourceInfoList);

		return new PageInfo<>(resourceInfoList);
	}

	@Override
	public List<TDiseaseInfo> getDiseaseList(String key) {
		TDiseaseInfoExample tDiseaseInfoExample = new TDiseaseInfoExample();
		if (!StringUtils.isEmpty(key)) {
			String likeKey = "%" + key.toUpperCase() + "%";
			tDiseaseInfoExample.or().andDiseaseNameLike(likeKey);
			tDiseaseInfoExample.or().andPCodeLike(likeKey);
			tDiseaseInfoExample.or().andFCodeLike(likeKey);
			tDiseaseInfoExample.or().andDiseaseCodeEqualTo(key);
		}
		return tDiseaseInfoMapper.selectByExample(tDiseaseInfoExample);
	}
	
	@Override
	public List<TDiseaseInfo> getDiseaseList(TDiseaseInfo tDiseaseInfo) {
		TDiseaseInfoExample tDiseaseInfoExample = new TDiseaseInfoExample();
		if(!ObjectUtils.isEmpty(tDiseaseInfo)) {
			TDiseaseInfoExample.Criteria criteria = tDiseaseInfoExample.createCriteria();
			if(StringUtil.isNotEmpty(tDiseaseInfo.getCancerFlag())){
				criteria.andCancerFlagEqualTo(tDiseaseInfo.getCancerFlag());
			}
		}
		return tDiseaseInfoMapper.selectByExample(tDiseaseInfoExample);
	}

	@Override
	public List<TOrganInfo> getOrganList(String key) {
		TOrganInfoExample tOrganInfoExample = new TOrganInfoExample();
		if (!StringUtils.isEmpty(key)) {
			tOrganInfoExample.or().andOrganNameLike("%" + key + "%");
			tOrganInfoExample.or().andOrganCodeEqualTo(key);
		}
		return tOrganInfoMapper.selectByExample(tOrganInfoExample);
	}

	@Override
	public List<TResourceInfo> getRelOrganList(String organCode) {
		if (StringUtils.isEmpty(organCode))
			return new ArrayList<>();
		TResourceInfoExample tResourceInfoExample = new TResourceInfoExample();
		TResourceInfoExample.Criteria criteria = tResourceInfoExample.createCriteria();
		criteria.andOrganCodeEqualTo(organCode);
		criteria.andBussinessTypeEqualTo("1");
		return tResourceInfoMapper.selectByExample(tResourceInfoExample);
	}

	private static final List<Map<String, String>> BONE_TYPE_LIST = Arrays.asList(new HashMap<String, String>() {
		{
			put("value", "01");
			put("label", "髓内钉");
		}
	}, new HashMap<String, String>() {
		{
			put("value", "02");
			put("label", "螺钉");
		}
	}, new HashMap<String, String>() {
		{
			put("value", "03");
			put("label", "钢板");
		}
	});

	@Override
	public List<Map<String, String>> getBoneTypeList(String organCode) {
		if (StringUtils.isEmpty(organCode))
			return new ArrayList<>();
		TOrganInfoExample tOrganInfoExample = new TOrganInfoExample();
		TOrganInfoExample.Criteria criteria = tOrganInfoExample.createCriteria();
		criteria.andOrganCodeEqualTo(organCode).andOrganTypeEqualTo("04");
		List<TOrganInfo> organInfos = tOrganInfoMapper.selectByExample(tOrganInfoExample);
		return CollectionUtils.isEmpty(organInfos) ? new ArrayList<>() : BONE_TYPE_LIST;
	}

	@Override
	public TResourceInfo saveOrUpdateResourceInfo(TResourceInfo tResourceInfo) {
		if (ObjectUtils.isEmpty(tResourceInfo))
			throw new BusinessException("资源数据不能为空");
		if (StringUtils.isEmpty(tResourceInfo.getId())) {
			tResourceInfo.setId(UUIDUtils.getUUID());
			tResourceInfoMapper.insert(tResourceInfo);
		} else {
			tResourceInfoMapper.updateByPrimaryKeySelective(tResourceInfo);
		}
		return tResourceInfo;
	}

	@Override
	public int delResourceList(List<String> resourceIds) {
		if (!CollectionUtils.isEmpty(resourceIds)) {
			resourceIds.parallelStream().forEach(key -> tResourceInfoMapper.deleteByPrimaryKey(key));
		}
		return resourceIds.size();
	}

	private TResourceInfoExample initResourceExample(TResourceInfo resourceInfo) {
		TResourceInfoExample tResourceInfoExample = new TResourceInfoExample();
		if (ObjectUtils.isEmpty(resourceInfo))
			return tResourceInfoExample;
		TResourceInfoExample.Criteria criteria = tResourceInfoExample.createCriteria();
		if (!ObjectUtils.isEmpty(resourceInfo.getResoName())) {
			criteria.andResoNameLike("%" + resourceInfo.getResoName() +"%");
		}
		if (StringUtil.isNotEmpty(resourceInfo.getDiseaseCode())) {
			criteria.andDiseaseCodeEqualTo(resourceInfo.getDiseaseCode());
		}
		if (StringUtil.isNotEmpty(resourceInfo.getOrganCode())) {
			criteria.andOrganCodeEqualTo(resourceInfo.getOrganCode());
		}
		if (StringUtil.isNotEmpty(resourceInfo.getBussinessType())) {
			criteria.andBussinessTypeEqualTo(resourceInfo.getBussinessType());
		}
		if (StringUtil.isNotEmpty(resourceInfo.getType())) {
			criteria.andTypeEqualTo(resourceInfo.getType());
		}
		if (StringUtil.isNotEmpty(resourceInfo.getId())) {
			criteria.andIdEqualTo(resourceInfo.getId());
		}
		return tResourceInfoExample;
	}

	@Override
	public List<TModelDisplayParam> getModelDisplayParaList(String resId, String dispayRate) {
		if (StringUtil.isEmpty(resId)) {
			throw new BusinessException("资源id不能为空");
		}
		TModelDisplayParamExample tModelDisplayParamExample = new TModelDisplayParamExample();
		TModelDisplayParamExample.Criteria criteria = tModelDisplayParamExample.createCriteria();
		criteria.andResIdEqualTo(resId);
		if (StringUtil.isNotEmpty(dispayRate)) {
			criteria.andDispayRateEqualTo(dispayRate);
		}
		return tModelDisplayParamMapper.selectByExample(tModelDisplayParamExample);
	}

	@Override
	public List<TResourceInfo> getResourceInfoList(TResourceInfo tResourceInfo) {
		return tResourceInfoMapper.selectByExample(initResourceExample(tResourceInfo));
	}
	
	@Override
	public int delTModelDisplayParam(TModelDisplayParam tModelDisplayParam) {
		TModelDisplayParamExample tModelDisplayParamExample = new TModelDisplayParamExample();
		TModelDisplayParamExample.Criteria criteria = tModelDisplayParamExample.createCriteria();
		if(StringUtil.isNotEmpty(tModelDisplayParam.getResId())) {
			criteria.andResIdEqualTo(tModelDisplayParam.getResId());
		}
		return tModelDisplayParamMapper.deleteByExample(tModelDisplayParamExample);
	}
	
	@Override
	public List<TModelDisplayParam> insertDisplayParam(List<TModelDisplayParam> tModelDisplayParamList) {
		if (ObjectUtils.isEmpty(tModelDisplayParamList))
			throw new BusinessException("位置参数数据不能为空");
		for (TModelDisplayParam tModelDisplayParam : tModelDisplayParamList) {
			tModelDisplayParam.setId(UUIDUtils.getUUID());
			tModelDisplayParamMapper.insert(tModelDisplayParam);
		}
		return tModelDisplayParamList;
	}

}
