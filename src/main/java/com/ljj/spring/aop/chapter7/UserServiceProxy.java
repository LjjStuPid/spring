package com.ljj.spring.aop.chapter7;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Author liujj
 * @Description TODO
 * @Date 2020/1/14 10:38
 */
public class UserServiceProxy implements InvocationHandler {

    private UserService userService;

    public UserServiceProxy(UserService userService) {
        this.userService = userService;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("横切逻辑");
        Object result = method.invoke(userService, args);
        return result;
    }
}
