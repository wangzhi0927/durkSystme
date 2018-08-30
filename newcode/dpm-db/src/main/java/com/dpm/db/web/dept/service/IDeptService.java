package com.dpm.db.web.dept.service;

import com.dpm.resource.common.enity.TDeptInfo;
import com.dpm.resource.common.enity.dept.DeptParam;
import com.github.pagehelper.PageInfo;

/**
 * @Auther: mapengfei
 * @Date: 2018/5/30
 * @Description:
 */
public interface IDeptService {
    PageInfo<TDeptInfo> getDeptInfoByCondition(TDeptInfo tDeptInfo,int pageSize, int pageNum);

    TDeptInfo saveOrUpdateDeptInfo(TDeptInfo tDeptInfo);

    int changDeptStateById(TDeptInfo tDeptInfo);
}
