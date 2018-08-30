package com.dpm.db.web.sys.controller;

import com.dpm.db.web.sys.service.impl.SysServiceImpl;
import com.dpm.resource.common.enity.TDictDetail;
import com.dpm.resource.common.enity.THospitalInfo;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

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
    @RequestMapping(value = "/getDictDetailInfo",method = RequestMethod.POST)
    public Map<String, List<TDictDetail>> getDictDetailInfo(@RequestParam(value = "dictType",required = false) String dictType){
        return sysService.getDictDetailInfo(dictType);
    }
    @ApiOperation(value = "获取医院信息接口",notes = "按分类返回所有的字典明细信息")
    @RequestMapping(value = "/getHospitalInfos",method = RequestMethod.POST)
    public List<THospitalInfo> getHospitalInfos(@RequestParam(value = "hosCode",required = false) String hosCode){
        return sysService.getHospitalInfos(hosCode);
    }
}
