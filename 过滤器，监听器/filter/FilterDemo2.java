package com.hqyj.web.filter;

import javax.servlet.*;
import java.io.IOException;

//@WebFilter("/*")
public class FilterDemo2 implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        //对request请求消息的增强
        System.out.println("demo2执行了");
        chain.doFilter(req, resp);
        //对response响应消息的增强
        System.out.println("demo2回来了");
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
