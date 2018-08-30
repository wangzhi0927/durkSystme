package com.dpm.web.user.service;

import com.dpm.resource.common.enity.RecordCondition;
import com.dpm.resource.common.enity.TRecordInfo;
import com.github.pagehelper.PageInfo;

import javax.servlet.http.HttpServletResponse;

/**
 * @ Purpose:
 * @Package Name: com.dpm.web.user.service
 * @Author: liuxiaoxin
 * @Date: 2018/6/5
 */
public interface IRecordService {
    void downRecordFile(String filePath, HttpServletResponse httpServletResponse);

    PageInfo<TRecordInfo> getRecordInfoByCondition(RecordCondition param);

    boolean validRecordFile(String filePath);
}
