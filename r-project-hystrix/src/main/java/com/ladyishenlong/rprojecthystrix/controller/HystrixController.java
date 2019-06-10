package com.ladyishenlong.rprojecthystrix.controller;

import com.ladyishenlong.rprojecthystrix.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author ruanchenhao
 * @Date 2019-06-10 17:19
 */
@RequestMapping("/hystrix")
@RestController
public class HystrixController {

    @Autowired
    private TestService testService;


    @GetMapping("/hello")
    public String hello(){
        return testService.hello();
    }

}
