package com.dpm.resource.common.enity.caseinfo;

import java.util.List;

import com.dpm.resource.common.enity.TCaseInfo;
import com.dpm.resource.common.enity.TCaseRelRes;

import lombok.Data;

/**
 * @ Purpose:
 * @Package Name: com.dpm.resource.common.enity.resource
 * @Author: liuxiaoxin
 * @Date: 2018/5/23
 */
@Data
public class CaseInfoDTO {
    private TCaseInfo caseInfo;
    private List<TCaseRelRes> caseRelResList;
}
