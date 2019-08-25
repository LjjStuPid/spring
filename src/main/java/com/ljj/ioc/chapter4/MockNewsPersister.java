package com.ljj.ioc.chapter4;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class MockNewsPersister implements IFXNewsPersister {

    private FXNewBean fxNewBean;

    public void setFxNewBean(FXNewBean fxNewBean) {
        this.fxNewBean = fxNewBean;
    }

    public FXNewBean getFxNewBean() {
        return fxNewBean;
    }

    @Override
    public void persistNews(FXNewBean fxNewBean) {
        System.out.println("persister bean:" + getFxNewBean());
    }

    public void persistNews() {
        System.out.println("persister bean:" + getFxNewBean());
    }

    public static void main(String[] args) {
        BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("spring-context.xml"));
        MockNewsPersister persister = (MockNewsPersister) beanFactory.getBean("mockPersister");
        persister.persistNews();
        persister.persistNews();
    }
}
