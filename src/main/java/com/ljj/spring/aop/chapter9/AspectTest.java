package com.ljj.spring.aop.chapter9;

import org.springframework.aop.aspectj.annotation.AnnotationAwareAspectJAutoProxyCreator;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
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

        BeanDefinition beanDefinition = new RootBeanDefinition(AnnotationAwareAspectJAutoProxyCreator.class);
        beanDefinition.getPropertyValues().add("exposeProxy", true);

        annotationConfigApplicationContext.registerBeanDefinition("mccdas", beanDefinition);
//        annotationConfigApplicationContext.getBeanDefinition()
        annotationConfigApplicationContext.refresh();


        OrderService bean = (OrderService) annotationConfigApplicationContext.getBean("orderServiceImpl");
        System.out.println(bean);
        System.out.println(bean.updateOrder());
    }
}
