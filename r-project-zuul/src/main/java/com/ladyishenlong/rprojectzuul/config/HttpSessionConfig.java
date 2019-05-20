package com.ladyishenlong.rprojectzuul.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.session.data.redis.RedisFlushMode;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * @Author ruanchenhao
 * @Date 2019-05-16 10:30
 *
 * 使用redis 保存 共享session
 * 可能可以实现网关之间共享session
 */
@EnableRedisHttpSession (redisFlushMode = RedisFlushMode.IMMEDIATE)
public class HttpSessionConfig {

//    @Bean
//    public JedisConnectionFactory connectionFactory() {
//        return new JedisConnectionFactory();
//    }

}
