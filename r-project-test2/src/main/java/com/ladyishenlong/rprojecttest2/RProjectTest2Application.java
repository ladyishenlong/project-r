package com.ladyishenlong.rprojecttest2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.FeignClient;


@FeignClient
@EnableEurekaClient
@SpringBootApplication
public class RProjectTest2Application {

    public static void main(String[] args) {
        SpringApplication.run(RProjectTest2Application.class, args);
    }

}
