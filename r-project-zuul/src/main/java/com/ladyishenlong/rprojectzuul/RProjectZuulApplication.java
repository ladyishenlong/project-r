package com.ladyishenlong.rprojectzuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.openfeign.EnableFeignClients;

/***
 * 所有测试的功能 放在test1 和 test2之中
 *
 *
 */

@EnableZuulProxy //启用网关路由
@EnableFeignClients //启用调用远程服务
@EnableEurekaClient //注册到注册中心
@SpringBootApplication
@ServletComponentScan("com.ladyishenlong.rprojectzuul.filter") //扫描过滤器所在包
public class RProjectZuulApplication {

    public static void main(String[] args) {
        SpringApplication.run(RProjectZuulApplication.class, args);
    }

}
