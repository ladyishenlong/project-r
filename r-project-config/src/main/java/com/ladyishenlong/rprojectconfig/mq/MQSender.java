package com.ladyishenlong.rprojectconfig.mq;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author ruanchenhao
 * @Date 2019-06-03 16:02
 * <p>
 * 参考 https://blog.csdn.net/qq_37598011/article/details/82943316
 */
@Component
public class MQSender {

    @Autowired
    private AmqpTemplate amqpTemplate;

    public void send() {
        amqpTemplate.convertAndSend("mq-config","通过mq传送信息");
    }


}
