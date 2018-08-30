package com.dpm.db.web.disease.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import com.dpm.db.common.example.TDiseaseInfoExample;
import com.dpm.db.common.example.TDiseaseRelCaseExample;
import com.dpm.db.common.example.TDiseaseRelResExample;
import com.dpm.db.common.example.TModelDisplayParamExample;
import com.dpm.db.common.example.TOrganInfoExample;
import com.dpm.db.common.example.TResourceInfoExample;
import com.dpm.db.common.example.TTnmInfoExample;
import com.dpm.db.common.mapper.TDiseaseInfoMapper;
import com.dpm.db.common.mapper.TDiseaseRelCaseMapper;
import com.dpm.db.common.mapper.TDiseaseRelResMapper;
import com.dpm.db.common.mapper.TModelDisplayParamMapper;
import com.dpm.db.common.mapper.TOrganInfoMapper;
import com.dpm.db.common.mapper.TResourceInfoMapper;
import com.dpm.db.common.mapper.TTnmInfoMapper;
import com.dpm.db.web.disease.service.IDiseaseService;
import com.dpm.resource.common.enity.ResourceInfo;
import com.dpm.resource.common.enity.TDiseaseInfo;
import com.dpm.resource.common.enity.TDiseaseRelCase;
import com.dpm.resource.common.enity.TDiseaseRelRes;
import com.dpm.resource.common.enity.TModelDisplayParam;
import com.dpm.resource.common.enity.TOrganInfo;
import com.dpm.resource.common.enity.TResourceInfo;
import com.dpm.resource.common.enity.TTnmInfo;
import com.dpm.resource.common.utils.UUIDUtils;
import com.dpm.resource.freamwork.BusinessException;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.util.StringUtil;

/**
 * @Auther: mapengfei
 * @Date: 2018/5/15
 * @Description:
 */
@Service
public class DiseaseServiceImpl implements IDiseaseService {

	@Autowired
	private TOrganInfoMapper organInfoMapper;
	@Autowired
	private TDiseaseInfoMapper diseaseInfoMapper;
	@Autowired
	private TResourceInfoMapper resourceInfoMapper;
	@Autowired
	private TModelDisplayParamMapper modelDisplayParamMapper;
	@Autowired
	private TTnmInfoMapper tnmInfoMapper;
	@Autowired
	private TDiseaseRelResMapper tDiseaseRelResMapper;
	@Autowired
	private TDiseaseRelCaseMapper tDiseaseRelCaseMapper;

	@Override
	public List<TOrganInfo> getOrganInfoBySystem(String systemId, String sex) {
		TOrganInfoExample organInfoExample = new TOrganInfoExample();
		TOrganInfoExample.Criteria criteria = organInfoExample.createCriteria();
		if (!StringUtils.isEmpty(sex))
			criteria.andTypeDefaultEqualTo(sex);
		criteria.andBelongIdEqualTo(systemId);
		List<TOrganInfo> result = organInfoMapper.selectByExample(organInfoExample);
		return result;
	}

	@Override
	public List<TOrganInfo> getOrganInfoByOragan(String organCode, String sex) {
		TOrganInfoExample organInfoExample = new TOrganInfoExample();
		TOrganInfoExample.Criteria criteria = organInfoExample.createCriteria();
		if (!StringUtils.isEmpty(sex))
			criteria.andTypeDefaultEqualTo(sex);
		criteria.andParentCodeEqualTo(organCode);
		List<TOrganInfo> result = organInfoMapper.selectByExample(organInfoExample);
		return result;
	}

	@Override
	public List<TDiseaseInfo> getDiseaseInfoByOrgan(String organCode, String sex) {
		TDiseaseInfoExample diseaseInfoExample = new TDiseaseInfoExample();
		TDiseaseInfoExample.Criteria criteria = diseaseInfoExample.createCriteria();
		if (!StringUtils.isEmpty(sex))
			criteria.andSexSignEqualTo(sex);
		criteria.andOrganCodeEqualTo(organCode);
		criteria.andEnabledEqualTo("1");

		TDiseaseInfoExample.Criteria criteria1 = diseaseInfoExample.createCriteria();
		if (!StringUtils.isEmpty(sex))
			criteria1.andSexSignEqualTo("0");// 通用
		criteria1.andOrganCodeEqualTo(organCode);
		criteria1.andEnabledEqualTo("1");
		diseaseInfoExample.or(criteria1);
		List<TDiseaseInfo> result = diseaseInfoMapper.selectByExample(diseaseInfoExample);
		return result;
	}

