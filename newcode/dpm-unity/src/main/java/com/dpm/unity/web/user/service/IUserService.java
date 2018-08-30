package com.dpm.unity.web.user.service;

import com.dpm.unity.web.user.pojo.request.GetRecentOperationsRequestData;
import com.dpm.unity.web.user.pojo.response.GetRecentOperationsResponseData;

/**
 * @Auther: mapengfei
 * @Date: 2018/5/17
 * @Description:
 */
public interface IUserService {

    GetRecentOperationsResponseData getRecentOperations(GetRecentOperationsRequestData getRecentOperationsRequestData);
}
