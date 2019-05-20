package com.ladyishenlong.rprojectzuul.security;

import com.ladyishenlong.rprojectzuul.config.HttpSessionConfig;
import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

/**
 * @Author ruanchenhao
 * @Date 2019-05-16 11:47
 */
public class SecurityInitializer extends AbstractSecurityWebApplicationInitializer {

    public SecurityInitializer() {
        super(SecurityConfig.class, HttpSessionConfig.class);
    }

}