	@Override
	public List<ResourceInfo> getRscInfoByOrgan(String organCode, String displayRate) {
		List<ResourceInfo> result = null;
		TResourceInfoExample resourceInfoExample = new TResourceInfoExample();
		TResourceInfoExample.Criteria criteria = resourceInfoExample.createCriteria();
		criteria.andOrganCodeEqualTo(organCode);
		criteria.andBussinessTypeEqualTo("1");
		List<TResourceInfo> tResourceInfos = resourceInfoMapper.selectByExample(resourceInfoExample);
		if (!ObjectUtils.isEmpty(tResourceInfos)) {
			result = convertToResourceInfo(tResourceInfos, displayRate);
		}
		return result;
	}

	@Override
	public List<ResourceInfo> getRscInfoByDisease(String diseaseCode, String displayRate, String resName) {
		List<ResourceInfo> result = null;
		TResourceInfoExample resourceInfoExample = new TResourceInfoExample();
		TResourceInfoExample.Criteria criteria = resourceInfoExample.createCriteria();
		criteria.andDiseaseCodeEqualTo(diseaseCode);
		criteria.andBussinessTypeEqualTo("2");
		if (!StringUtils.isEmpty(resName)) {
			TDiseaseInfoExample tDiseaseInfoExample = new TDiseaseInfoExample();
			TDiseaseInfoExample.Criteria criteria1 = tDiseaseInfoExample.createCriteria();
			criteria1.andDiseaseCodeEqualTo(diseaseCode);
			List<TDiseaseInfo> tDiseaseInfos = diseaseInfoMapper.selectByExample(tDiseaseInfoExample);
			if (!ObjectUtils.isEmpty(tDiseaseInfos))
				criteria.andResoNameLike(tDiseaseInfos.get(0).getIcd10() + "-" + resName + "%");
		}
		List<TResourceInfo> tResourceInfos = resourceInfoMapper.selectByExample(resourceInfoExample);
		if (!ObjectUtils.isEmpty(tResourceInfos)) {
			result = convertToResourceInfo(tResourceInfos, displayRate);
		}
		return result;
	}

	public List<ResourceInfo> convertToResourceInfo(List<TResourceInfo> tResourceInfos, String displayRate) {
		List<ResourceInfo> result = new ArrayList<ResourceInfo>();
		tResourceInfos.forEach(tResourceInfo -> {
			TModelDisplayParam tModelDisplayParam = getModeDisplayParam(tResourceInfo.getId(), displayRate);
			ResourceInfo resourceInfo = new ResourceInfo();
			BeanUtils.copyProperties(tResourceInfo, resourceInfo);
			if (!ObjectUtils.isEmpty(tModelDisplayParam)) {
				resourceInfo.setDisplayParam(tModelDisplayParam);
			}
			result.add(resourceInfo);
		});
		return result;
	}

	@Override
	public List<ResourceInfo> getRscInfoByRsc(String resourceId, String displayRate) {
		List<ResourceInfo> result = null;
		TResourceInfoExample resourceInfoExample = new TResourceInfoExample();
		TResourceInfoExample.Criteria criteria = resourceInfoExample.createCriteria();
		criteria.andRelIdEqualTo(resourceId);
		criteria.andBussinessTypeEqualTo("2");
		List<TResourceInfo> tResourceInfos = resourceInfoMapper.selectByExample(resourceInfoExample);
		if (!ObjectUtils.isEmpty(tResourceInfos)) {
			result = convertToResourceInfo(tResourceInfos, displayRate);
		}
		return result;
	}

