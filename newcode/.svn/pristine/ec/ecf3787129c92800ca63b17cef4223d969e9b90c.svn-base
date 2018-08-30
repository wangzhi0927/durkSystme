package com.dpm.unity.web.his.service;

import com.dpm.resource.common.enity.HisPatientRecord;
import org.springframework.context.annotation.PropertySource;

/**
 * @ Purpose:
 * @Package Name: com.dpm.his.service
 * @Author: liuxiaoxin
 * @Date: 2018/5/16
 */
@PropertySource("classpath:config/config.properties")
public interface IRemoteHisClient {

    /**
     * 业务处理逻辑：
     * 根据住院号获取HIS信息->根据身份证校验写入T_PATIENT_INFO->写入T_RECORD_INFO
     * @param hosCode
     * @param inpno
     * @return
     */
    public HisPatientRecord getPatientRecord(String hosCode, String inpno) throws Exception;

    public void asyncUserDeptInfo(String hosCode) throws Exception;
}
