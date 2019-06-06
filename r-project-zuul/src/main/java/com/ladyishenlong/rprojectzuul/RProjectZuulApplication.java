package com.ladyishenlong.rprojectzuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.openfeign.EnableFeignClients;

/***
 * 所有测试的功能 放在test1 和 test2之中
 * 所有服务全部注册到注册中心
 *
 * 1. 使用zuul 作为网关代理服务
 * 2. 使用feign 调用user服务获取用户信息
 * 3. spring security 负责登录和验证
 *
 *
 * 控制反转：从原本的请求者充当控制着变成由容器变成了控制者
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
