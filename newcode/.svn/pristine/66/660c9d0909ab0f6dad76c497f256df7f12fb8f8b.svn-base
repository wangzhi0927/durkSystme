package com.dpm.web.dept.service;

import com.dpm.resource.common.enity.TDeptInfo;
import com.dpm.resource.common.enity.dept.DeptParam;
import com.dpm.resource.common.enity.userInfo.UserConditionParam;
import com.dpm.resource.common.enity.userInfo.UserSearchResult;
import com.github.pagehelper.PageInfo;

/**
 * @Auther: mapengfei
 * @Date: 2018/5/30
 * @Description:
 */
public interface DeptService {

    PageInfo<TDeptInfo> getDeptInfoByCondition(DeptParam deptParam);

    TDeptInfo saveOrUpdateDeptInfo(TDeptInfo tDeptInfo);

    int changDeptStateById(TDeptInfo tDeptInfo);

}
