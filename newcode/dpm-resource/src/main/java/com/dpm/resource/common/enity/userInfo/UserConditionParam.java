package com.dpm.resource.common.enity.userInfo;

import com.dpm.resource.common.enity.TResourceInfo;
import com.dpm.resource.common.enity.TUserInfo;
import lombok.Data;

/**
 * @Auther: mapengfei
 * @Date: 2018/5/25
 * @Description:
 */
@Data
public class UserConditionParam {
    private int pageSize;
    private int pageNum;
    private UserParam userInfo;
}
