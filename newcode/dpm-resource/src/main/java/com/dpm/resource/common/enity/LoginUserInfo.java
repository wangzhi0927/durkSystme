package com.dpm.resource.common.enity;

import com.dpm.resource.common.enity.TDeptInfo;
import com.dpm.resource.common.enity.TRoleInfo;
import com.dpm.resource.common.enity.TUserInfo;
import lombok.Data;

import java.util.List;

/**
 * @ Purpose: 用户登录实体类
 * @Package Name: com.dpm.resource.common.enity
 * @Author: liuxiaoxin
 * @Date: 2018/5/14
 */
@Data
public class LoginUserInfo {
    private boolean isAutoLogin = false;
    private String token;
    private TUserInfo userInfo;
    private List<TDeptInfo> userDeptList;
    private List<TRoleInfo> roleInfoList;
}
