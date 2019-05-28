package com.ladyishenlong.rprojectzuul.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;
import org.springframework.security.web.session.ConcurrentSessionFilter;
import org.springframework.web.cors.CorsUtils;

import javax.annotation.Resource;

/**
 * @Author ruanchenhao
 * @Date 2019-05-16 11:41
 *
 * 单一登录参考：https://blog.csdn.net/bandancer/article/details/84922015
 */
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Resource
    private SessionRegistry sessionRegistry;

    @Bean
    public SessionRegistry sessionRegistry() {
        return new SessionRegistryImpl();
    }


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


                //登录成功返回sessionId
                .successHandler(new SuccessHandler())
                .and()

                //要是没有登录，抛出401异常
                .exceptionHandling()
                .authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED))
                .and()
                .rememberMe().and()

                //关闭csrf，如果不关闭可能导致post请求无效
                //放跨域请求，如果不关闭需要添加csrf隐藏域
                .csrf().disable()

                //第一个用户登录之后，同样的账号无法登录其他设备
                .sessionManagement()
                .maximumSessions(1)

                //这句配置实现同样用户名登陆之后，之前的用户session过期
                .sessionRegistry(sessionRegistry)

//                .expiredUrl("/user/login")
        ;
    }


}
