package com.ladyishenlong.rprojectzuul.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Author ruanchenhao
 * @Date 2019-05-22 09:07
 * <p>
 * 登录成功之后进行的操作
 */
public class SuccessHandler implements AuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {

        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json;charset=utf-8");

        //返回sessionId 用来验证登录请求
        PrintWriter writer = response.getWriter();
        writer.println(request.getSession().getId());
        writer.close();
    }
}
