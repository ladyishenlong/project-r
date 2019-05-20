package com.ladyishenlong.rprojectzuul.service;

import com.ladyishenlong.rprojectzuul.model.UserModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author ruanchenhao
 * @Date 2019-05-20 11:53
 */
@FeignClient("r-project-user")//远程的服务名
@RequestMapping("/user")
public interface UserService {

    @GetMapping("/findUserByUsername")
    UserModel findUserByUsername(@RequestParam("username") String username);

}
