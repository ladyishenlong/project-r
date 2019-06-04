package com.ladyishenlong.rprojectconfig.mq;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author ruanchenhao
 * @Date 2019-06-03 16:28
 */
@Configuration
public class MQConfig {

    @Bean
    public Queue helloQueue(){
        return new Queue("mq-config");
    }

}
