package com.ladyishenlong.rprojectoauth2client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 参考地址 https://kefeng.wang/2018/04/06/oauth2-sso/
 * 单点登录的服务端
 */
@EnableEurekaClient
@SpringBootApplication
public class RProjectOauth2clientApplication {

    public static void main(String[] args) {
        SpringApplication.run(RProjectOauth2clientApplication.class, args);
    }

}
