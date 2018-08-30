package com.dpm.unity.web.caseInfo.pojo.request;

import lombok.Data;

/**
 * @Auther: mapengfei
 * @Date: 2018/5/16
 * @Description:
 */
@Data
public class GetPatientRecordInfoRequestData {
    private String inpNo;
    private String hosCode;
    private String talkType;
}
