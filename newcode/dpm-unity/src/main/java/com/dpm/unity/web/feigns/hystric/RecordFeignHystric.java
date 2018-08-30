package com.dpm.unity.web.feigns.hystric;

import com.dpm.unity.web.feigns.IRecordFeignClient;


public class RecordFeignHystric implements IRecordFeignClient {
    @Override
    public int updatePatientTalkIdNoPath(String recordId, String path) {
        return 0;
    }
}
