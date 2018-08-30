package com.dpm.unity.web.feigns;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dpm.unity.web.feigns.hystric.RecordFeignHystric;

/**
 * @Auther: mapengfei
 * @Date: 2018/5/19
 * @Description:
 */
@FeignClient(value = "dpm-db", fallback = RecordFeignHystric.class)
public interface IRecordFeignClient {

    @RequestMapping("/sys/record/updatePatientTalkIdNoPath")
    int updatePatientTalkIdNoPath(@RequestParam(value = "recordId")String recordId,@RequestParam(value = "path") String path);

}
