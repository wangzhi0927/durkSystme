package com.dpm.resource.common.enity;

import lombok.Data;

import java.util.List;

/**
 * @ Purpose:
 * @Package Name: com.dpm.his.pojo
 * @Author: liuxiaoxin
 * @Date: 2018/5/17
 */
@Data
public class UserDeptInfo {
    private List<TUserInfo> userInfo;
    private List<TDeptInfo> deptInfo;
    private List<TUserDept> userDept;
}
