package com.ljj.ioc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-context.xml");
        Demo Demo = (Demo) applicationContext.getBean("demo");
        DemoA demoA = (DemoA) applicationContext.getBean("demoA");

    }
}
