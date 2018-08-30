package com.dpm.unity.web.user.service.impl;

import com.dpm.resource.common.enity.TDiseaseInfo;
import com.dpm.resource.common.enity.TRecordInfo;
import com.dpm.resource.freamwork.BusinessException;
import com.dpm.unity.common.validation.ValidationProperty;
import com.dpm.unity.web.feigns.IDiseaseFeignClient;
import com.dpm.unity.web.feigns.IUserFeignClient;
import com.dpm.unity.web.user.pojo.request.GetRecentOperationsRequestData;
import com.dpm.unity.web.user.pojo.response.GetRecentOperationsResponseData;
import com.dpm.unity.web.user.pojo.response.RecentOperationInfo;
import com.dpm.unity.web.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: mapengfei
 * @Date: 2018/5/17
 * @Description:
 */
@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    IUserFeignClient IUserFeignClient;
    
    @Autowired
    IDiseaseFeignClient iDiseaseFeignClient;
    
    /** 
    * @Description: 获取医生最近操作的疾病信息 
    * @Param: [getRecentOperationsRequestData] 
    * @return: com.dpm.unity.web.user.pojo.response.GetRecentOperationsResponseData 
    * @Author: mapengfei 
    * @Date: 2018/5/17 
    */ 
    @Override
    public GetRecentOperationsResponseData getRecentOperations(GetRecentOperationsRequestData getRecentOperationsRequestData) {

        String checkResult = ValidationProperty.validate(getRecentOperationsRequestData,ValidationProperty.GetRecentOperationsCheckParams);
        if(!StringUtils.isEmpty(checkResult))
            throw new BusinessException("以下请求入参不可为空：" + checkResult);
        GetRecentOperationsResponseData getRecentOperationsResponseData = new GetRecentOperationsResponseData();
        List<RecentOperationInfo> recentOperationInfos = new ArrayList<RecentOperationInfo>();
        List<TRecordInfo> tRecordInfos = IUserFeignClient.getRecentOperations(getRecentOperationsRequestData.getUserId(),getRecentOperationsRequestData.getHosCode());
        if(!ObjectUtils.isEmpty(tRecordInfos)){
            tRecordInfos.forEach(tRecordInfo -> {
                recentOperationInfos.add(new RecentOperationInfo().setDiagCode(tRecordInfo.getDeptCode()).setDiagName(tRecordInfo.getDiagName())
                .setNarcoticId(tRecordInfo.getNarcoticId()).setOperation(tRecordInfo.getOperation()).setTalkType(tRecordInfo.getTalkType()));
            });
        }
        getRecentOperationsResponseData.setDiseaseList(recentOperationInfos);
        
        List<TDiseaseInfo> diseaseInfoList = new ArrayList<TDiseaseInfo>();
        String[] icd10Array = {"I71.000","C73.x00","I21.900"};
        for(String icd10 : icd10Array) {
	        TDiseaseInfo tDiseaseInfo = new TDiseaseInfo();
	        tDiseaseInfo.setIcd10(icd10);
	        diseaseInfoList.addAll(iDiseaseFeignClient.getDiseaseInfoByConditions(tDiseaseInfo));
        }
        getRecentOperationsResponseData.setDiseaseInfoList(diseaseInfoList);
        return getRecentOperationsResponseData;
    }
}
