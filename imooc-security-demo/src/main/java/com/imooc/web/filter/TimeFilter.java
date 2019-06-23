package com.imooc.web.filter;


import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;
import java.util.Date;

/**
 * @author 宋艾衡
 * @date 2019-06-22 19:55
 *
 * 自定义的过滤器直接受用@Component注解可以直接加到过滤器链上
 * 如果第三方的过滤器，没有声明到过滤器链上需要使用配置@Configuration 将第三方的过滤器直接注册成一个bean，加到过滤器链上
 *
 * Filter是java定义的，过滤器是不知道请求到那个控制器去处理，因为控制器是spring定义的，过滤器只能做拦截请求的事件，并不能获取到处理的信息
 *
 */

@Component
public class TimeFilter implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("=========================");
        System.out.println("time filter init");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("time filter start");
        long start = new Date().getTime();
        // 这一步是将请求传递下去
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("time filter:"+(new Date().getTime() - start));
        System.out.println("time filter finish");
    }

    @Override
    public void destroy() {
        System.out.println("time filter destroy");
    }
}
