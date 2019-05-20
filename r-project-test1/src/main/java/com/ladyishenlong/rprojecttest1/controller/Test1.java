package com.ladyishenlong.rprojecttest1.controller;

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
public class Test1 {

    @GetMapping("hello")
    public String hello() {
        return "这里是 test1";
    }





    /**
     * 测试与test2 中共享session
     *
     * @param httpSession
     * @return
     */
    @GetMapping("/getSession")
    public String getSession(HttpSession httpSession) {
        return "sessionId: " + httpSession.getId();
    }

}
