package com.dpm.web.model.service;

import com.dpm.resource.common.enity.TDiseaseInfo;
import com.dpm.resource.common.enity.TOrganInfo;
import com.dpm.resource.common.enity.TResourceInfo;
import com.dpm.resource.common.enity.resource.ResourceParam;
import com.dpm.web.model.pojo.ResourceRelation;
import com.github.pagehelper.PageInfo;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @ Purpose:
 * @Package Name: com.dpm.web.model.service
 * @Author: liuxiaoxin
 * @Date: 2018/5/21
 */
public interface IModelService {
    List<TResourceInfo> uploadModelFile(MultipartFile[] file, String type);

    PageInfo<TResourceInfo> getModelResourceByCondition(ResourceParam resourceParam);

    List<TDiseaseInfo> getDiseaseList(String key);

    List<TOrganInfo> getOrganList(String key);

    ResourceRelation getResourceRelation(TResourceInfo tResourceInfo);

    ResourceParam saveOrUpdateResourceInfo(ResourceParam resourceParam);

    int delResourceList(List<TResourceInfo> tResourceInfo);

    void downResourceFile(String filePath, HttpServletResponse outputStream);
    
    List<TDiseaseInfo> getTnmDiseaseList();

	List<TResourceInfo> getResList(String key);
}
