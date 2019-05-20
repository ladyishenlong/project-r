package com.ladyishenlong.rprojectzuul.filter;


import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @Author ruanchenhao
 * @Date 2019-05-20 13:19
 *
 * 计算接口耗时
 */
@Slf4j
@WebFilter(filterName = "TimeCalFilter", urlPatterns = "/*")
public class TimeCalFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        long startTime = System.currentTimeMillis();
        chain.doFilter(request, response);
        long endTime = System.currentTimeMillis();

        log.info("--------------------------------------------------");
        log.info("{} 请求耗时：{} ms",
                httpServletRequest.getRequestURL(), endTime - startTime);
        log.info("--------------------------------------------------");
    }

    @Override
    public void destroy() {

    }
}

