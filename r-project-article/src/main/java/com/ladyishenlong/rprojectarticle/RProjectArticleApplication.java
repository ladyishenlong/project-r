package com.ladyishenlong.rprojectarticle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * 关于文章的服务 主要是用来练习数据库的操作
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
