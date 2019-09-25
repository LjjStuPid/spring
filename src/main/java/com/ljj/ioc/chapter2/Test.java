package com.ljj.ioc.chapter2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.lang.reflect.Field;

/**
 * @Author liujj
 * @Description TODO
 * @Date 2019/9/25 15:20
 */
public class Test {

    private  final String m = "www";

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {

        Test test = new Test();
        Field field = test.getClass().getDeclaredField("m");
        field.setAccessible(true);
        field.set(test,"fdafdasf");
        System.out.println(field);

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.scan("com.ljj.ioc.chapter2");
        applicationContext.refresh();
        UserService userService = (UserService) applicationContext.getBean("userServiceImpl");
        System.out.println(userService);

    }
}
