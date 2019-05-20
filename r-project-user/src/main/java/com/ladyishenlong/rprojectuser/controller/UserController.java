package com.ladyishenlong.rprojectuser.controller;

import com.ladyishenlong.rprojectuser.mapper.UserMapper;
import com.ladyishenlong.rprojectuser.model.UserModel;
import io.netty.util.internal.SuppressJava6Requirement;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author ruanchenhao
 * @Date 2019-05-20 09:57
 * <p>
 * 用户的查询，保存等操作
 * 用mongodb 作为缓存
 */
@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RedisTemplate redisTemplate;



    /**
     * 获取用户信息的，以redis作为缓存工具
     *
     * @param username
     * @return
     */
    @GetMapping("/findUserByUsername")
    public UserModel findUserByUsername(@RequestParam("username") String username) {
        ValueOperations<String, UserModel> operations = redisTemplate.opsForValue();

        UserModel userModel;
        if (redisTemplate.hasKey(username)) {
            log.info("---- redis 存在该用户：{} ----", username);
            userModel = operations.get(username);
        } else {
            log.info("---- redis 不存在用户：{} ----", username);
            userModel = userMapper.findByUsername(username);
            if (userModel != null) {
                operations.set(username, userModel);
            }
        }
        return userModel;
    }


}
