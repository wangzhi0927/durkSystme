package com.dpm.unity.web.user.pojo.response;

import lombok.Data;

import java.util.List;

import com.dpm.resource.common.enity.TDiseaseInfo;

/**
 * @Auther: mapengfei
 * @Date: 2018/5/17
 * @Description:
 */
@Data
public class GetRecentOperationsResponseData {
    private List<RecentOperationInfo> diseaseList;
    
    private List<TDiseaseInfo> diseaseInfoList;
}
