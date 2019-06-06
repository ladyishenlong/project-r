package com.ladyishenlong.rprojectconsul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * consul 代替 eureka 作为注册中心
 *
 *
 */
@EnableDiscoveryClient
@SpringBootApplication
public class RProjectConsulApplication {

	public static void main(String[] args) {
		SpringApplication.run(RProjectConsulApplication.class, args);
	}

}
