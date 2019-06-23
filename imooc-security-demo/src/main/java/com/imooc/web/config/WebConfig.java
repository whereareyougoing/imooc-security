package com.imooc.web.config;

import com.google.common.collect.Lists;
import com.imooc.web.filter.OtherFiler;
import com.imooc.web.intersceptor.TimeInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;

/**
 * @author 宋艾衡
 * @date 2019-06-22 20:07
 *
 * 拦截器生效需要在spring里面加上自定义的bean
 *
 */
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {


    @Autowired
    private TimeInterceptor timeInterceptor;

    @Bean
    public FilterRegistrationBean otherFilter(){

        FilterRegistrationBean registrationBean = new FilterRegistrationBean();

        OtherFiler otherFiler = new OtherFiler();
        registrationBean.setFilter(otherFiler);

        List<String> usrls = Lists.newArrayList();
        // 添加过滤的请求
        usrls.add("/*");
        registrationBean.setUrlPatterns(usrls);

        return registrationBean;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 将自定义的拦截器加到spring里面去
        registry.addInterceptor(timeInterceptor);
    }
}
