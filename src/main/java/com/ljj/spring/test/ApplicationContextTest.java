package com.ljj.spring.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationContextTest {

    public static void main(String[] args) {


        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-context.xml");
        Object object = applicationContext.getBean("dateFoo");
        System.out.println(object);
    }
}
