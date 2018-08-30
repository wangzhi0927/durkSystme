package com.dpm.db.web.sys.service;

import com.dpm.resource.common.enity.TRecordInfo;
import com.github.pagehelper.PageInfo;

/**
 * @Auther: mapengfei
 * @Date: 2018/5/21
 * @Description:
 */
public interface IRecordService {
    int updatePatientTalkIdNoPath(String recordId,String path);

    PageInfo<TRecordInfo> getRecordInfoByCondition(TRecordInfo recordInfo, int pageSize, int pageNum);
}
