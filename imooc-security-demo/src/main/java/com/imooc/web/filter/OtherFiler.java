package com.imooc.web.filter;

import javax.servlet.*;
import java.io.IOException;
import java.util.Date;

/**
 * @author 宋艾衡
 * @date 2019-06-22 20:04
 *
 * 模拟一个第三方的filter
 *
 *
 */
public class OtherFiler implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("=========================");
        System.out.println("other filter init");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("other filter start");
        long start = new Date().getTime();
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("other filter:"+(new Date().getTime() - start));
        System.out.println("other filter finish");
    }

    @Override
    public void destroy() {
        System.out.println("other filter destroy");
    }
}
