package com.dpm.db.web.sys.service;

import com.dpm.resource.common.enity.TDictDetail;
import com.dpm.resource.common.enity.THospitalInfo;

import java.util.List;
import java.util.Map;

/**
 * @Auther: mapengfei
 * @Date: 2018/5/21
 * @Description:
 */
public interface ISysService {
    Map<String,List<TDictDetail>> getDictDetailInfo(String dictType);
    List<THospitalInfo> getHospitalInfos(String hosCode);
}
