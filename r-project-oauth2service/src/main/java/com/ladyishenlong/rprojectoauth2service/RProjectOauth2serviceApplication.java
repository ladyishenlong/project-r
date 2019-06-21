package com.ladyishenlong.rprojectoauth2service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

/**
 * 授权服务 oauth2
 * 授权服务请求地址：/oauth/authorize
 * 服务访问令牌请求地址：/oauth/token
 */
@EnableEurekaClient
//@EnableResourceServer // 启用资源服务器,代表受保护的服务,可以和授权服务分开
@SpringBootApplication
public class RProjectOauth2serviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(RProjectOauth2serviceApplication.class, args);
    }

}
