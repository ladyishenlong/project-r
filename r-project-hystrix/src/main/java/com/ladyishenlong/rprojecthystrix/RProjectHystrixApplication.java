package com.ladyishenlong.rprojecthystrix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 尝试熔断器的使用
 */

@EnableEurekaClient
@SpringBootApplication
public class RProjectHystrixApplication {

    public static void main(String[] args) {
        SpringApplication.run(RProjectHystrixApplication.class, args);
    }

}
