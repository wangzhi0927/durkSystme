package com.dpm.web.feigns;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dpm.resource.common.enity.TDeptInfo;
import com.dpm.resource.common.enity.dept.DeptParam;
import com.dpm.web.feigns.hystric.DeptFeignHystric;
import com.github.pagehelper.PageInfo;

@FeignClient(value = "dpm-db", fallback = DeptFeignHystric.class)
public interface IDeptFeignClient {

    @RequestMapping("/dept/getDeptInfoByCondition")
    PageInfo<TDeptInfo> getDeptInfoByCondition(@RequestBody DeptParam deptParam);
    @RequestMapping("/dept/saveOrUpdateDeptInfo")
    TDeptInfo saveOrUpdateDeptInfo(@RequestBody TDeptInfo tDeptInfo);
    @RequestMapping(value = "/dept/changDeptStateById",method = RequestMethod.POST)
    int changDeptStateById(@RequestBody TDeptInfo tDeptInfo);
}
