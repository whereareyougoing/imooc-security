package com.imooc.web.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.google.common.collect.Lists;
import com.imooc.dto.User;
import com.imooc.dto.UserQueryCondition;
import com.imooc.exception.UserNotExitException;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @author 宋艾衡
 * @date 2019-06-08 18:18
 */

@RestController
@RequestMapping("/user")
public class UserController {


    /**
     * RequestBody 这个注解将请求装换成json
     *
     * 时间类型最好使用时间戳的形式，因为app和web前端都可以处理时间戳，固定的时间格式不一定都能够被处理
     *
     * Valid注解，声明方法按照实体里的注解校验参数
     *
     * BindingResult  这个可以绑定Valid校验的所有信息，不会出现错误，但是能够将错误打印出来
     *
     * @param user
     * @return
     */
    @PostMapping
    @JsonView(User.UserSimpleView.class)
    public User create(@Valid @RequestBody User user, BindingResult errors){

        if (errors.hasErrors()) {
            errors.getAllErrors().stream().forEach(error-> System.out.println(error.getDefaultMessage()));
        }

        System.out.println(user.getId());
        System.out.println(user.getUsername());
        System.out.println(user.getPassword());
        System.out.println(user.getBirthday());

        user.setId("1");
        return user;
    }

    @PutMapping("/update/{id:\\d+}")
    public User update(@Valid @RequestBody User user, BindingResult errors) {

        if (errors.hasErrors()) {
            errors.getAllErrors().stream().forEach(error->{
                System.out.println(error.getDefaultMessage());
            });
        }


        System.out.println(user.getId());
        System.out.println(user.getUsername());
        System.out.println(user.getPassword());
        System.out.println(user.getBirthday());

        user.setId("1");
        return user;
    }


    @DeleteMapping("/delete/{id:\\d+}")
    public void delete(@PathVariable String id){
        System.out.println(id);
    }


    @GetMapping
    @JsonView(User.UserSimpleView.class)
    public List<User> query(@RequestParam(required = false,name = "condition") UserQueryCondition condition,
                            Pageable pageable){

        System.out.println(ReflectionToStringBuilder.toString(condition, ToStringStyle.MULTI_LINE_STYLE));

        System.out.println(pageable.getPageNumber());
        System.out.println(pageable.getPageSize());
        System.out.println(pageable.getSort());

        List<User> users = Lists.newArrayList();
        users.add(new User());
        users.add(new User());
        users.add(new User());
        return users;
    }


    @GetMapping(value = "/{id:\\d+}")
    @JsonView(User.UserDetailView.class)
    public User getInfo(@PathVariable(name = "id") String id){

        System.out.println("获取用户信息");
        User user = new User();
        user.setUsername("tom");
        return user;
    }


    /**
     * 自定义异常处理，json返回
     * @param id
     * @return
     */
    @GetMapping(value = "/getUserInfo/{id:\\d+}")
    @JsonView(User.UserDetailView.class)
    public User getUserInfo(@PathVariable(name = "id") String id){
        throw  new UserNotExitException(id);
    }

    /**
     * 浏览器默认的异常处理
     * 直接跳转到自定义的错误页面
     * @param id
     * @return
     */
    @GetMapping(value = "/getUserInfo1/{id:\\d+}")
    @JsonView(User.UserDetailView.class)
    public User getUserInfo1(@PathVariable(name = "id") String id){
        throw  new RuntimeException("获取用户信息异常");
    }


    /**
     * 被切面处理的异常，异常是不会传到拦截器里面的
     *
     * 抛一个拦截器处理的异常
     * @param id
     * @return
     */
    @GetMapping(value = "/getUserInfo2/{id:\\d+}")
    @JsonView(User.UserDetailView.class)
    public User getUserInfo2(@PathVariable(name = "id") String id){
        System.out.println("获取用户信息");
        throw  new RuntimeException("获取用户信息异常");
    }


}
