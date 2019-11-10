package com.ljj.spring.ioc.chapter2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Author liujj
 * @Description TODO
 * @Date 2019/9/25 15:20
 */
public class Test {

    private final String m = "www";

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.scan("com.ljj.spring.ioc.chapter2");
        applicationContext.refresh();
        UserService userService = (UserService) applicationContext.getBean("userServiceImpl");
        System.out.println(userService);
    }
}
