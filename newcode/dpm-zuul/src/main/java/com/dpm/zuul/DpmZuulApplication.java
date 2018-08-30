package com.dpm.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import com.dpm.zuul.config.PreRequestFilter;

@EnableZuulProxy
@EnableEurekaClient
@SpringBootApplication
public class DpmZuulApplication {

	public static void main(String[] args) {
		SpringApplication.run(DpmZuulApplication.class, args);
		System.out.println("---------启动成功---------");
	}
	
	@Bean
	public PreRequestFilter preRequestFilter() {
	 return new PreRequestFilter();
	}
}
