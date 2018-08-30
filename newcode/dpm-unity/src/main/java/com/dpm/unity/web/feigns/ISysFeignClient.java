package com.dpm.unity.web.feigns;

import com.dpm.resource.common.enity.TDictDetail;
import com.dpm.resource.common.enity.THospitalInfo;
import com.dpm.unity.web.feigns.hystric.SysFeignHystric;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

/**
 * @Auther: mapengfei
 * @Date: 2018/5/19
 * @Description:
 */
@FeignClient(value = "dpm-db", fallback = SysFeignHystric.class)
public interface ISysFeignClient {

    @RequestMapping(value = "/sys/getDictDetailInfo",method = RequestMethod.POST)
    Map<String, List<TDictDetail>> getDictDetailInfo(@RequestParam(value = "dictType",required = false) String dictType);

    @RequestMapping(value = "/sys/getHospitalInfos",method = RequestMethod.POST)
    List<THospitalInfo> getHospitalInfos(@RequestParam(value = "hosCode",required = false) String hosCode);

}
