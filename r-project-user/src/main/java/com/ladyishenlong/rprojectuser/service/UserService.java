package com.ladyishenlong.rprojectuser.service;

import com.ladyishenlong.rprojectuser.model.UserModel;

/**
 * @Author ruanchenhao
 * @Date 2019-05-20 11:38
 */
public interface UserService {

    UserModel findUserByUsername(String username);

}
