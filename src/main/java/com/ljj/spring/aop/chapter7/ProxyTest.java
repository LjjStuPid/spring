package com.ljj.spring.aop.chapter7;

import java.lang.reflect.Proxy;

/**
 * @Author liujj
 * @Description TODO
 * @Date 2020/1/14 10:40
 */
public class ProxyTest {

    public static void main(String[] args) {

        UserService userService = new UserServiceImpl();

        UserServiceProxy userServiceProxy = new UserServiceProxy(userService);

        UserService userService1 = (UserService) Proxy.newProxyInstance(UserService.class.getClassLoader(), new Class[]{UserService.class}, userServiceProxy);

        userService1.updateUser();

    }
}
