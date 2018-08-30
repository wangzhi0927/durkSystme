package com.dpm.resource.common.enity;

import lombok.Data;

import java.util.List;

/**
 * @Auther: mapengfei
 * @Date: 2018/5/16
 * @Description:
 */
@Data
public class PatientRecordInfo extends TPatientInfo {
    private List<TRecordInfo> recordInfo;
}
