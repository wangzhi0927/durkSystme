package com.dpm.unity.web.patient.pojo.response;

import com.dpm.resource.common.enity.TCaseInfo;
import lombok.Data;

import java.util.List;

/**
 * @Auther: mapengfei
 * @Date: 2018/5/18
 * @Description:
 */
@Data
public class GetOperationInfoResponseData {
    private List<TCaseInfo> operationInfo;
}
