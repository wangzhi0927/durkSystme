package com.dpm.unity.web.model.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.dpm.resource.common.enity.TModelDisplayParam;
import com.dpm.resource.freamwork.BusinessException;
import com.dpm.unity.web.feigns.IModelFeignClient;
import com.dpm.unity.web.model.service.IModelService;

/**
 * @Auther: mapengfei
 * @Date: 2018/5/18
 * @Description:
 */
@Service
public class ModelServiceImpl implements IModelService {
	@Autowired
	private IModelFeignClient iModelFeignClient;

	@Override
	public TModelDisplayParam getModelDisplayParaInfo(String resId, String dispayRate) {
		if (StringUtils.isEmpty(resId))
			throw new BusinessException("resId不可为空：");
		List<TModelDisplayParam> tModelDisplayParamList = iModelFeignClient.getModelDisplayParaList(resId, dispayRate);
		if (tModelDisplayParamList != null && tModelDisplayParamList.size()>0) {
			return tModelDisplayParamList.get(0);
		} else {
			return null;
		}
	}

}
