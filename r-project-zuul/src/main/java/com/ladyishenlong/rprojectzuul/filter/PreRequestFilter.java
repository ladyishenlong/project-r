package com.ladyishenlong.rprojectzuul.filter;

/**
 * @Author ruanchenhao
 * @Date 2019-05-16 16:09
 */

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * 经过zuul请求时, zuul进行session的转发
 *
 * @author langpf 2018/12/21
 */
@Slf4j
@Configuration
public class PreRequestFilter extends ZuulFilter {


    /**
     * 1、pre：请求在路由之前被调用,如:身份验证；
     * 2、route：请求在路由时被调用；
     * 3、post：路由到微服务之后执行(在route和error过滤器之后被调用)；
     * 4、error：处理请求发生错误时被调用；
     *
     * @return
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * 返回一个值来指定过滤器的执行顺序，不同过滤器允许返回相同的数字，数字越小顺序越靠前
     */
    @Override
    public int filterOrder() {
        return 1;
    }

    /**
     * 返回一个boolean值来判断该过滤器是否要执行，true：执行，false：不执行
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 过滤器的具体逻辑
     */
    @Override
    public Object run() {
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        log.info("--------------------------------------------------");
        log.info("请求的用户名：{}", auth.getName());
        log.info("请求地址：{}", request.getRequestURL());
        log.info("sessionId: {}",request.getSession().getId());
        log.info("--------------------------------------------------");
        requestContext.addZuulRequestHeader("username",auth.getName());
        return null;
    }
}

