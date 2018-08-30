package com.dpm.web.common.token;

import com.auth0.jwt.exceptions.TokenExpiredException;
import com.dpm.web.login.service.impl.LoginServiceImpl;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.util.StringUtils;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * @ Purpose:Token拦截器，用来校验Token
 * @Package Name: com.dpm.web.common.handler
 * @Author: liuxiaoxin
 * @Date: 2018/5/4
 */
public class TokenInterceptor implements HandlerInterceptor {

    @Autowired
    private LoginServiceImpl loginServiceImpl;
    @Autowired
    JwtTokenService jwtTokenService;

    @Bean
    public LoginServiceImpl LoginServiceImpl() {
        return new LoginServiceImpl();
    }

    ;
    private final Logger logger = LogManager.getLogger(this.getClass());

    /**
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        if (handler instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            Method method = handlerMethod.getMethod();
            String token = request.getHeader("token");
            /**
             * 获取Bean
             */
            BeanFactory factory = WebApplicationContextUtils.getRequiredWebApplicationContext(request.getServletContext());
            if (null == loginServiceImpl) loginServiceImpl = (LoginServiceImpl) factory.getBean("loginServiceImpl");
            if (null == jwtTokenService) jwtTokenService = (JwtTokenService) factory.getBean("jwtTokenService");

            String orignToken = loginServiceImpl.getRefreshToken(token);
            if (!StringUtils.isEmpty(orignToken)) {
                String refreshToken = jwtTokenService.verifyRefreshToken(token, orignToken);
                response.setHeader("refresh-token", refreshToken);
                //表示token合法
                return true;
            } else {
                //token不合法或者过期
                throw new TokenExpiredException("");
            }
        } else {
            return true;
        }

    }

    /**
     * 请求处理之后进行调用，但是在视图被渲染之前（Controller方法调用之后）
     *
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {

    }

    /**
     * 在整个请求结束之后被调用，也就是在DispatcherServlet 渲染了对应的视图之后执行（主要是用于进行资源清理工作）
     *
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)

            throws Exception {

    }
}
