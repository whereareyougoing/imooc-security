package com.imooc.web.aspect;

import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * @author 宋艾衡
 * @date 2019-06-23 23:21
 */
@Aspect
@Component
public class TimeAspect {


    @Around("excution(* com.imooc.web.controller.UserController.*)")


}
