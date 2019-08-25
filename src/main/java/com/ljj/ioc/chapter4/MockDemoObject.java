package com.ljj.ioc.chapter4;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import java.util.Arrays;
import java.util.List;

public class MockDemoObject {

    private List param1;

    private String[] param2;

    public void setParam1(List param1) {
        this.param1 = param1;
    }

    public void setParam2(String[] param2) {
        this.param2 = param2;
    }

    @Override
    public String toString() {
        return "MockDemoObject{" +
                "param1=" + param1 +
                ", param2=" + Arrays.toString(param2) +
                '}';
    }

    public static void main(String[] args) {
        DefaultListableBeanFactory beanRegistry = new XmlBeanFactory(new ClassPathResource("spring-context.xml"));
        MockDemoObject mockDemoObject = (MockDemoObject) beanRegistry.getBean("mockDemoObject");
        System.out.println(mockDemoObject);

    }
}
