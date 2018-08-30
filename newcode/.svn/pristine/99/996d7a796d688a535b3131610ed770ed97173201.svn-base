package com.dpm.unity.web.sys.controller;

import com.dpm.resource.freamwork.BusinessResult;
import com.dpm.unity.web.sys.pojo.request.FileUploadRequestData;
import com.dpm.unity.web.sys.service.impl.RecordServiceImpl;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: mapengfei
 * @Date: 2018/5/19
 * @Description:
 */
@RestController
@RequestMapping(value = "/sys/record")
public class RecordController {
    @Autowired
    private RecordServiceImpl recordService;

    @ApiOperation(value = "上传文件接口",notes = "用于上传病人谈话期间的证件信息和谈话结果")
    @RequestMapping(value = "fileUpload",method=RequestMethod.POST,consumes = "application/json", produces = "application/json; charset=UTF-8")
    public BusinessResult fileUpload(@RequestBody FileUploadRequestData fileUploadRequestData) throws Exception{
        return BusinessResult.success(recordService.uploadFile(fileUploadRequestData));
    }
}
