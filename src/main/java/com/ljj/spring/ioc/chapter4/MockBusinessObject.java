package com.ljj.spring.ioc.chapter4;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MockBusinessObject {

    private String dependency1;

    private int dependency2;


    public MockBusinessObject() {
    }

    public MockBusinessObject(String dependency1, int dependency2) {
        this.dependency1 = dependency1;
        this.dependency2 = dependency2;
    }

    public MockBusinessObject(String dependency1) {
        this.dependency1 = dependency1;
    }

    public MockBusinessObject(int dependency2) {
        this.dependency2 = dependency2;
    }

    public void setDependency1(String dependency1) {
        this.dependency1 = dependency1;
    }

    @Override
    public String toString() {
        return "MockBusinessObject{" +
                "dependency1='" + dependency1 + '\'' +
                ", dependency2=" + dependency2 +
                '}';
    }

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-context.xml");
        MockBusinessObject mockBusinessObject = (MockBusinessObject) applicationContext.getBean("mockBO");
        System.out.println(mockBusinessObject);
    }
}
