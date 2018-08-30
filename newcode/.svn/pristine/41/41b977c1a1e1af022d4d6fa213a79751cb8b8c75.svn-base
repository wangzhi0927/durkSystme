package com.dpm.unity.web.disease.service;

import java.util.List;

import com.dpm.resource.common.enity.ResourceInfo;
import com.dpm.resource.common.enity.TDiseaseInfo;
import com.dpm.resource.common.enity.TModelDisplayParam;
import com.dpm.resource.common.enity.TOrganInfo;
import com.dpm.resource.common.enity.TTnmInfo;
import com.dpm.unity.web.disease.pojo.request.GetDiseaseInfoByOrganRequestData;
import com.dpm.unity.web.disease.pojo.request.GetModeDisplayParamRequestData;
import com.dpm.unity.web.disease.pojo.request.GetOrganInfoByOrganRequestData;
import com.dpm.unity.web.disease.pojo.request.GetOrganInfoBySystemRequestData;
import com.dpm.unity.web.disease.pojo.request.GetRscInfoByDiseaseRequestData;
import com.dpm.unity.web.disease.pojo.request.GetRscInfoByOrganRequestData;
import com.dpm.unity.web.disease.pojo.request.GetRscInfoByRscRequestData;
import com.dpm.unity.web.disease.pojo.request.GetTnmInfoByDiseaseRequestData;

/**
 * @Auther: mapengfei
 * @Date: 2018/5/15
 * @Description:
 */
public interface UnityIDiseaseService {

     List<TOrganInfo> getOrganInfoBySystem(GetOrganInfoBySystemRequestData getOrganInfoBySystemRequestData);

     List<TOrganInfo> getOrganInfoByOrgan(GetOrganInfoByOrganRequestData getOrganInfoByOrganRequestData);

     List<TDiseaseInfo> getDiseaseInfoByOrgan(GetDiseaseInfoByOrganRequestData getDiseaseInfoByOrganRequestData);

     List<ResourceInfo> getRscInfoByOrgan(GetRscInfoByOrganRequestData getRscInfoByOrganRequestData);

     List<ResourceInfo> getRscInfoByDisease(GetRscInfoByDiseaseRequestData getRscInfoByDiseaseRequestData);

     List<ResourceInfo> getRscInfoByRsc(GetRscInfoByRscRequestData getRscInfoByRscRequestData);

     TModelDisplayParam getModeDisplayParam (GetModeDisplayParamRequestData getModeDisplayParamRequestData);

     List<TTnmInfo> getTnmInfoByDisease(GetTnmInfoByDiseaseRequestData getTnmInfoByDiseaseRequestData);
     
     ResourceInfo getResourceInfo(String diseaseCode, String dispayRate, String platform);
}
