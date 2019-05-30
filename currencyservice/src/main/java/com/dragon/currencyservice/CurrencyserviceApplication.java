package com.dragon.currencyservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
@EnableFeignClients("com.dragon.currencyservice.feign")
@EnableDiscoveryClient
@EnableEurekaClient
public class CurrencyserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CurrencyserviceApplication.class, args);
	}
	@RequestMapping
	  public String helloWorld() {
	     return "Hello World";
	  }

}
