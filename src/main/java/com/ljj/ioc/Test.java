package com.ljj.ioc;

import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class Test {

    public static void main(String[] args) {
//        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-context.xml");
//        Demo demo = (Demo) applicationContext.getBean("demo");
//        System.out.println(demo);

        XmlBeanFactory xmlBeanFactory = new XmlBeanFactory(new ClassPathResource("spring-context.xml"));
        BeanPostProcessor beanPostProcessor = new BeanPostProcessorDemo();
        xmlBeanFactory.addBeanPostProcessor(beanPostProcessor);
        Demo demo = (Demo) xmlBeanFactory.getBean("demo");
//        System.out.println(demo.getClass());
//        System.out.println(xmlBeanFactory.);


    }
}
