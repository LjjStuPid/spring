package com.ljj.ioc;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class Test {

    public static void main(String[] args) {
//        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-context.xml");
//        Demo demo = (Demo) applicationContext.getBean("demo");
//        System.out.println(demo);

        XmlBeanFactory xmlBeanFactory = new XmlBeanFactory(new ClassPathResource("spring-context.xml"));
//        System.out.println(xmlBeanFactory.);


    }
}
