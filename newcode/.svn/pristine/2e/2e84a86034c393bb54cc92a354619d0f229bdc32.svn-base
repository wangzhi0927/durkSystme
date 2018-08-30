package com.dpm.db.freamwork;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfigurer {
    @Bean
    public Docket createRestApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo()).select().apis(RequestHandlerSelectors.basePackage("com.dpm.db"))
                .paths(PathSelectors.any())
                .build();
    }
    private static final String API_TITLE = "基础数据服务";
    private static final String API_DESC = "系统数据调用基础接口服务";
    private ApiInfo apiInfo(){
        return new ApiInfoBuilder().title(API_TITLE)
                .description(API_DESC).termsOfServiceUrl("").version("1.0").build();
    }
}
