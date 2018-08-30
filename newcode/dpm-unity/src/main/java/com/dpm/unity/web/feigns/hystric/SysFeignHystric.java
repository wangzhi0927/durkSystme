package com.dpm.unity.web.feigns.hystric;

import com.dpm.resource.common.enity.TDictDetail;
import com.dpm.resource.common.enity.THospitalInfo;
import com.dpm.unity.web.feigns.IRecordFeignClient;
import com.dpm.unity.web.feigns.ISysFeignClient;

import java.util.List;
import java.util.Map;


public class SysFeignHystric implements ISysFeignClient {

    @Override
    public Map<String, List<TDictDetail>> getDictDetailInfo(String dictType) {
        return null;
    }

    @Override
    public List<THospitalInfo> getHospitalInfos(String hosCode) {
        return null;
    }
}
