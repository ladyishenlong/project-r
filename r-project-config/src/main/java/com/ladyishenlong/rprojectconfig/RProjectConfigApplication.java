package com.ladyishenlong.rprojectconfig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * spring cloud config 远程配置服务端
 *
 * 暂时未搭建成功
 */
@EnableEurekaClient
@EnableConfigServer
@SpringBootApplication
public class RProjectConfigApplication {

    public static void main(String[] args) {
        SpringApplication.run(RProjectConfigApplication.class, args);
    }

}
