package com.imooc.validator;

import com.imooc.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author 宋艾衡
 * @date 2019-06-09 18:27
 *
 * 这个类不用加Component注解，因为实现了接口
 *
 */
public class MyConstraintValidator implements ConstraintValidator<MyConstraint,Object> {


    @Autowired
    private HelloService helloService;


    @Override
    public void initialize(MyConstraint myConstraint) {
        System.out.println("my validator init");

    }

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        helloService.greeting("tom");
        System.out.println(o);
        return false;
    }
}
