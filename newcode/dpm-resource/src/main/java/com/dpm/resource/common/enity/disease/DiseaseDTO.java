package com.dpm.resource.common.enity.disease;

import java.util.List;

import com.dpm.resource.common.enity.TCaseInfo;
import com.dpm.resource.common.enity.TDiseaseInfo;
import com.dpm.resource.common.enity.TDiseaseRelCase;
import com.dpm.resource.common.enity.TDiseaseRelRes;
import com.dpm.resource.common.enity.TOrganInfo;

import lombok.Data;

/**
 * @Auther: mapengfei
 * @Date: 2018/6/4
 * @Description:
 */
@Data
public class DiseaseDTO {
    private TDiseaseInfo diseaseInfo;
    private List<TDiseaseRelRes> diseaseRelResList;
    private List<TOrganInfo> organInfoList;
    private List<TCaseInfo> caseInfoList;
    private List<TDiseaseRelCase> diseaseRelCaseList;
    private String[] relCaseArray;
}
