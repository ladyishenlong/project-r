package com.ladyishenlong.rprojectzuul.security;

import com.ladyishenlong.rprojectzuul.model.UserModel;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

/**
 * @Author ruanchenhao
 * @Date 2019-05-16 11:44
 * <p>
 * 控制用户登录 连接数据库作比较
 */
@Component
public class SecurityUserDetails implements UserDetailsService {


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {


        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

        UserModel userModel = new UserModel();
        userModel.setUsername("123");
        userModel.setPassword("123");
        userModel.setRoles("123");


        List<GrantedAuthority> authorities = Collections.singletonList(
                new SimpleGrantedAuthority(userModel.getRoles()));

        return new User(userModel.getUsername(),
                encoder.encode(userModel.getPassword()),
                authorities);
    }


}
