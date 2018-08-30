package com.dpm.unity.web.his.controller;

import com.dpm.resource.common.enity.HisPatientRecord;
import com.dpm.resource.freamwork.BusinessResult;
import com.dpm.unity.web.his.service.IRemoteHisClient;
import com.dpm.unity.web.his.service.impl.RemoteRouterServiceFactory;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ Purpose:
 * @Package Name: com.dpm.his.controller
 * @Author: liuxiaoxin
 * @Date: 2018/5/16
 */

@RestController
public class RemoteController {
    @Autowired
    RemoteRouterServiceFactory remoteRouterServiceFactory;

    /**
     * 获取病历信息
     * @param hosCode
     * @param inpNo
     * @return
     * @throws Exception
     */
    @ApiOperation(value = "根据医院与his档案号获取病人基本信息", notes = "根据医院与his档案号获取病人基本信息")
    @RequestMapping(value = "/getAnamnesisByInpNo", method = RequestMethod.POST)
    public BusinessResult getAnamnesisByInpNo(String hosCode, String inpNo) throws Exception {
        IRemoteHisClient remoteHisClient = remoteRouterServiceFactory.createRemoteHisClientService(hosCode);
        return BusinessResult.success(remoteHisClient.getPatientRecord(hosCode, inpNo));
    }
}
