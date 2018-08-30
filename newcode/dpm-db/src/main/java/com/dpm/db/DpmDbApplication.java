package com.dpm.db;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableEurekaClient
@ComponentScan
@MapperScan("com.dpm.db")
public class DpmDbApplication {

    public static void main(String[] args) {
        SpringApplication.run(DpmDbApplication.class, args);
        System.out.println("---------启动成功---------");
    }
}
