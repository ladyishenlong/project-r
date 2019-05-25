package com.ladyishenlong.rprojectsqls;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 多数据源服务 连接两个以上的数据库
 *
 */
@EnableEurekaClient
@SpringBootApplication
public class RProjectSqlsApplication {

    public static void main(String[] args) {
        SpringApplication.run(RProjectSqlsApplication.class, args);
    }

}