	@Override
	public TModelDisplayParam getModeDisplayParam(String resourceId, String displayRate) {
		TModelDisplayParamExample modelDisplayParamExample = new TModelDisplayParamExample();
		TModelDisplayParamExample.Criteria criteria = modelDisplayParamExample.createCriteria();
		criteria.andResIdEqualTo(resourceId);
		criteria.andDispayRateEqualTo(displayRate);
		List<TModelDisplayParam> modelDisplayParams = modelDisplayParamMapper.selectByExample(modelDisplayParamExample);
		if (!ObjectUtils.isEmpty(modelDisplayParams))
			return modelDisplayParams.get(0);
		return null;
	}

	@Override
	public PageInfo<TDiseaseInfo> getDiseaseInfoByCondition(TDiseaseInfo diseaseInfo, int pageSize, int pageNum) {
		PageHelper.startPage(pageNum, pageSize);
		TDiseaseInfoExample tDiseaseInfoExample = new TDiseaseInfoExample();
		TDiseaseInfoExample.Criteria criteria = tDiseaseInfoExample.createCriteria();
		if (!ObjectUtils.isEmpty(diseaseInfo)) {
			if (!StringUtils.isEmpty(diseaseInfo.getDiseaseName()))
				criteria.andDiseaseNameLike("%" + diseaseInfo.getDiseaseName() + "%");
			if (!StringUtils.isEmpty(diseaseInfo.getEnabled()))
				criteria.andEnabledEqualTo(diseaseInfo.getEnabled());
		}
		List<TDiseaseInfo> tDiseaseInfos = diseaseInfoMapper.selectByExample(tDiseaseInfoExample);
		return new PageInfo<>(tDiseaseInfos);
	}

	@Override
	public TDiseaseInfo saveOrUpdateDiseaseInfo(TDiseaseInfo tDiseaseInfo) {
		if (StringUtils.isEmpty(tDiseaseInfo.getId())) {
			tDiseaseInfo.setId(UUIDUtils.getUUID());
			String diseaseCode = diseaseInfoMapper.getMaxDiseaseCode();// 这边前期疾病是手动导入的，并且新增的情况可能不是很多，故直接查询了
			if (StringUtils.isEmpty(diseaseCode))
				tDiseaseInfo.setDiseaseCode("1001");
			else
				tDiseaseInfo.setDiseaseCode(String.valueOf(Integer.parseInt(diseaseCode) + 1));
			diseaseInfoMapper.insert(tDiseaseInfo);
		} else {
			diseaseInfoMapper.updateByPrimaryKey(tDiseaseInfo);
		}
		return tDiseaseInfo;
	}

	@Override
	public int changDiseaseStateById(TDiseaseInfo tDiseaseInfo) {
		tDiseaseInfo.setEnabled("0".equals(tDiseaseInfo.getEnabled()) ? "1" : "0");
		return diseaseInfoMapper.updateByPrimaryKey(tDiseaseInfo);
	}

	@Override
	public List<TTnmInfo> getTnmInfoByDisease(String diseaseCode, String type) {
		TTnmInfoExample tTnmInfoExample = new TTnmInfoExample();
		TTnmInfoExample.Criteria criteria = tTnmInfoExample.createCriteria();
		criteria.andDiseaseCodeEqualTo(diseaseCode);
		if (StringUtil.isNotEmpty(type))
			criteria.andTypeEqualTo(type);
		return tnmInfoMapper.selectByExample(tTnmInfoExample);
	}

	@Override
	public List<TDiseaseInfo> getDiseaseInfoByConditions(TDiseaseInfo diseaseInfo) {
		TDiseaseInfoExample tDiseaseInfoExample = new TDiseaseInfoExample();
		TDiseaseInfoExample.Criteria criteria = tDiseaseInfoExample.createCriteria();
		if (!ObjectUtils.isEmpty(diseaseInfo)) {
			if (StringUtil.isNotEmpty(diseaseInfo.getDiseaseCode()))
				criteria.andDiseaseCodeEqualTo(diseaseInfo.getDiseaseCode());
			if (StringUtil.isNotEmpty(diseaseInfo.getSexSign()))
				criteria.andSexSignEqualTo(diseaseInfo.getSexSign());
			if (StringUtil.isNotEmpty(diseaseInfo.getDiseaseCode()))
				criteria.andDiseaseCodeEqualTo(diseaseInfo.getDiseaseCode());
			if (StringUtil.isNotEmpty(diseaseInfo.getIcd10()))
				criteria.andIcd10EqualTo(diseaseInfo.getIcd10());
		}
		return diseaseInfoMapper.selectByExample(tDiseaseInfoExample);
	}

