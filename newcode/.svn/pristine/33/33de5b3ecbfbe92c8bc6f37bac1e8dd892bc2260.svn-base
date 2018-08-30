package com.dpm.unity.web.organ.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import com.dpm.resource.common.enity.TModelDisplayParam;
import com.dpm.resource.common.enity.TOrganInfo;
import com.dpm.resource.common.enity.organ.OrganResDTO;
import com.dpm.resource.freamwork.BusinessException;
import com.dpm.unity.web.feigns.IModelFeignClient;
import com.dpm.unity.web.feigns.IOrganFeignClient;
import com.dpm.unity.web.organ.service.IOrganService;
import com.github.pagehelper.util.StringUtil;

/**
 * @Auther: mapengfei
 * @Date: 2018/5/18
 * @Description:
 */
@Service
public class OrganServiceImpl implements IOrganService {
	@Autowired
	private IOrganFeignClient iOrganFeignClient;

	@Autowired
	private IModelFeignClient iModelFeignClient;

	@Override
	public List<TOrganInfo> getOrganListBySystemId(String systemId, String sex) {
		if (StringUtils.isEmpty(systemId))
			throw new BusinessException("systemId不可为空!");
		List<TOrganInfo> organList = iOrganFeignClient.getOrganListBySystemId(systemId, sex);
		return organList;
	}

	@Override
	public OrganResDTO getModelDisplayParaInfo(String organCode, String dispayRate) {
		if (StringUtils.isEmpty(organCode))
			throw new BusinessException("organCode不可为空");
		OrganResDTO dto = new OrganResDTO();
		TOrganInfo tOrganInfo = new TOrganInfo();
		tOrganInfo.setOrganCode(organCode);
		List<TOrganInfo> tOrganInfoList = iOrganFeignClient.getOrganInfo(tOrganInfo);
		if (!ObjectUtils.isEmpty(tOrganInfoList)) {
			dto.setTOrganInfo(tOrganInfoList.get(0));
		}
		if (!ObjectUtils.isEmpty(tOrganInfoList.get(0))) {
			if (StringUtil.isNotEmpty(tOrganInfoList.get(0).getResId())) {
				List<TModelDisplayParam> tModelDisplayParamList = iModelFeignClient
						.getModelDisplayParaList(tOrganInfoList.get(0).getResId(), dispayRate);
				if (!ObjectUtils.isEmpty(tModelDisplayParamList)) {
					dto.setTModelDisplayParam(tModelDisplayParamList.get(0));
				}
			}
		}
		return dto;
	}
}
