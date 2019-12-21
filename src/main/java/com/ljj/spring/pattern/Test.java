package com.ljj.spring.pattern;

import java.lang.reflect.Proxy;

public class Test {


    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        UserServiceProxy userServiceProxy = new UserServiceProxy(userService);
        UserService userService1 = (UserService) Proxy.newProxyInstance(userService.getClass().getClassLoader(), userService.getClass().getInterfaces(),
                new UserServiceProxy(userService));
        userService1.say("Fdsaf");

    }
}
