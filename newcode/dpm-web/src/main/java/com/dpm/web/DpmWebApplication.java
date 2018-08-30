package com.dpm.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableFeignClients
@EnableEurekaClient
@ComponentScan(basePackages = "com.dpm")
public class DpmWebApplication {
    public static void main(String[] args) {
        SpringApplication.run(DpmWebApplication.class, args);
        System.out.println("---------启动成功---------");
    }
}
