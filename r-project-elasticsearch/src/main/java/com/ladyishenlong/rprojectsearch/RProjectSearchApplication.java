package com.ladyishenlong.rprojectsearch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * elasticsearch 的连接和使用
 */
@EnableEurekaClient
@SpringBootApplication
public class RProjectSearchApplication {

    public static void main(String[] args) {
        SpringApplication.run(RProjectSearchApplication.class, args);
    }

}
