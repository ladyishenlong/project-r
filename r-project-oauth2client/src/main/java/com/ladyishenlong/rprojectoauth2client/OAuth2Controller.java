package com.ladyishenlong.rprojectoauth2client;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author ruanchenhao
 * @Date 2019-06-20 16:54
 */
@RestController
public class OAuth2Controller {

    @GetMapping("/welcomeUser")
    @PreAuthorize("hasAuthority('USER')") //权限控制
    public String welcomeUser() {
        return "welcome user";
    }

    @GetMapping("/welcomeAdmin")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String welcomeAdmin() {
        return "welcome admin";
    }
}
