package com.ljj.aop.chapter10;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author liujj
 * @Description TODO
 * @Date 2019/9/9 18:24
 */
public class AnnotationAwareAspectJAutoProxyCreatorTest {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-context.xml");
        Foo foo = (Foo) applicationContext.getBean("target");
        foo.method1();
    }
}
