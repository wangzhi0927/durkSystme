package com.dpm.web.dept.service.impl;

import com.dpm.resource.common.enity.TDeptInfo;
import com.dpm.resource.common.enity.dept.DeptParam;
import com.dpm.resource.freamwork.BusinessException;
import com.dpm.web.dept.service.DeptService;
import com.dpm.web.feigns.IDeptFeignClient;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

/**
 * @Auther: mapengfei
 * @Date: 2018/5/30
 * @Description:
 */
@Service
public class DeptServiceImpl implements DeptService {
    @Autowired
    private IDeptFeignClient deptFeignClient;

    @Override
    public PageInfo<TDeptInfo> getDeptInfoByCondition(DeptParam deptParam) {
        return deptFeignClient.getDeptInfoByCondition(deptParam);
    }
    @Override
    public TDeptInfo saveOrUpdateDeptInfo(TDeptInfo tDeptInfo) {
        if(ObjectUtils.isEmpty(tDeptInfo))
            throw new BusinessException("科室信息不可为空");
        return deptFeignClient.saveOrUpdateDeptInfo(tDeptInfo);
    }

    @Override
    public int changDeptStateById(TDeptInfo tDeptInfo) {
        return deptFeignClient.changDeptStateById(tDeptInfo);
    }
}
