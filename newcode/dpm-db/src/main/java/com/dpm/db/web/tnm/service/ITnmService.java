package com.dpm.db.web.tnm.service;

import com.dpm.resource.common.enity.TTnmInfo;
import com.dpm.resource.common.enity.tnm.TnmParam;
import com.github.pagehelper.PageInfo;

public interface ITnmService {
	PageInfo<TTnmInfo> getTnmInfoByCondition(TnmParam tnmParam);
    
    TTnmInfo saveOrUpdateTnmInfo(TTnmInfo tTnmInfo);
    
    int delTnmInfo(TTnmInfo tTnmInfo);
}
