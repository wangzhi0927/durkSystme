package com.dpm.unity.web.patient.pojo.request;

import lombok.Data;

/**
 * @Auther: mapengfei
 * @Date: 2018/5/18
 * @Description:
 */
@Data
public class GetAnamnesisByInpNoRequestData {
    private String inpNo;
    private String hosCode;
}