	@Override
	public int delDiseaseRelRes(TDiseaseRelRes tDiseaseRelRes) {
		if (ObjectUtils.isEmpty(tDiseaseRelRes) || StringUtil.isEmpty(tDiseaseRelRes.getDiseaseId())) {
			return 0;
		}
		TDiseaseRelResExample example = new TDiseaseRelResExample();
		TDiseaseRelResExample.Criteria criteria = example.createCriteria();
		criteria.andDiseaseIdEqualTo(tDiseaseRelRes.getDiseaseId());
		return tDiseaseRelResMapper.deleteByExample(example);
	}

	@Override
	public List<TDiseaseRelRes> insertDiseaseRelResList(List<TDiseaseRelRes> tDiseaseRelResList) {
		if (ObjectUtils.isEmpty(tDiseaseRelResList))
			throw new BusinessException("疾病关联模型信息不能为空");
		for (TDiseaseRelRes tDiseaseRelRes : tDiseaseRelResList) {
			tDiseaseRelRes.setId(UUIDUtils.getUUID());
			tDiseaseRelResMapper.insert(tDiseaseRelRes);
		}
		return tDiseaseRelResList;
	}
	
	@Override
	public List<TDiseaseRelRes> getDiseaseRelResList(TDiseaseRelRes tDiseaseRelRes) {
		if (ObjectUtils.isEmpty(tDiseaseRelRes)) {
			return null;
		}
		TDiseaseRelResExample example = new TDiseaseRelResExample();
		TDiseaseRelResExample.Criteria criteria = example.createCriteria();
		criteria.andDiseaseIdEqualTo(tDiseaseRelRes.getDiseaseId());
		if(StringUtil.isNotEmpty(tDiseaseRelRes.getPlatform())) {
			criteria.andPlatformEqualTo(tDiseaseRelRes.getPlatform());
		}
		return tDiseaseRelResMapper.selectResByExample(example);
	}
	
	@Override
	public List<TDiseaseRelCase> getDiseaseRelCaseList(TDiseaseRelCase tDiseaseRelCase) {
		if (ObjectUtils.isEmpty(tDiseaseRelCase)) {
			return null;
		}
		TDiseaseRelCaseExample example = new TDiseaseRelCaseExample();
		TDiseaseRelCaseExample.Criteria criteria = example.createCriteria();
		criteria.andDiseaseIdEqualTo(tDiseaseRelCase.getDiseaseId());
		return tDiseaseRelCaseMapper.selectByExample(example);
	}
	
	@Override
	public void saveDiseaseRelCase(List<TDiseaseRelCase> tDiseaseRelCaseList) {
		if (!ObjectUtils.isEmpty(tDiseaseRelCaseList)) {
			for(TDiseaseRelCase tDiseaseRelCase : tDiseaseRelCaseList) {
				tDiseaseRelCase.setId(UUIDUtils.getUUID());
				tDiseaseRelCaseMapper.insert(tDiseaseRelCase);
			}
		}
		
	}
	
	@Override
	public int delDiseaseRelCase(TDiseaseRelCase tDiseaseRelCase) {
		if (ObjectUtils.isEmpty(tDiseaseRelCase) || StringUtil.isEmpty(tDiseaseRelCase.getDiseaseId())) {
			return 0;
		}
		TDiseaseRelCaseExample example = new TDiseaseRelCaseExample();
		TDiseaseRelCaseExample.Criteria criteria = example.createCriteria();
		criteria.andDiseaseIdEqualTo(tDiseaseRelCase.getDiseaseId());
		return tDiseaseRelCaseMapper.deleteByExample(example);
	}

}
