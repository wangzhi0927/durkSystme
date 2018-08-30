package com.dpm.unity.common.freamwork;

import com.dpm.unity.common.token.TokenInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @ Purpose:
 * @Package Name: com.dpm.unity.common.freamwork
 * @Author: liuxiaoxin
 * @Date: 2018/5/10
 */
@Configuration
public class DpmUnityConfigurer extends WebMvcConfigurerAdapter {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 多个拦截器组成一个拦截器链
        // addPathPatterns 用于添加拦截规则
        // excludePathPatterns 用户排除拦截 "/doLogin", "/swagger*","/doLogout"
        registry.addInterceptor(new TokenInterceptor()).addPathPatterns("/**").excludePathPatterns(new String[]{"/**"});
        super.addInterceptors(registry);

    }
}
