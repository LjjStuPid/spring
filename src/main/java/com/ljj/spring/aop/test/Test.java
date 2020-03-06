package com.ljj.spring.aop.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();
        annotationConfigApplicationContext.register(org.springframework.aop.aspectj.autoproxy.AspectJAwareAdvisorAutoProxyCreator.class);
        annotationConfigApplicationContext.scan("com.ljj.spring.aop.test");
        annotationConfigApplicationContext.refresh();

        UserService userService = (UserService) annotationConfigApplicationContext.getBean("userServiceImpl");
        userService.work();
    }
}
