package com.ladyishenlong.rprojectdocker.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author ruanchenhao
 * @Date 2019-06-03 08:39
 */
@RestController
@ResponseBody
public class DockerController {

    @GetMapping("/docker")
    public String docker(){
        return "docker 项目 已经启动";
    }

}
