package com.dpm.unity.common.utils;

import com.alibaba.fastjson.JSON;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;

/**
 * @ Purpose:CXF 访问webservice接口数据
 * @Package Name: com.dpm.his.utils
 * @Author: liuxiaoxin
 * @Date: 2018/5/16
 */
public class SoapUtils {

    /**
     * @param wsdlUrl
     * @param methodName
     * @param param
     * @return
     * @throws Exception
     */
    public static String getWebserviceResponse(String wsdlUrl, String methodName, Object... param) throws Exception {
        JaxWsDynamicClientFactory clientFactory = JaxWsDynamicClientFactory.newInstance();
        Client client = clientFactory.createClient(wsdlUrl);
        Object[] result = client.invoke(methodName, param);
        return JSON.toJSONString(result[0]);
    }
}
