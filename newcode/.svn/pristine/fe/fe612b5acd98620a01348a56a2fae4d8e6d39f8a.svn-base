package com.dpm.web.model.controller;

import com.dpm.resource.common.enity.TResourceInfo;
import com.dpm.resource.common.enity.resource.ResourceParam;
import com.dpm.resource.freamwork.BusinessResult;
import com.dpm.web.model.service.impl.ModelServiceImpl;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @ Purpose:
 * @Package Name: com.dpm.web.model.controller
 * @Author: liuxiaoxin
 * @Date: 2018/5/21
 */
@RestController
@Api(description = "资源模型处理模块")
@RequestMapping("/model")
public class ModelController {

    @Autowired
    private ModelServiceImpl modelService;

    @ApiOperation(value = "获取疾病字典数据", notes = "按疾病名称或者拼音码获取疾病列表信息")
    @RequestMapping(value = "/getDiseaseList", method = RequestMethod.GET)
    BusinessResult getDiseaseList(@RequestParam(value = "key", required = false) String key) {
        return BusinessResult.success(modelService.getDiseaseList(key));
    }

    @ApiOperation(value = "获取器官字典数据", notes = "按器官名称或者拼音码获取疾病列表信息")
    @RequestMapping(value = "/getOrganList", method = RequestMethod.GET)
    BusinessResult getOrganList(@RequestParam(value = "key", required = false) String key) {
        return BusinessResult.success(modelService.getOrganList(key));
    }


    @ApiOperation(value = "依据条件获取模型列表信息", notes = "查询模型资源列表信息")
    @RequestMapping(value = "/getModelResourceByCondition", method = RequestMethod.POST)
    public BusinessResult getModelResourceByCondition(@RequestBody ResourceParam resourceParam) {
        PageInfo<TResourceInfo> resourceInfoPageInfo = modelService.getModelResourceByCondition(resourceParam);
        return BusinessResult.success(resourceInfoPageInfo);
    }


    @ApiOperation(value = "上传文件接口", notes = "用于上传病人谈话期间的证件信息和谈话结果")
    @RequestMapping(value = "/fileUpload", method = RequestMethod.POST)
    public BusinessResult uploadModelFile(@RequestParam(value = "upfile") MultipartFile[] file, @RequestParam(value = "type") String type) throws Exception {
        return BusinessResult.success(modelService.uploadModelFile(file, type));
    }

    @ApiOperation(value = "获取资源字典信息", notes = "用于获取资源字典信息")
    @RequestMapping(value = "/getResourceRelation", method = RequestMethod.POST)
    public BusinessResult getResourceRelation(@RequestBody TResourceInfo tResourceInfo) {
        return BusinessResult.success(modelService.getResourceRelation(tResourceInfo));
    }


    @ApiOperation(value = "保存更新资源信息", notes = "用于保存或者更新资源信息")
    @RequestMapping(value = "/saveOrUpdateResourceInfo", method = RequestMethod.POST)
    public BusinessResult saveOrUpdateResourceInfo(@RequestBody ResourceParam resourceParam) {
        return BusinessResult.success(modelService.saveOrUpdateResourceInfo(resourceParam));
    }

    @ApiOperation(value = "删除选择资源信息", notes = "删除选择资源信息")
    @RequestMapping(value = "/delResourceList", method = RequestMethod.POST)
    public BusinessResult delResourceList(@RequestBody List<TResourceInfo> tResourceInfo) {
        return BusinessResult.success(modelService.delResourceList(tResourceInfo));
    }

    @ApiOperation(value = "下载选择资源信息", notes = "删除选择资源信息")
    @RequestMapping(value = "/downResourceFile", method = RequestMethod.GET)
    public void downResourceFile(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, @RequestParam String filePath) throws Exception {
        modelService.downResourceFile(filePath, httpServletResponse);
    }
    
    @ApiOperation(value = "获取TNM疾病列表", notes = "获取TNM疾病列表列表信息")
    @RequestMapping(value = "/getTnmDiseaseList", method = RequestMethod.GET)
    BusinessResult getTnmDiseaseList() {
        return BusinessResult.success(modelService.getTnmDiseaseList());
    }

}
