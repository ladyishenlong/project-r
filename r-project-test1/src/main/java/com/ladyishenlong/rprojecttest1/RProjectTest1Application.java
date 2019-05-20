package com.ladyishenlong.rprojecttest1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@EnableElasticsearchRepositories
@FeignClient
@EnableEurekaClient
@SpringBootApplication
public class RProjectTest1Application {

    public static void main(String[] args) {
//        System.setProperty("es.set.netty.runtime.available.processors", "false");
        SpringApplication.run(RProjectTest1Application.class, args);
    }

}
