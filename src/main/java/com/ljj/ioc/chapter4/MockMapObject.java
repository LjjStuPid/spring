package com.ljj.ioc.chapter4;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import java.util.Map;

public class MockMapObject {

    private Map mapping;

    public void setMapping(Map mapping) {
        this.mapping = mapping;
    }

    @Override
    public String toString() {
        return "MockMapObject{" +
                "mapping=" + mapping +
                '}';
    }

    public static void main(String[] args) {
        DefaultListableBeanFactory beanRegistry = new XmlBeanFactory(new ClassPathResource("spring-context.xml"));
        MockMapObject mockMapObject = (MockMapObject) beanRegistry.getBean("mockMapObject");
        System.out.println(mockMapObject);
    }
}
