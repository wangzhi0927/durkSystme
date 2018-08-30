package com.dpm.web.model.service.impl;

import com.dpm.resource.common.enity.FileResult;
import com.dpm.resource.common.enity.TDiseaseInfo;
import com.dpm.resource.common.enity.TModelDisplayParam;
import com.dpm.resource.common.enity.TOrganInfo;
import com.dpm.resource.common.enity.TResourceInfo;
import com.dpm.resource.common.enity.resource.ResourceParam;
import com.dpm.resource.common.utils.FtpUtils;
import com.dpm.resource.freamwork.BusinessException;
import com.dpm.web.common.utils.ContextUtils;
import com.dpm.web.feigns.IOrganFeignClient;
import com.dpm.web.feigns.IResourceFeignClient;
import com.dpm.web.model.pojo.ResourceRelation;
import com.dpm.web.model.service.IModelService;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.util.StringUtil;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @ Purpose:
 * @Package Name: com.dpm.web.model.service.impl
 * @Author: liuxiaoxin
 * @Date: 2018/5/21
 */
@Service
public class ModelServiceImpl implements IModelService {
    @Autowired
    ContextUtils contextUtils;

    private static final String IMG_RESOURCE_PATH = "/image";
    private static final String TD_RESOURCE_PATH = "/3d";
    private static final String FLASH_RESOURCE_PATH = "/flash";
    private static final String COMMON_RESOURCE_PATH = "/common";

    @Autowired
    FtpUtils ftpUtils;
    @Autowired
    IResourceFeignClient resourceFeignClient;
    @Autowired
    IOrganFeignClient iOrganFeignClient;

    @Override
    public List<TResourceInfo> uploadModelFile(MultipartFile[] file, String type) {
        List<TResourceInfo> tResourceInfo = new ArrayList<>();
        if (ObjectUtils.isEmpty(file)) {
            throw new BusinessException("文件列表为空，请重新选择文件！");
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        List<FileResult> fileResult = ftpUtils.uploadFile(file, getResourcePath(type) + "/" + sdf.format(new Date()) + "/");
        if (!CollectionUtils.isEmpty(fileResult)) {
            fileResult.stream().forEach(ii -> {
                TResourceInfo tResource = new TResourceInfo();
                tResource.setFileName(ii.getName());
                tResource.setPath(ii.getPath());
                tResource.setSize(new Long(String.valueOf(ii.getSize())).intValue());
                tResourceInfo.add(tResource);
            });
        }
        return tResourceInfo;
    }

    @Override
    public PageInfo<TResourceInfo> getModelResourceByCondition(ResourceParam resourceParam) {
        return resourceFeignClient.getModelResourceByCondition(resourceParam);
    }

    @Override
    public List<TDiseaseInfo> getDiseaseList(String key) {
        return resourceFeignClient.getDiseaseList(key);
    }
    
    @Override
    public List<TDiseaseInfo> getTnmDiseaseList() {
    	TDiseaseInfo tDiseaseInfo = new TDiseaseInfo();
    	tDiseaseInfo.setCancerFlag("1");// 癌症标志1:是 0:否
        return resourceFeignClient.getDiseaseList(tDiseaseInfo);
    }

    @Override
    public List<TOrganInfo> getOrganList(String key) {
        return resourceFeignClient.getOrganList(key);
    }

    @Override
    public ResourceRelation getResourceRelation(TResourceInfo tResourceInfo) {
        ResourceRelation resourceRelation = new ResourceRelation();

        resourceRelation.setDiseaseInfoList(resourceFeignClient.getDiseaseList(tResourceInfo.getDiseaseCode()));
        resourceRelation.setOrganInfoList(resourceFeignClient.getOrganList(tResourceInfo.getOrganCode()));
        resourceRelation.setResourceInfoList(resourceFeignClient.getRefOrganList(tResourceInfo.getOrganCode()));
        resourceRelation.setBoneTypeList(resourceFeignClient.getBoneTypeList(tResourceInfo.getOrganCode()));
        if(StringUtils.isNotEmpty(tResourceInfo.getId())) {
        	resourceRelation.setModelDisplayParamList(resourceFeignClient.getModelDisplayParaList(tResourceInfo.getId(), null));
        }
        return resourceRelation;
    }

    @Override
    @Transactional
    public ResourceParam saveOrUpdateResourceInfo(ResourceParam resourceParam) {
    	TResourceInfo tResourceInfo = resourceParam.getResourceInfo();
    	if(ObjectUtils.isEmpty(tResourceInfo)){
    		throw new BusinessException("资源信息不能为空！");
    	}
    	tResourceInfo = resourceFeignClient.saveOrUpdateResourceInfo(tResourceInfo);
    	List<TModelDisplayParam> tModelDisplayParamList = resourceParam.getModelDisplayParamList();
    	if(!ObjectUtils.isEmpty(tModelDisplayParamList)){
    		if(StringUtils.isNotEmpty(tResourceInfo.getId())){
	    		TModelDisplayParam tModelDisplayParam = new TModelDisplayParam();
	    		tModelDisplayParam.setResId(tResourceInfo.getId());
	    		resourceFeignClient.delTModelDisplayParam(tModelDisplayParam);
    		}
    		for(TModelDisplayParam tModelDisplayParam : tModelDisplayParamList) {
    			tModelDisplayParam.setResId(tResourceInfo.getId());
    		}
    		tModelDisplayParamList = resourceFeignClient.insertDisplayParam(tModelDisplayParamList);
    	}
    	return resourceParam;
    }

    @Override
    public int delResourceList(List<TResourceInfo> tResourceInfo) {
        List<String> resourceIds = new ArrayList<>();
        if (!CollectionUtils.isEmpty(tResourceInfo)) {
            resourceIds = tResourceInfo.stream().map(TResourceInfo::getId).collect(Collectors.toList());
        }
        return resourceFeignClient.delResourceList(resourceIds);
    }

    @Override
    public void downResourceFile(String filePath, HttpServletResponse outputStream) {
         ftpUtils.downloadFile(filePath,outputStream);
    }

    private String getResourcePath(String type) {
        switch (type) {
            case "0":
                return TD_RESOURCE_PATH;
            case "1":
                return IMG_RESOURCE_PATH;
            case "2":
                return FLASH_RESOURCE_PATH;
            default:
                return COMMON_RESOURCE_PATH;
        }
    }
    
    @Override
    public List<TResourceInfo> getResList(String key) {
    	List<TResourceInfo> resourceInfoList = null;
    	if(StringUtil.isNotEmpty(key)) {
	    	TResourceInfo tResourceInfo = new TResourceInfo();
	    	tResourceInfo.setBussinessType("2");//病理
	    	tResourceInfo.setResoName(key);
	    	resourceInfoList = iOrganFeignClient.getResourceInfoList(tResourceInfo);
    	}
    	return resourceInfoList;
    }
}
