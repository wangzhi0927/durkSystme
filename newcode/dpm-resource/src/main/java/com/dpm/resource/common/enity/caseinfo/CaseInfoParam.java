package com.dpm.resource.common.enity.caseinfo;

import com.dpm.resource.common.enity.TCaseInfo;

import lombok.Data;

/**
 * @ Purpose:
 * @Package Name: com.dpm.resource.common.enity.resource
 * @Author: liuxiaoxin
 * @Date: 2018/5/23
 */
@Data
public class CaseInfoParam {
    private TCaseInfo caseInfo;
    private int pageSize;
    private int pageNum;
}
