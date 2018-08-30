package com.dpm.unity.web.his.service.impl;

import com.dpm.unity.common.utils.ContextUtils;
import com.dpm.unity.web.his.service.IRemoteHisClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

/**
 * @Auther: mapengfei
 * @Date: 2018/5/18
 * @Description:
 */
@PropertySource("classpath:config/config.properties")
@Component
public class RemoteRouterServiceFactory {

    @Autowired
    Environment env;
    @Autowired
    ContextUtils contextUtils;
    
    /** 
    * @Description: 创建服务调用service
    * @Param: [hosCode] 
    * @return: com.dpm.unity.web.his.service.IRemoteHisClient 
    * @Author: mapengfei 
    * @Date: 2018/5/18 
    */ 
    public IRemoteHisClient createRemoteHisClientService(String hosCode){
        String serviceName = env.getProperty(hosCode);
        IRemoteHisClient remoteHisClient = (IRemoteHisClient) contextUtils.getBean(serviceName);
        return remoteHisClient;
    }
}
