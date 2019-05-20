package com.ladyishenlong.rprojectuser.service.impl;

import com.ladyishenlong.rprojectuser.service.mapper.UserMapper;
import com.ladyishenlong.rprojectuser.model.UserModel;
import com.ladyishenlong.rprojectuser.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @Author ruanchenhao
 * @Date 2019-05-20 11:39
 * <p>
 * 注解设置缓存
 * 参考 https://www.jianshu.com/p/970335a3f576
 */
@Service
public class UserImpl implements UserService {


    @Autowired
    private UserMapper userMapper;

    @Cacheable(cacheNames = "user", key = "#username")
    @Override
    public UserModel findUserByUsername(String username) {
        return userMapper.findByUsername(username);
    }


}
