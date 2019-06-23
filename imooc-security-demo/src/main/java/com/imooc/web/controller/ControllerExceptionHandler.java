package com.imooc.web.controller;

import com.google.common.collect.Maps;
import com.imooc.exception.UserNotExitException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Map;

/**
 * @author 宋艾衡
 * @date 2019-06-22 19:14
 */
@ControllerAdvice
public class ControllerExceptionHandler {


    /**
     * 这个注解是拦截异常处理的类在这个方法里去处理
     *
     * 处理的流程：
     * 1.在控制器里面抛出自定义异常
     * 2.通过切面拦截抛出的异常进行处理，抛出的异常会带一个异常的类，所有处理的方法里参数可以放一个异常的类
     * 3.异常处理方法返回处理结果，以json的形式
     *
     * @return
     */
    @ExceptionHandler(UserNotExitException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Map<String, Object> handleUserNotException(UserNotExitException ex) {

        Map<String, Object> result = Maps.newHashMap();
        result.put("id", ex.getId());
        result.put("message", ex.getMessage());
        return result;


    }

}
