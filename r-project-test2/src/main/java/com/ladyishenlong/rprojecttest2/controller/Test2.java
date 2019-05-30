package com.ladyishenlong.rprojecttest2.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @Author ruanchenhao
 * @Date 2019-05-16 10:31
 */
@RequestMapping("/test")
@RestController
public class Test2 {

    @Value("${testConfig}")
    private String testConfig;

    @GetMapping("/getConfig")
    private String getConfig() {
        return testConfig;
    }


    @GetMapping("hello")
    public String hello() {
        return "这里是 test2";
    }

    @GetMapping("/getSession")
    public String getSession(HttpSession httpSession) {
        return "sessionId2: " + httpSession.getId();
    }


}
