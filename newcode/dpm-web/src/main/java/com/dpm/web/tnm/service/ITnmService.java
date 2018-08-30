package com.dpm.web.tnm.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.dpm.resource.common.enity.TResourceInfo;
import com.dpm.resource.common.enity.TTnmInfo;
import com.dpm.resource.common.enity.tnm.TnmParam;
import com.github.pagehelper.PageInfo;

/**
 * @ Purpose:
 * @Package Name: com.dpm.web.model.service
 * @Author: liuxiaoxin
 * @Date: 2018/5/21
 */
public interface ITnmService {
    PageInfo<TTnmInfo> getTnmInfoByCondition(TnmParam tnmParam);
    
    TTnmInfo saveOrUpdateTnmInfo(TTnmInfo tTnmInfo);
    
    int delTnmInfo(TTnmInfo tTnmInfo);
    
    public List<TResourceInfo> fileUpload(MultipartFile[] file);
}
