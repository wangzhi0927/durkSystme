package com.dpm.unity.web.disease.service.impl;

import com.dpm.resource.common.enity.*;
import com.dpm.resource.freamwork.BusinessException;
import com.dpm.unity.common.validation.ValidationProperty;
import com.dpm.unity.web.disease.pojo.request.*;
import com.dpm.unity.web.disease.service.UnityIDiseaseService;
import com.dpm.unity.web.feigns.IDiseaseFeignClient;
import com.dpm.unity.web.feigns.IModelFeignClient;
import com.dpm.unity.web.feigns.IOrganFeignClient;
import com.github.pagehelper.util.StringUtil;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * @Auther: mapengfei
 * @Date: 2018/5/14
 * @Description:疾病模块业务实现
 */
@Service
public class UnityDiseaseServiceImpl implements UnityIDiseaseService {

	@Autowired
	IDiseaseFeignClient diseaseFeignClient;

	@Autowired
	private IOrganFeignClient iOrganFeignClient;

	@Autowired
	private IModelFeignClient iModelFeignClient;

	/**
	 * @Description: 获取系统下对应的器官
	 * @Param: [getOrganInfoBySystemRequestData]
	 * @return: java.util.List<com.dpm.resource.common.enity.TOrganInfo>
	 * @Author: mapengfei
	 * @Date: 2018/5/16
	 */
	@Override
	public List<TOrganInfo> getOrganInfoBySystem(GetOrganInfoBySystemRequestData getOrganInfoBySystemRequestData) {
		String checkResult = ValidationProperty.validate(getOrganInfoBySystemRequestData,
				ValidationProperty.GetOrganInfoBySystemCheckParams);
		if (!StringUtils.isEmpty(checkResult))
			throw new BusinessException("以下请求入参不可为空：" + checkResult);
		List<TOrganInfo> organInfos = diseaseFeignClient.getOrganInfoBySystem(
				getOrganInfoBySystemRequestData.getSystemId(), getOrganInfoBySystemRequestData.getSex());
		return organInfos;
	}

	/**
	 * @Description: 获取器官下对应的器官
	 * @Param: [getOrganInfoByOrganRequestData]
	 * @return: java.util.List<com.dpm.resource.common.enity.TOrganInfo>
	 * @Author: mapengfei
	 * @Date: 2018/5/16
	 */
	@Override
	public List<TOrganInfo> getOrganInfoByOrgan(GetOrganInfoByOrganRequestData getOrganInfoByOrganRequestData) {
		String checkResult = ValidationProperty.validate(getOrganInfoByOrganRequestData,
				ValidationProperty.GetOrganInfoByOrganCheckParams);
		if (!StringUtils.isEmpty(checkResult))
			throw new BusinessException("以下请求入参不可为空：" + checkResult);
		List<TOrganInfo> organInfos = diseaseFeignClient.getOrganInfoByOragan(
				getOrganInfoByOrganRequestData.getOrganCode(), getOrganInfoByOrganRequestData.getSex());
		return organInfos;
	}

	/**
	 * @Description: 获取器官下对应得疾病信息
	 * @Param: [getDiseaseInfoByOrganRequestData]
	 * @return: java.util.List<com.dpm.resource.common.enity.TDiseaseInfo>
	 * @Author: mapengfei
	 * @Date: 2018/5/16
	 */
	@Override
	public List<TDiseaseInfo> getDiseaseInfoByOrgan(GetDiseaseInfoByOrganRequestData getDiseaseInfoByOrganRequestData) {
		String checkResult = ValidationProperty.validate(getDiseaseInfoByOrganRequestData,
				ValidationProperty.GetDiseaseInfoByOrganCheckParams);
		if (!StringUtils.isEmpty(checkResult))
			throw new BusinessException("以下请求入参不可为空：" + checkResult);
		List<TDiseaseInfo> diseaseInfos = diseaseFeignClient.getDiseaseInfoByOrgan(
				getDiseaseInfoByOrganRequestData.getOrganCode(), getDiseaseInfoByOrganRequestData.getSex());
		return diseaseInfos;
	}

	/**
	 * @Description: 获取器官下对应的生理模型资源信息
	 * @Param: [getRscInfoByOrganRequestData]
	 * @return: java.util.List<com.dpm.resource.common.enity.ResourceInfo>
	 * @Author: mapengfei
	 * @Date: 2018/5/16
	 */
	@Override
	public List<ResourceInfo> getRscInfoByOrgan(GetRscInfoByOrganRequestData getRscInfoByOrganRequestData) {
		String checkResult = ValidationProperty.validate(getRscInfoByOrganRequestData,
				ValidationProperty.GetRscInfoByOrganCheckParams);
		if (!StringUtils.isEmpty(checkResult))
			throw new BusinessException("以下请求入参不可为空：" + checkResult);
		List<ResourceInfo> resourceInfos = diseaseFeignClient.getRscInfoByOrgan(
				getRscInfoByOrganRequestData.getOrganCode(), getRscInfoByOrganRequestData.getDisplayRate());
		return resourceInfos;
	}

