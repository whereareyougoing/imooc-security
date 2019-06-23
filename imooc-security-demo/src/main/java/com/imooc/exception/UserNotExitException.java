package com.imooc.exception;

/**
 * @author 宋艾衡
 * @date 2019-06-22 19:06
 */
public class UserNotExitException extends RuntimeException {


    private static final long serialVersionUID = 3899372000363290670L;

    private String id;

    public UserNotExitException(String id){
        super("用户不存在 exception");
        this.id = id;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
