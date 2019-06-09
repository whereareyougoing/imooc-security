package com.imooc.service.impl;

import com.imooc.service.HelloService;
import org.springframework.stereotype.Service;

/**
 * @author 宋艾衡
 * @date 2019-06-09 18:31
 */

@Service
public class HelloServiceImpl implements HelloService {

    public void greeting(String s){
        System.out.println("greeting"+" "+s);
    }

}
