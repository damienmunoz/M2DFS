package com.m2dfs.equipe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class EquipeApplication {

	public static void main(String[] args) {
		SpringApplication.run(EquipeApplication.class, args);
	}

}
