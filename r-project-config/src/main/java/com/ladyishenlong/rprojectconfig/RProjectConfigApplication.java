package com.ladyishenlong.rprojectconfig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * spring cloud config 远程配置服务端
 * 配置服务中心
 * <p>
 * 参考 https://www.cnblogs.com/wslook/p/9994915.html
 * 作为其他服务读取配置信息的服务
 * 使用spring cloud bus 作为消息总线更新配置信息，手动访问/actuator/bus-refresh刷新配置
 * client 端需要添加spring cloud bus 的依赖
 * 这里是用的是rabbit mq的消息队列
 */
@EnableEurekaClient
@EnableConfigServer
@SpringBootApplication
public class RProjectConfigApplication {

    public static void main(String[] args) {
        SpringApplication.run(RProjectConfigApplication.class, args);
    }

}
