package com.dpm.web.tnm.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.web.multipart.MultipartFile;

import com.dpm.resource.common.enity.FileResult;
import com.dpm.resource.common.enity.TResourceInfo;
import com.dpm.resource.common.enity.TTnmInfo;
import com.dpm.resource.common.enity.tnm.TnmParam;
import com.dpm.resource.common.utils.FtpUtils;
import com.dpm.resource.freamwork.BusinessException;
import com.dpm.web.feigns.ITnmFeignClient;
import com.dpm.web.tnm.service.ITnmService;
import com.github.pagehelper.PageInfo;

/**
 * @Auther: mapengfei
 * @Date: 2018/6/4
 * @Description:
 */
@Service
public class TnmServiceImpl implements ITnmService{
    @Autowired
    private ITnmFeignClient iTnmFeignClient;
    
    @Autowired
    FtpUtils ftpUtils;
    
    public PageInfo<TTnmInfo> getTnmInfoByCondition(TnmParam tnmParam) {
        return iTnmFeignClient.getTnmInfoByCondition(tnmParam);
    }
    
    @Override
    public TTnmInfo saveOrUpdateTnmInfo(TTnmInfo tTnmInfo) {
    	return iTnmFeignClient.saveOrUpdateTnmInfo(tTnmInfo);
    }

	@Override
	public int delTnmInfo(TTnmInfo tOrganInfo) {
		return iTnmFeignClient.delTnmInfo(tOrganInfo);
	}

	@Override
    public List<TResourceInfo> fileUpload(MultipartFile[] file) {
		List<TResourceInfo> tResourceInfo = new ArrayList<>();
        if (ObjectUtils.isEmpty(file)) {
            throw new BusinessException("文件列表为空，请重新选择文件！");
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String path = "/tnm/" + sdf.format(new Date()) + "/";
        List<FileResult> fileResult = ftpUtils.uploadFile(file, path);
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
}
