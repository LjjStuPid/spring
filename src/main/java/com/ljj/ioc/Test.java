package com.ljj.ioc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.StringUtils;

import java.util.Arrays;

public class Test {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-context.xml");
        Demo Demo = (Demo) applicationContext.getBean("demo");
        DemoA demoA = (DemoA) applicationContext.getBean("demoA");
        DemoA demoA1 = (DemoA) applicationContext.getBean("demoA");

        String m = "m|df|d";
        String[] strings =m.split("\\|");
        System.out.println(strings.length);
        System.out.println(Arrays.asList(strings));

    }
}
