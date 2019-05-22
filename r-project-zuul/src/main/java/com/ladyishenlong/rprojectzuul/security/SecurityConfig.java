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
                .antMatchers("/test/test/hello").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginProcessingUrl("/user/login")
                .successHandler(new SuccessHandler()).and()

//                .exceptionHandling()
//                .authenticationEntryPoint(
//                        new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED))

//                .and()
                .rememberMe()
                .and().csrf().disable();//关闭csrf
    }


}
