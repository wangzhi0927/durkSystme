package com.dpm.unity.web.disease.pojo.request;

import lombok.Data;

/**
 * @Auther: mapengfei
 * @Date: 2018/5/16
 * @Description:
 */
@Data
public class GetRscInfoByRscRequestData {
    private String resourceId;
    private String displayRate;
    private String diseaseCode;
}
