package com.dpm.unity.web.feigns;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.dpm.resource.common.enity.TOrganInfo;
import com.dpm.resource.common.enity.TResourceInfo;
import com.dpm.unity.web.feigns.hystric.OrganFeignHystric;

/**
 * @Package Name: com.dpm.unity.web.feigns
 * @Author: gaolei
 * @Date: 2018/6/28
 */
@FeignClient(value = "dpm-db", fallback = OrganFeignHystric.class)
public interface IOrganFeignClient {

	@RequestMapping(value = "/organ/getOrganListBySystemId", method = RequestMethod.GET)
	List<TOrganInfo> getOrganListBySystemId(@RequestParam(value = "systemId") String systemId,
			@RequestParam(value = "sex") String sex);

	@RequestMapping(value = "/resource/getResourceInfoList", method = RequestMethod.POST)
	List<TResourceInfo> getResourceInfoList(@RequestBody TResourceInfo tResourceInfo);
	
	@RequestMapping(value = "/organ/getOrganInfo", method = RequestMethod.POST)
	List<TOrganInfo> getOrganInfo(@RequestBody TOrganInfo tOrganInfo);

}
