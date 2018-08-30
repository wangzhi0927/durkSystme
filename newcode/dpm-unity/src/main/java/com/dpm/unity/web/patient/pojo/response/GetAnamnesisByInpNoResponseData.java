package com.dpm.unity.web.patient.pojo.response;

import lombok.Data;

/**
 * @Auther: mapengfei
 * @Date: 2018/5/18
 * @Description:
 */
@Data
public class GetAnamnesisByInpNoResponseData {
    private String inpNo;
    private String patientName;
    private String idNo;
    private String age;
    private String sex;
    private String diagNo;
    private String diagName;
    private String recordId;
    private String deptName;
    private String wardName;
    private String bedNo;
    private String diseaseCode;
}
