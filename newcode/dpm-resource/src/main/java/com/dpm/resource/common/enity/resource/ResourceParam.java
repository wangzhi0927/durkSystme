package com.dpm.resource.common.enity.resource;

import java.util.List;

import com.dpm.resource.common.enity.TModelDisplayParam;
import com.dpm.resource.common.enity.TResourceInfo;
import lombok.Data;

/**
 * @ Purpose:
 * @Package Name: com.dpm.resource.common.enity.resource
 * @Author: liuxiaoxin
 * @Date: 2018/5/23
 */
@Data
public class ResourceParam {
    private TResourceInfo resourceInfo;
    private int pageSize;
    private int pageNum;
    private List<TModelDisplayParam> modelDisplayParamList;
}
