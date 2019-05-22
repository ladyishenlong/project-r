package com.ladyishenlong.rprojectzuul.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.session.data.redis.RedisFlushMode;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.session.web.http.CookieHttpSessionIdResolver;
import org.springframework.session.web.http.HeaderHttpSessionIdResolver;

/**
 * @Author ruanchenhao
 * @Date 2019-05-16 10:30
 * <p>
 * 使用redis 保存 共享session
 * 可能可以实现网关之间共享session
 * 网关重启之后session 依然可用，在缓存中重启之后会清空
 */
@EnableRedisHttpSession(redisFlushMode = RedisFlushMode.IMMEDIATE)
public class HttpSessionConfig {

//    @Bean
//    public JedisConnectionFactory connectionFactory() {
//        return new JedisConnectionFactory();
//    }

    /**
     * 允许cookie请求方式
     * todo 有待测试
     *
     * @return
     */
    public CookieHttpSessionIdResolver cookieHttpSessionIdResolver() {
        return new CookieHttpSessionIdResolver();
    }

    /**
     * 允许header 里面添加session 验证登录请求
     * key 为x-auth-token
     * @return
     */
    @Bean
    public HeaderHttpSessionIdResolver httpSessionStrategy() {
        return new HeaderHttpSessionIdResolver("x-auth-token");
    }


}
