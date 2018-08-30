package com.dpm.web.user.controller;

import com.dpm.resource.common.enity.RecordCondition;
import com.dpm.resource.common.enity.TRecordInfo;
import com.dpm.resource.freamwork.BusinessResult;
import com.dpm.web.user.service.impl.RecordServiceImpl;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ Purpose:
 * @Package Name: com.dpm.web.user.controller
 * @Author: liuxiaoxin
 * @Date: 2018/6/5
 */
@RestController
@RequestMapping("/record")
public class RecordController {
    @Autowired
    RecordServiceImpl recordService;

    @ApiOperation(value = "下载记录附件信息", notes = "")
    @RequestMapping(value = "/downRecordFile", method = RequestMethod.GET)
    public void downResourceFile(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, @RequestParam String filePath) throws Exception {
        recordService.downRecordFile(filePath, httpServletResponse);
    }

    @ApiOperation(value = "依据条件获取记录列表信息", notes = "查询模型资源列表信息")
    @RequestMapping(value = "/getRecordInfoByCondition", method = RequestMethod.POST)
    public BusinessResult getRecordInfoByCondition(@RequestBody RecordCondition param) {
        PageInfo<TRecordInfo> resourceInfoPageInfo = recordService.getRecordInfoByCondition(param);
        return BusinessResult.success(resourceInfoPageInfo);
    }

    @ApiOperation(value = "校验下载文件是否存在信息", notes = "")
    @RequestMapping(value = "/validRecordFile", method = RequestMethod.GET)
    public BusinessResult validRecordFile(@RequestParam String filePath) throws Exception {
        return BusinessResult.success(recordService.validRecordFile(filePath));
    }

}
