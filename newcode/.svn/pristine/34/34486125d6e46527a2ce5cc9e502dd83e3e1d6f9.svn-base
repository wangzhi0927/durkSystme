package com.dpm.db.web.organ.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dpm.db.web.organ.service.impl.OrganServiceImpl;
import com.dpm.resource.common.enity.TOrganInfo;
import com.dpm.resource.common.enity.organ.OrganParam;
import com.github.pagehelper.PageInfo;

import io.swagger.annotations.ApiOperation;

/**
 * @ Purpose:
 * 
 * @Package Name: com.dpm.db.web.user.controller
 * @Author: liuxiaoxin
 * @Date: 2018/5/14
 */
@RestController
@RequestMapping("/organ")
public class OrganController {
	@Autowired
	OrganServiceImpl organService;

	@ApiOperation(value = "获取系统下的所有器官列表", notes = "根据系统编号获取")
	@RequestMapping(value = "/getOrganListBySystemId", method = RequestMethod.GET)
	List<TOrganInfo> getOrganListBySystemId(@RequestParam(value = "systemId") String systemId,
			@RequestParam(value = "sex") String sex) {
		return organService.getOrganListBySystemId(systemId, sex);
	}

	@ApiOperation(value = "依据条件获取器官列表信息", notes = "查询器官列表信息")
	@RequestMapping(value = "/getOrganInfoByCondition", method = RequestMethod.POST)
	public PageInfo<TOrganInfo> getOrganInfoByCondition(@RequestBody OrganParam organParam) {
		return organService.getOrganInfoByCondition(organParam);
	}

	@ApiOperation(value = "保存器官信息", notes = "用于保存或者更新疾病信息")
    @RequestMapping(value = "/saveOrUpdateOrganInfo", method = RequestMethod.POST)
    public TOrganInfo saveOrUpdateOrganInfo(@RequestBody TOrganInfo tOrganInfo) {
        return organService.saveOrUpdateOrganInfo(tOrganInfo);
    }
	
	@ApiOperation(value = "保存器官信息", notes = "用于保存或者更新器官信息")
    @RequestMapping(value = "/delOrganInfo", method = RequestMethod.POST)
    public int delOrganInfo(@RequestBody TOrganInfo tOrganInfo) {
        return organService.delOrganInfo(tOrganInfo);
    }
	
	@ApiOperation(value = "获取器官信息", notes = "查询器官信息")
	@RequestMapping(value = "/getOrganInfo", method = RequestMethod.POST)
	public List<TOrganInfo> getOrganInfo(@RequestBody TOrganInfo tOrganInfo) {
		return organService.getOrganInfo(tOrganInfo);
	}
}
