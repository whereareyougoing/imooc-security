package com.imooc.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author 宋艾衡
 * @date 2019-06-09 18:25
 */

@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = MyConstraintValidator.class)
public @interface MyConstraint {

    /**
     * 这三个属性是声明自定义校验器必须有的属性
     * @return
     */

    String message();

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};


}
