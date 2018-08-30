package com.dpm.unity.web.sys.service.impl;

import com.dpm.resource.common.enity.TDictDetail;
import com.dpm.resource.common.enity.THospitalInfo;
import com.dpm.unity.web.feigns.ISysFeignClient;
import com.dpm.unity.web.sys.pojo.response.GetHospitalInfosResponseData;
import com.dpm.unity.web.sys.service.ISysService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @Auther: mapengfei
 * @Date: 2018/5/21
 * @Description:
 */
@Service
public class SysServiceImpl implements ISysService {
    @Autowired
    private ISysFeignClient iSysFeignClient;

    @Override
    public Map<String, List<TDictDetail>> getDictDetailInfo(String dictType) {
        return iSysFeignClient.getDictDetailInfo(dictType);
    }

    @Override
    public GetHospitalInfosResponseData getHospitalInfos(String hosCode) {
        GetHospitalInfosResponseData getHospitalInfosResponseData = new GetHospitalInfosResponseData();
        getHospitalInfosResponseData.setHospInfo(iSysFeignClient.getHospitalInfos(hosCode));
        return getHospitalInfosResponseData;
    }
}
