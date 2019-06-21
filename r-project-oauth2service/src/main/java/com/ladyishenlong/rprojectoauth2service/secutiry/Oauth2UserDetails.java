//package com.ladyishenlong.rprojectoauth2service.secutiry;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.authority.AuthorityUtils;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.factory.PasswordEncoderFactories;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Component;
//
//import javax.annotation.Resource;
//
///**
// * @Author ruanchenhao
// * @Date 2019-06-20 14:15
// */
//
//@Component
//public class Oauth2UserDetails implements UserDetailsService {
//
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
//        return new User(username, encoder.encode("123"),
//                AuthorityUtils.commaSeparatedStringToAuthorityList("USER"));
//    }
//
//
//}
