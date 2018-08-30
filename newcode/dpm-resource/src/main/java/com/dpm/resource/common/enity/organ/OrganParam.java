package com.dpm.resource.common.enity.organ;

import com.dpm.resource.common.enity.TOrganInfo;

import lombok.Data;

/**
 * @ Purpose:
 * @Package Name: com.dpm.resource.common.enity.resource
 * @Author: liuxiaoxin
 * @Date: 2018/5/23
 */
@Data
public class OrganParam {
    private TOrganInfo organInfo;
    private int pageSize;
    private int pageNum;
}
