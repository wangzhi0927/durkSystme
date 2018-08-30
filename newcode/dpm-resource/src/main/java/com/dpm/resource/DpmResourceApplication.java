package com.dpm.resource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class DpmResourceApplication {

    public static void main(String[] args) {
        SpringApplication.run(DpmResourceApplication.class, args);
        System.out.println("---------启动成功---------");
    }
}
