package com.imooc.dto;

import com.fasterxml.jackson.annotation.JsonView;
import com.imooc.validator.MyConstraint;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Past;
import java.util.Date;

/**
 * @author 宋艾衡
 * @date 2019-06-08 18:19
 */


public class User {


    public interface UserSimpleView{}
    public interface UserDetailView extends UserSimpleView{}

    private String id;
    /**
     * 这个NotBlank是框架提供的统一校验方法，简单的校验不需要在程序里写过多的重复校验代码
     */
    @MyConstraint(message = "这是一个测试")
    private String username;
    @NotBlank(message = "密码不能为空")
    private String password;
    @Past(message = "生日必须是过去的时间")
    private Date birthday;


    @JsonView(UserSimpleView.class)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 视图控制传给前端的信息，子类可以继承父类的视图信息
     * @return
     */
    @JsonView(UserDetailView.class)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @JsonView(UserSimpleView.class)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getBirthday() {
        return birthday;
    }

    @JsonView(UserSimpleView.class)
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "{"
                + "                        \"username\":\"" + username + "\""
                + ",                         \"password\":\"" + password + "\""
                + "}";
    }
}
