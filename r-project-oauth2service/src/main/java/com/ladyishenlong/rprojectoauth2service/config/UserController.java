package com.ladyishenlong.rprojectoauth2service.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * @Author ruanchenhao
 * @Date 2019-06-21 09:00
 */
@RestController
public class UserController {

    @GetMapping("/user")
    public Principal user(Principal principal) {
        return principal;
    }

}
