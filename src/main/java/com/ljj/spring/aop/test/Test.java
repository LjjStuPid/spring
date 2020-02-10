package com.ljj.spring.aop.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();
        annotationConfigApplicationContext.scan("com.ljj.spring.aop.test");
        annotationConfigApplicationContext.refresh();


        String[] strings = annotationConfigApplicationContext.getBeanDefinitionNames();
        for (String s : strings) {
            System.out.println(s);
        }

        UserService userService = (UserService) annotationConfigApplicationContext.getBean("userServiceImpl");
        userService.work();
        System.out.println(userService);


    }
}
