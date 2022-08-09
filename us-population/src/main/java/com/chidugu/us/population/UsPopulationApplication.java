package com.chidugu.us.population;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableEurekaClient
@ComponentScan(basePackages = "com.chidugu.rest.controller")
public class UsPopulationApplication {

	public static void main(String[] args) {
		SpringApplication.run(UsPopulationApplication.class, args);
	}

}
