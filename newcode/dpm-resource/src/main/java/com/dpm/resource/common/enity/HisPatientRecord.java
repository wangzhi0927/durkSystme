package com.dpm.resource.common.enity;

import lombok.Data;

/**
 * @ Purpose:从HIS返回病人信息
 * @Package Name: com.dpm.resource.common.enity
 * @Author: liuxiaoxin
 * @Date: 2018/5/17
 */
@Data
public class HisPatientRecord {
    private TPatientInfo patientInfo;//病人基本信息
    private TRecordInfo recordInfo;//病人谈话记录
}
