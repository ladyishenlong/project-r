package com.ladyishenlong.rprojectoauth2service.secutiry;

import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.cors.CorsUtils;

/**
 * @Author ruanchenhao
 * @Date 2019-06-20 15:30
 */
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .headers().and()
                .cors()
                .and().authorizeRequests()
                .antMatchers("/login**").permitAll()//对登录请求放行
                .antMatchers("/oauth**").permitAll()//对认证请求放行
                .anyRequest().authenticated()//其余的都需要验证
                .and()
                .formLogin();
    }


}
