package com.dpm.unity.web.disease.pojo.response;

import com.dpm.resource.common.enity.TOrganInfo;
import lombok.Data;

import java.util.List;

/**
 * @Auther: mapengfei
 * @Date: 2018/5/15
 * @Description:获取系统下返回器官
 */
@Data
public class GetOrganInfoResponseData {

    private List<TOrganInfo> organInfo;

}
