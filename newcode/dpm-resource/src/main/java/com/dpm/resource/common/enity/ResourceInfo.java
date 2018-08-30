package com.dpm.resource.common.enity;

import java.util.List;

import lombok.Data;

/**
 * @Auther: mapengfei
 * @Date: 2018/5/17
 * @Description:
 */
@Data
public class ResourceInfo extends TResourceInfo{
    private TModelDisplayParam displayParam;
    
    private List<TModelDisplayParam> modelDisplayParamList;
}
