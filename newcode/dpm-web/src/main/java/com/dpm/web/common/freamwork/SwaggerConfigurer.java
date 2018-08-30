package com.dpm.web.common.freamwork;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @ Purpose:API配置
 * @Package Name: com.dpm.web.common.freamwork
 * @Author: liuxiaoxin
 * @Date: 2018/5/4
 */
@Configuration
@EnableSwagger2
@ComponentScan("com.dpm.web")
public class SwaggerConfigurer {
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo()).select().apis(RequestHandlerSelectors.basePackage("com.dpm.web"))
                .paths(PathSelectors.any())
                .build();
    }

    private static final String API_TITLE = "医可视后台管理系统接口服务";
    private static final String API_DESC = "医可视后台管理系统接口服务文档";

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title(API_TITLE)
                .description(API_DESC).termsOfServiceUrl("").version("1.0").build();
    }
}
