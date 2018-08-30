package com.dpm.zuul.config;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

/**
 * @ Purpose:
 * @Package Name: com.dpm.zuul.config
 * @Author: liuxiaoxin
 * @Date: 2018/5/14
 */
public class ErrorFilter extends ZuulFilter {


    @Override
    public String filterType() {
        //异常过滤器
        return "error";
    }

    @Override
    public int filterOrder() {
        //优先级，数字越大，优先级越低
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        //是否执行该过滤器，true代表需要过滤
        return true;
    }

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        System.out.println(ctx.getResponseBody());
        ctx.setResponseBody("出现异常");
        return null;

    }

}