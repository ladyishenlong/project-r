package com.ladyishenlong.rprojectconfig.mq;

import com.esotericsoftware.minlog.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Author ruanchenhao
 * @Date 2019-06-03 16:26
 */
@Slf4j
@Component
@RabbitListener(queues = "mq-config")
public class MQReceiver {


    @RabbitHandler
    public void process(String msg){
        log.info("接收到mq信息：{}",msg);
    }



}
