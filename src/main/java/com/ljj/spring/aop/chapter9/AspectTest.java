package com.ljj.spring.aop.chapter9;

import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Author liujj
 * @Description TODO
 * @Date 2020/1/17 11:04
 */
public class AspectTest {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();
        annotationConfigApplicationContext.scan("com.ljj.spring.aop.chapter9");
        DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator = new DefaultAdvisorAutoProxyCreator();
        defaultAdvisorAutoProxyCreator.setProxyTargetClass(true);
        annotationConfigApplicationContext.re
        annotationConfigApplicationContext.refresh();
        OrderService orderService = (OrderService) annotationConfigApplicationContext.getBean("orderServiceImpl");
        System.out.println(orderService.updateOrder());
    }
}
