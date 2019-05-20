package com.ladyishenlong.projectr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * project R
 *
 * r-project- 后台服务
 * r-web-  前端页面
 *
 */

@EnableEurekaServer
@SpringBootApplication
public class ProjectRApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProjectRApplication.class, args);
    }

}
