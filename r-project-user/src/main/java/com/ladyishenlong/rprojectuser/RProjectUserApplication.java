package com.ladyishenlong.rprojectuser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class RProjectUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(RProjectUserApplication.class, args);
    }

}
