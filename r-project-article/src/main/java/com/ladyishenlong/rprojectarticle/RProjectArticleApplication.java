package com.ladyishenlong.rprojectarticle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 关于文章的服务
 * <p>
 * 主要是 mysql + mybatis
 * 再加上 mongodb 作为缓存
 */
@EnableEurekaClient
@SpringBootApplication
public class RProjectArticleApplication {

    public static void main(String[] args) {
        SpringApplication.run(RProjectArticleApplication.class, args);
    }

}
