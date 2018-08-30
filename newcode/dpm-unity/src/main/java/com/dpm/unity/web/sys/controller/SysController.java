package com.dpm.unity.web.sys.controller;

import com.dpm.resource.freamwork.BusinessResult;
import com.dpm.unity.web.sys.service.impl.SysServiceImpl;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Auther: mapengfei
 * @Date: 2018/5/21
 * @Description:
 */
@RestController
@RequestMapping(value = "/sys")
public class SysController {
    @Autowired
    private SysServiceImpl sysService;

    @ApiOperation(value = "获取字典明细信息接口",notes = "按分类返回所有的字典明细信息")
    @RequestMapping(value = "/getDictDetailInfo",method = RequestMethod.POST,produces = "application/json; charset=UTF-8")
    public BusinessResult getDictDetailInfo(@RequestParam(value = "dictType",required = false)String dictType){
        return BusinessResult.success(sysService.getDictDetailInfo(dictType));
    }

    @ApiOperation(value = "获取医院信息接口",notes = "按分类返回所有的字典明细信息")
    @RequestMapping(value = "/getHospitalInfos",method = RequestMethod.POST,produces = "application/json; charset=UTF-8")
    public BusinessResult getHospitalInfos(@RequestParam(value = "hosCode",required = false)String hosCode) throws Exception{
        return BusinessResult.success(sysService.getHospitalInfos(hosCode));
    }
}
