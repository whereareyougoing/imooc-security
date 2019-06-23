package com.imooc.web.intersceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 * @author 宋艾衡
 * @date 2019-06-22 20:14
 *
 * 请求过来的时候回先走过滤器，然后在再走拦截器，程序结束的时候，最后走销毁过滤器的方法
 *
 * 过滤器链在请求开始的时候进行一些列处理，然后执行程序的其他方法，包括拦截器等，然后执行过滤器的doFilter，在请求结束的时候进行销毁
 *
 *
 */
@Component
public class TimeInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object handle) throws Exception {
        System.out.println("pre handle");

        System.out.println(((HandlerMethod)handle).getBean().getClass().getName());
        System.out.println(((HandlerMethod)handle).getMethod().getName());

        httpServletRequest.setAttribute("startTime",new Date().getTime());

        // 返回的值会控制后面的方法会不会执行
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

        // 当程序出现异常的时候这个方法就不会被执行，会直接执行afterCompletion

        System.out.println("post handle");
        long start = (long) httpServletRequest.getAttribute("startTime");
        System.out.println("time interceptor 耗时： "+ (new Date().getTime() - start));
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

        // 这个方法不论程序的成功失败都会调用这个方法，成功的时候ex是空，失败的时候异常里会有信息

        // 拦截器不仅能够拦截自定义的控制器，还能拦截spring的控制器，拦截器会拦截所有的控制器，并且在打印了已定义异常的信息之后还会把spring的控制器的异常信息打印一次

        long start = (long) httpServletRequest.getAttribute("startTime");
        System.out.println("time interceptor 耗时： "+ (new Date().getTime() - start));
        System.out.println("after Completion");
        System.out.println("e is : "+ e);
    }
}
