package com.ljj.spring.ioc.chapter4;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class Foo {

    private BarInterface barInterface;

    public Foo() {
    }

    public Foo(BarInterface barInterface) {
        this.barInterface = barInterface;
    }

    public void setBarInterface(BarInterface barInterface) {
        this.barInterface = barInterface;
    }

    @Override
    public String toString() {
        return "Foo{" +
                "barInterface=" + barInterface +
                '}';
    }

    public static void main(String[] args) {
        BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("spring-context.xml"));
        Foo foo = (Foo) beanFactory.getBean("foo");
        System.out.println(foo);
    }
}
