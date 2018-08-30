package com.dpm.unity.web.feigns;

import com.dpm.resource.common.enity.LoginUserInfo;
import com.dpm.resource.common.enity.TRecordInfo;
import com.dpm.unity.web.feigns.hystric.UserFeignHystric;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @ Purpose: 用户服务类FeignsClient
 * @Package Name: com.dpm.unity.web.feigns
 * @Author: liuxiaoxin
 * @Date: 2018/5/15
 */
@FeignClient(value = "dpm-db", fallback = UserFeignHystric.class)
public interface IUserFeignClient {
    /**
     * 获取用户长令牌
     *
     * @param userKey
     * @return
     */
    @RequestMapping("/user/getLoginToken")
    String getLoginToken(@RequestParam(value = "userKey") String userKey);

    /**
     * 用户登录
     *
     * @param loginUserInfo
     * @return
     */
    @RequestMapping("/user/doLogin")
    LoginUserInfo doLogin(@RequestBody LoginUserInfo loginUserInfo);

    /**
     * @param
     * @return
     */
    @RequestMapping("/user/doLogout")
    String doLogout(@RequestParam(value = "token") String token);

    /**
     * 获取最近操作信息
     * @param userId
     * @param hosCode
     * @return
     */
    @RequestMapping(value = "/user/getRecentOperations")
    List<TRecordInfo> getRecentOperations(@RequestParam(value = "userId") String userId,@RequestParam(value = "hosCode") String hosCode);
}
