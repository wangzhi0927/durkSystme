package com.dpm.unity.web.sys.service;

import com.dpm.unity.web.sys.pojo.request.FileUploadRequestData;
import com.dpm.unity.web.sys.pojo.response.FileUploadResponseData;

/**
 * @Auther: mapengfei
 * @Date: 2018/5/19
 * @Description:
 */
public interface IRecordService {
    FileUploadResponseData uploadFile(FileUploadRequestData fileUploadRequestData);
}
