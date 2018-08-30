package com.dpm.unity.web.feigns;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.dpm.resource.common.enity.TModelDisplayParam;
import com.dpm.unity.web.feigns.hystric.ModelFeignHystric;

/**
 * @Package Name: com.dpm.unity.web.feigns
 * @Author: gaolei
 * @Date: 2018/6/28
 */
@FeignClient(value = "dpm-db", fallback = ModelFeignHystric.class)
public interface IModelFeignClient {

	@RequestMapping(value = "/resource/getModelDisplayParaList", method = RequestMethod.GET)
	List<TModelDisplayParam> getModelDisplayParaList(@RequestParam(value = "resId") String resId,
			@RequestParam(value = "dispayRate") String dispayRate);

}
