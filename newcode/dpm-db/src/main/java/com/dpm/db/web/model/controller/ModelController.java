package com.dpm.db.web.model.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dpm.db.web.model.service.impl.ResourceServiceImpl;
import com.dpm.resource.common.enity.TDiseaseInfo;
import com.dpm.resource.common.enity.TModelDisplayParam;
import com.dpm.resource.common.enity.TOrganInfo;
import com.dpm.resource.common.enity.TResourceInfo;
import com.dpm.resource.common.enity.resource.ResourceParam;
import com.github.pagehelper.PageInfo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @ Purpose:
 * 
 * @Package Name: com.dpm.db.web.model.controller
 * @Author: liuxiaoxin
 * @Date: 2018/5/21
 */
@RestController
@RequestMapping("/resource")
@Api(description = "资源模型业务处理")
public class ModelController {
	@Autowired
	ResourceServiceImpl resourceService;

	@ApiOperation(value = "获取模型资源信息", notes = "过滤条件包括资源名称、关联疾病等")
	@RequestMapping(value = "/getModelResourceByCondition", method = RequestMethod.POST)
	PageInfo<TResourceInfo> getModelResourceByCondition(@RequestBody ResourceParam param) {
		return resourceService.getModelResourceByCondition(param.getResourceInfo(), param.getPageSize(),
				param.getPageNum());
	}

	@ApiOperation(value = "获取疾病字典数据", notes = "按疾病名称或者拼音码获取疾病列表信息")
	@RequestMapping(value = "/getDiseaseList", method = RequestMethod.GET)
	List<TDiseaseInfo> getDiseaseList(@RequestParam(value = "key") String key) {
		return resourceService.getDiseaseList(key);
	}
	
	@ApiOperation(value = "获取疾病字典数据", notes = "按疾病名称或者拼音码获取疾病列表信息")
	@RequestMapping(value = "/getDiseaseList", method = RequestMethod.POST)
	List<TDiseaseInfo> getDiseaseList(@RequestBody TDiseaseInfo tDiseaseInfo) {
		return resourceService.getDiseaseList(tDiseaseInfo);
	}

	@ApiOperation(value = "获取器官字典数据", notes = "按器官名称获取疾病列表信息")
	@RequestMapping(value = "/getOrganList", method = RequestMethod.GET)
	List<TOrganInfo> getOrganList(@RequestParam(value = "key", required = false) String key) {
		return resourceService.getOrganList(key);
	}

	@ApiOperation(value = "获取病理模型对应生理模型", notes = "按器官名称获取对应生理模型")
	@RequestMapping(value = "/getRelOrganList", method = RequestMethod.GET)
	List<TResourceInfo> getRefOrganList(@RequestParam(value = "organCode") String organCode) {
		return resourceService.getRelOrganList(organCode);
	}

	@ApiOperation(value = "获取骨治疗类型", notes = "")
	@RequestMapping(value = "/getBoneTypeList", method = RequestMethod.GET)
	List<Map<String, String>> getBoneTypeList(@RequestParam(value = "organCode") String organCode) {
		return resourceService.getBoneTypeList(organCode);
	}

	@ApiOperation(value = "保存更新资源信息", notes = "")
	@RequestMapping(value = "/saveOrUpdateResourceInfo")
	TResourceInfo saveOrUpdateResourceInfo(@RequestBody TResourceInfo tResourceInfo) {
		return resourceService.saveOrUpdateResourceInfo(tResourceInfo);
	}

	@ApiOperation(value = "删除选择资源信息", notes = "")
	@RequestMapping(value = "/delResourceList")
	int delResourceList(@RequestBody List<String> resourceIds) {
		return resourceService.delResourceList(resourceIds);
	}

	@ApiOperation(value = "获取模型參數信息", notes = "resId：資源id，dispayRate：屏幕比例")
	@RequestMapping(value = "/getModelDisplayParaList", method = RequestMethod.GET)
	List<TModelDisplayParam> getModelDisplayParaList(String resId, String dispayRate) {
		return resourceService.getModelDisplayParaList(resId, dispayRate);
	}

	@ApiOperation(value = "获取資源信息", notes = "")
	@RequestMapping(value = "/getResourceInfoList", method = RequestMethod.POST)
	public List<TResourceInfo> getResourceInfoList(@RequestBody TResourceInfo tResourceInfo) {
		return resourceService.getResourceInfoList(tResourceInfo);
	}
	
	@ApiOperation(value = "删除位置参数信息", notes = "")
	@RequestMapping(value = "/delTModelDisplayParam", method = RequestMethod.POST)
	public int delTModelDisplayParam(@RequestBody TModelDisplayParam tModelDisplayParam) {
		return resourceService.delTModelDisplayParam(tModelDisplayParam);
	}
	
	@ApiOperation(value = "获取位置参数信息", notes = "")
	@RequestMapping(value = "/insertDisplayParam", method = RequestMethod.POST)
	public List<TModelDisplayParam> insertDisplayParam(@RequestBody List<TModelDisplayParam> tModelDisplayParamList) {
		return resourceService.insertDisplayParam(tModelDisplayParamList);
	}


}
