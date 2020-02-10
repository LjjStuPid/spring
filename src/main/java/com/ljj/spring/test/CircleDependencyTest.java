package com.ljj.spring.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Author liujj
 * @Description TODO
 * @Date 2020/1/9 14:37
 */
public class CircleDependencyTest {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        ((AnnotationConfigApplicationContext) applicationContext).setAllowCircularReferences(false);
        ((AnnotationConfigApplicationContext) applicationContext).scan("com.ljj.spring.test");
        ((AnnotationConfigApplicationContext) applicationContext).setAllowCircularReferences(false);
        ((AnnotationConfigApplicationContext) applicationContext).refresh();
        OrderService orderService = (OrderService) applicationContext.getBean("orderService");
        System.out.println(orderService);

    }
}
