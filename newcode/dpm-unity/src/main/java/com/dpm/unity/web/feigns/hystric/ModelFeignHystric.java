package com.dpm.unity.web.feigns.hystric;

import java.util.List;

import com.dpm.resource.common.enity.TModelDisplayParam;
import com.dpm.unity.web.feigns.IModelFeignClient;

/**
 * @ Purpose:
 * @Package Name: com.dpm.unity.web.feigns.hystric
 * @Author: liuxiaoxin
 * @Date: 2018/5/15
 */
public class ModelFeignHystric implements IModelFeignClient {
    @Override
    public List<TModelDisplayParam> getModelDisplayParaList(String resId,String dispayRate) {
        return null;
    }

}
