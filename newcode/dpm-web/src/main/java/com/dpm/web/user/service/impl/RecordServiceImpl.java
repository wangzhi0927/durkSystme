package com.dpm.web.user.service.impl;

import com.dpm.resource.common.enity.RecordCondition;
import com.dpm.resource.common.enity.TRecordInfo;
import com.dpm.resource.common.utils.FtpUtils;
import com.dpm.resource.freamwork.BusinessException;
import com.dpm.web.feigns.IResourceFeignClient;
import com.dpm.web.user.service.IRecordService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;

/**
 * @ Purpose:
 * @Package Name: com.dpm.web.user.service.impl
 * @Author: liuxiaoxin
 * @Date: 2018/6/5
 */
@Service
public class RecordServiceImpl implements IRecordService {
    @Autowired
    FtpUtils ftpUtils;
    @Autowired
    IResourceFeignClient resourceFeignClient;

    @Override
    public void downRecordFile(String filePath, HttpServletResponse httpServletResponse) {
        ftpUtils.downloadFile(filePath, httpServletResponse);
    }

    @Override
    public PageInfo<TRecordInfo> getRecordInfoByCondition(RecordCondition param) {
        return resourceFeignClient.getRecordInfoByCondition(param);
    }

    @Override
    public boolean validRecordFile(String filePath) {
        boolean hasFile = ftpUtils.validFile(filePath);
        if (!hasFile)
            throw new BusinessException("下载资源不存在");
        return true;
    }
}