	/**
	 * @Description: 获取某疾病下生理模型资源信息
	 * @Param: [getRscInfoByDiseaseRequestData]
	 * @return: java.util.List<com.dpm.resource.common.enity.ResourceInfo>
	 * @Author: mapengfei
	 * @Date: 2018/5/16
	 */
	@Override
	public List<ResourceInfo> getRscInfoByDisease(GetRscInfoByDiseaseRequestData getRscInfoByDiseaseRequestData) {
		String checkResult = ValidationProperty.validate(getRscInfoByDiseaseRequestData,
				ValidationProperty.GetRscInfoByDiseaseCheckParams);
		if (!StringUtils.isEmpty(checkResult))
			throw new BusinessException("以下请求入参不可为空：" + checkResult);
		List<ResourceInfo> resourceInfos = diseaseFeignClient.getRscInfoByDisease(
				getRscInfoByDiseaseRequestData.getDiseaseCode(), getRscInfoByDiseaseRequestData.getDisplayRate(),
				getRscInfoByDiseaseRequestData.getResName());
		return resourceInfos;
	}

	/**
	 * @Description: 获取资源对应的病理资源信息
	 * @Param: [getRscInfoByRscRequestData]
	 * @return: java.util.List<com.dpm.resource.common.enity.ResourceInfo>
	 * @Author: mapengfei
	 * @Date: 2018/5/16
	 */
	@Override
	public List<ResourceInfo> getRscInfoByRsc(GetRscInfoByRscRequestData getRscInfoByRscRequestData) {
		String checkResult = ValidationProperty.validate(getRscInfoByRscRequestData,
				ValidationProperty.GetRscInfoByRscCheckParams);
		if (!StringUtils.isEmpty(checkResult))
			throw new BusinessException("以下请求入参不可为空：" + checkResult);
		List<ResourceInfo> resourceInfos = diseaseFeignClient.getRscInfoByRsc(
				getRscInfoByRscRequestData.getResourceId(), getRscInfoByRscRequestData.getDisplayRate());
		return resourceInfos;
	}

	/**
	 * @Description: 获取资源显示参数信息
	 * @Param: [getModeDisplayParamRequestData]
	 * @return: com.dpm.resource.common.enity.TModelDisplayParam
	 * @Author: mapengfei
	 * @Date: 2018/5/16
	 */
	@Override
	public TModelDisplayParam getModeDisplayParam(GetModeDisplayParamRequestData getModeDisplayParamRequestData) {
		String checkResult = ValidationProperty.validate(getModeDisplayParamRequestData,
				ValidationProperty.GetModeDisplayParamCheckParams);
		if (!StringUtils.isEmpty(checkResult))
			throw new BusinessException("以下请求入参不可为空：" + checkResult);
		TModelDisplayParam modelDisplayParam = diseaseFeignClient.getModeDisplayParam(
				getModeDisplayParamRequestData.getResourceId(), getModeDisplayParamRequestData.getDisplayRate());
		return modelDisplayParam;
	}

	@Override
	public List<TTnmInfo> getTnmInfoByDisease(GetTnmInfoByDiseaseRequestData getTnmInfoByDiseaseRequestData) {
		String checkResult = ValidationProperty.validate(getTnmInfoByDiseaseRequestData,
				ValidationProperty.GetTnmInfoByDiseaseCheckParams);
		if (!StringUtils.isEmpty(checkResult))
			throw new BusinessException("以下请求入参不可为空：" + checkResult);
		return diseaseFeignClient.getTnmInfoByDisease(getTnmInfoByDiseaseRequestData.getDiseaseCode(),
				getTnmInfoByDiseaseRequestData.getType());
	}

	@Override
	public ResourceInfo getResourceInfo(String diseaseCode, String dispayRate, String platform) {
		if (StringUtils.isEmpty(diseaseCode) || StringUtils.isEmpty(dispayRate))
			throw new BusinessException("diseaseCode或dispayRate入参不可为空");
		TDiseaseInfo tDiseaseInfo = new TDiseaseInfo();
		tDiseaseInfo.setDiseaseCode(diseaseCode);
		// 获取疾病信息
		List<TDiseaseInfo> tDiseaseInfoList = diseaseFeignClient.getDiseaseInfoByConditions(tDiseaseInfo);
		ResourceInfo resourceInfo = new ResourceInfo();
		if (!ObjectUtils.isEmpty(tDiseaseInfoList)) {
			String diseaseId = tDiseaseInfoList.get(0).getId();
			TDiseaseRelRes tDiseaseRelRes = new TDiseaseRelRes();
			tDiseaseRelRes.setDiseaseId(diseaseId);
			tDiseaseRelRes.setPlatform(platform);
			// 获取疾病关联资源信息
			List<TDiseaseRelRes> tDiseaseRelResList = diseaseFeignClient.getDiseaseRelResList(tDiseaseRelRes);
			if (!ObjectUtils.isEmpty(tDiseaseRelResList)) {
				String resId = tDiseaseRelResList.get(0).getResId();
				if (StringUtil.isNotEmpty(resId)) {
					TResourceInfo tResourceInfo = new TResourceInfo();
					tResourceInfo.setId(resId);
					// 获取资源信息
					List<TResourceInfo> tResourceInfoList = iOrganFeignClient.getResourceInfoList(tResourceInfo);
					// 获取资源位置信息
					List<TModelDisplayParam> tModelDisplayParamList = iModelFeignClient.getModelDisplayParaList(resId,
							dispayRate);
					BeanUtils.copyProperties(tResourceInfoList.get(0), resourceInfo);
					resourceInfo.setModelDisplayParamList(tModelDisplayParamList);
				}
			}
		}
		return resourceInfo;
	}
}
