package com.dpm.unity.web.sys.pojo.response;

import com.dpm.resource.common.enity.FileResult;
import lombok.Data;

import java.util.List;

/**
 * @Auther: mapengfei
 * @Date: 2018/5/21
 * @Description:
 */
@Data
public class FileUploadResponseData {
    private List<FileResult> uploadResult;
}
