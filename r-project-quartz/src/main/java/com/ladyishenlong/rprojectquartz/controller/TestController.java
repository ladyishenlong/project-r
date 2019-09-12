package com.ladyishenlong.rprojectquartz.controller;

import com.ladyishenlong.rprojectquartz.jpa.primary.ArticleJpa;
import com.ladyishenlong.rprojectquartz.jpa.quartz.QrtzCronTriggersJpa;
import com.ladyishenlong.rprojectquartz.jpa.quartz.TestJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author ruanchenhao
 * @Date 2019/9/12 4:07 下午
 */
@RestController
public class TestController {

    @Autowired
    private ArticleJpa articleJpa;

    @Autowired
    private QrtzCronTriggersJpa qrtzCronTriggersJpa;

    @Autowired
    private TestJpa testJpa;

    @GetMapping("/test")
    public Object test(){
      return   articleJpa.findAll();
    }

    @GetMapping("/test2")
    public Object test2(){
        return qrtzCronTriggersJpa.findAll();
    }


}
