package com.dpm.unity.web.sys.service.impl;

import com.dpm.resource.common.enity.FileResult;
import com.dpm.resource.common.utils.FtpUtils;
import com.dpm.resource.freamwork.BusinessException;
import com.dpm.unity.common.utils.ContextUtils;
import com.dpm.unity.common.validation.ValidationProperty;
import com.dpm.unity.web.feigns.IRecordFeignClient;
import com.dpm.unity.web.sys.pojo.request.FileUploadRequestData;
import com.dpm.unity.web.sys.pojo.response.FileUploadResponseData;
import com.dpm.unity.web.sys.service.IRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @Auther: mapengfei
 * @Date: 2018/5/19
 * @Description:
 */
@Service
public class RecordServiceImpl implements IRecordService { 
    @Autowired
    private IRecordFeignClient iRecordFeignClient;
    @Autowired
    private FtpUtils ftpUtils;

    public static String PATH_RECORD = "/record";

    @Override
    public FileUploadResponseData uploadFile(FileUploadRequestData fileUploadRequestData) {
        FileUploadResponseData fileUploadResponseData = new FileUploadResponseData();
        if (fileUploadRequestData.getFile()==null && fileUploadRequestData.getFile().length == 0) {
            throw new BusinessException("文件列表为空，请重新选择文件！");
        }
        String checkResult = ValidationProperty.validate(fileUploadRequestData,ValidationProperty.FileUploadCheckParams);
        if(!StringUtils.isEmpty(checkResult))
            throw new BusinessException("以下请求入参不可为空：" + checkResult);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String uploadPath = PATH_RECORD + "/"+ sdf.format(new Date())+"/"+fileUploadRequestData.getRecordId();
        List<FileResult> fileResult = ftpUtils.uploadFile(fileUploadRequestData.getFile(), uploadPath);
        fileUploadResponseData.setUploadResult(fileResult);
        if("0".equals(fileUploadRequestData.getType()))
            iRecordFeignClient.updatePatientTalkIdNoPath(fileUploadRequestData.getRecordId(),uploadPath);
        return fileUploadResponseData;
    }
}
