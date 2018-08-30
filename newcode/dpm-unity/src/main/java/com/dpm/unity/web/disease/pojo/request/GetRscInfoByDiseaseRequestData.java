package com.dpm.unity.web.disease.pojo.request;

import lombok.Data;

/**
 * @Auther: mapengfei
 * @Date: 2018/5/15
 * @Description:
 */
@Data
public class GetRscInfoByDiseaseRequestData {
    private String diseaseCode;
    private String displayRate;
    private String resName;
}
