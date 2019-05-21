package com.ladyishenlong.projectr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * project r
 */
@EnableEurekaServer
@SpringBootApplication
public class ProjectRApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProjectRApplication.class, args);
    }

}
