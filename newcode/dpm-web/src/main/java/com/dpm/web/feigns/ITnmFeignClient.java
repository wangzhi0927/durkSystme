package com.dpm.web.feigns;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dpm.resource.common.enity.TTnmInfo;
import com.dpm.resource.common.enity.tnm.TnmParam;
import com.dpm.web.feigns.hystric.OrganFeignHystric;
import com.github.pagehelper.PageInfo;

@FeignClient(value = "dpm-db", fallback = OrganFeignHystric.class)
public interface ITnmFeignClient {
    @RequestMapping("/tnm/getTnmInfoByCondition")
    PageInfo<TTnmInfo> getTnmInfoByCondition(@RequestBody TnmParam organParam);
    
    @RequestMapping(value = "/tnm/saveOrUpdateTnmInfo", method = RequestMethod.POST)
    TTnmInfo saveOrUpdateTnmInfo(TTnmInfo tTnmInfo);
    
    @RequestMapping(value = "/tnm/delTnmInfo", method = RequestMethod.POST)
    int delTnmInfo(TTnmInfo tTnmInfo);

}
