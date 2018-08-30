package com.dpm.db.web.tnm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dpm.db.web.tnm.service.impl.TnmServiceImpl;
import com.dpm.resource.common.enity.TTnmInfo;
import com.dpm.resource.common.enity.tnm.TnmParam;
import com.github.pagehelper.PageInfo;

import io.swagger.annotations.ApiOperation;

/**
 * @ Purpose:
 * 
 * @Package Name: com.dpm.db.web.user.controller
 * @Date: 2018/5/14
 */
@RestController
@RequestMapping("/tnm")
public class TnmController {
	@Autowired
	TnmServiceImpl tnmServiceImpl;

	@ApiOperation(value = "依据条件获取tnm列表信息", notes = "查询tnm列表信息")
	@RequestMapping(value = "/getTnmInfoByCondition", method = RequestMethod.POST)
	public PageInfo<TTnmInfo> getTnmInfoByCondition(@RequestBody TnmParam tnmParam) {
		return tnmServiceImpl.getTnmInfoByCondition(tnmParam);
	}

	@ApiOperation(value = "保存tnm信息", notes = "用于保存或者更新tnm信息")
	@RequestMapping(value = "/saveOrUpdateTnmInfo", method = RequestMethod.POST)
	public TTnmInfo saveOrUpdateTnmInfo(@RequestBody TTnmInfo tTnmInfo) {
		return tnmServiceImpl.saveOrUpdateTnmInfo(tTnmInfo);
	}

	@ApiOperation(value = "删除tnm信息", notes = "用于删除tnm信息")
	@RequestMapping(value = "/delTnmInfo", method = RequestMethod.POST)
	public int delTnmInfo(@RequestBody TTnmInfo tTnmInfo) {
		return tnmServiceImpl.delTnmInfo(tTnmInfo);
	}
}
