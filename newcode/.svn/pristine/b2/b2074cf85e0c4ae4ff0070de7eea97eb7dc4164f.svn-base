package com.dpm.web.feigns;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dpm.resource.common.enity.TOrganInfo;
import com.dpm.resource.common.enity.TResourceInfo;
import com.dpm.resource.common.enity.organ.OrganParam;
import com.dpm.web.feigns.hystric.OrganFeignHystric;
import com.github.pagehelper.PageInfo;

@FeignClient(value = "dpm-db", fallback = OrganFeignHystric.class)
public interface IOrganFeignClient {
    @RequestMapping("/organ/getOrganInfoByCondition")
    PageInfo<TOrganInfo> getOrganInfoByCondition(@RequestBody OrganParam organParam);
    
    @RequestMapping(value = "/resource/getResourceInfoList", method = RequestMethod.POST)
	List<TResourceInfo> getResourceInfoList(@RequestBody TResourceInfo tResourceInfo);
    
    @RequestMapping(value = "/organ/saveOrUpdateOrganInfo", method = RequestMethod.POST)
    TOrganInfo saveOrUpdateOrganInfo(TOrganInfo tOrganInfo);
    
    @RequestMapping(value = "/organ/delOrganInfo", method = RequestMethod.POST)
    int delOrganInfo(TOrganInfo tOrganInfo);

}
