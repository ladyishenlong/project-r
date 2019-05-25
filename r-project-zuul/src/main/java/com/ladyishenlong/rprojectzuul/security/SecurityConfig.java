package com.ladyishenlong.rprojectzuul.security;

import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;
import org.springframework.web.cors.CorsUtils;

/**
 * @Author ruanchenhao
 * @Date 2019-05-16 11:41
 */
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .headers().and()
                .cors()
                .and().authorizeRequests()
                .requestMatchers(CorsUtils::isPreFlightRequest).permitAll()//对preflight放行
//                .antMatchers("/article/**").permitAll()
//                .antMatchers("/test/test/hello").permitAll()
                .antMatchers("/user/login").permitAll()
                .anyRequest().authenticated()
                .and()


                .formLogin()
                .loginProcessingUrl("/user/login")


                .successHandler(new SuccessHandler()).and()


                //要是没有登录，抛出401异常
                .exceptionHandling()
                .authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED))
                .and()

                .rememberMe()

                //关闭csrf，如果不关闭可能导致post请求无效
                //放跨域请求，如果不关闭需要添加csrf隐藏域
                .and().csrf().disable()

                //第一个用户登录之后，同样的账号无法登录其他设备
                //TODO 后登陆的顶掉前一个登陆的
                .sessionManagement()
                .maximumSessions(1)
                .expiredUrl("/user/login")

        ;
    }


}
