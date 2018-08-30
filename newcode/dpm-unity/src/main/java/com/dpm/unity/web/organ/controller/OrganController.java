package com.dpm.unity.web.organ.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dpm.resource.freamwork.BusinessResult;
import com.dpm.unity.web.organ.service.impl.OrganServiceImpl;

import io.swagger.annotations.ApiOperation;

/**
 * @Auther: gaolei
 * @Date: 2018/6/28
 * @Description:
 */
@RestController
@RequestMapping(value = "/organ")
public class OrganController {
	@Autowired
	private OrganServiceImpl organService;

	@ApiOperation(value = "获取系统下的所有器官列表", notes = "systemId:系统id（必填）；sex：性别（必填 1：男，2：女）")
	@RequestMapping(value = "getOrganListBySystemId", method = RequestMethod.GET)
	public BusinessResult getOrganListBySystemId(String systemId, String sex) throws Exception {
		return BusinessResult.success(organService.getOrganListBySystemId(systemId, sex));
	}

	@ApiOperation(value = "获取组织模型参数信息", notes = "organCode：组织编号,dispayRate：屏幕比例")
	@RequestMapping(value = "getModelDisplayParaInfo", method = RequestMethod.GET)
	public BusinessResult getModelDisplayParaInfo(String organCode, String dispayRate) throws Exception {
		return BusinessResult.success(organService.getModelDisplayParaInfo(organCode, dispayRate));
	}

}
