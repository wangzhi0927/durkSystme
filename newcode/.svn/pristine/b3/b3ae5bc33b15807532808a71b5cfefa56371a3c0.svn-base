package com.dpm.web.tnm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.dpm.resource.common.enity.TTnmInfo;
import com.dpm.resource.common.enity.tnm.TnmParam;
import com.dpm.resource.freamwork.BusinessResult;
import com.dpm.web.tnm.service.impl.TnmServiceImpl;

import io.swagger.annotations.ApiOperation;

/**
 * @Auther: gl
 * @Date: 2018/7/24
 * @Description:
 */
@RestController
@RequestMapping(value = "/tnm")
public class TnmController {
	@Autowired
	private TnmServiceImpl tnmServiceImpl;

	@ApiOperation(value = "依据条件获取器官列表信息", notes = "查询器官列表信息")
	@RequestMapping(value = "/getTnmInfoByCondition", method = RequestMethod.POST)
	public BusinessResult getTnmInfoByCondition(@RequestBody TnmParam tnmParam) {
		return BusinessResult.success(tnmServiceImpl.getTnmInfoByCondition(tnmParam));
	}

	@ApiOperation(value = "保存器官信息", notes = "用于保存或者更新器官信息")
	@RequestMapping(value = "/saveOrUpdateTnmInfo", method = RequestMethod.POST)
	public BusinessResult saveOrUpdateTnmInfo(@RequestBody TTnmInfo tTnmInfo) {
		return BusinessResult.success(tnmServiceImpl.saveOrUpdateTnmInfo(tTnmInfo));
	}

	@ApiOperation(value = "删除器官信息", notes = "用于删除器官信息")
	@RequestMapping(value = "/delTnmInfo", method = RequestMethod.POST)
	public BusinessResult delTnmInfo(@RequestBody TTnmInfo tTnmInfo) {
		return BusinessResult.success(tnmServiceImpl.delTnmInfo(tTnmInfo));
	}
	
	@ApiOperation(value = "上传文件接口", notes = "用于上传病人谈话期间的证件信息和谈话结果")
    @RequestMapping(value = "/fileUpload", method = RequestMethod.POST)
    public BusinessResult fileUpload(@RequestParam(value = "upfile") MultipartFile[] file) throws Exception {
        return BusinessResult.success(tnmServiceImpl.fileUpload(file));
    }

}
