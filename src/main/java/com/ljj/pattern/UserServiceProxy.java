package com.ljj.pattern;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class UserServiceProxy implements InvocationHandler {

    private Object target;

    public UserServiceProxy(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("代理类");
        return method.invoke(target, args);
    }
}
