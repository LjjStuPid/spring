package com.ljj;

import com.ljj.ioc.FXNewsProvider;
import com.ljj.ioc.impl.DowJonesNewsListener;
import com.ljj.ioc.impl.DowJonesNewsPersister;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.PropertyValue;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.ConstructorArgumentValues;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * @Author liujj
 * @Description 测试
 * @Date 2019/8/22 10:29
 */

public class Test {
    public static void main(String[] args) {
        DefaultListableBeanFactory beanRegistry = new DefaultListableBeanFactory();
        BeanFactory container = bindViaCode(beanRegistry);
        FXNewsProvider newsProvider = (FXNewsProvider) container.getBean("djNewsProvider");
        newsProvider.getAndPersistNews();
    }

    public static BeanFactory bindViaCode(BeanDefinitionRegistry registry) {
        AbstractBeanDefinition newProvider = new RootBeanDefinition(FXNewsProvider.class);
        AbstractBeanDefinition newListener = new RootBeanDefinition(DowJonesNewsListener.class);
        AbstractBeanDefinition newPersister = new RootBeanDefinition(DowJonesNewsPersister.class);
        // 将bean定义注册到容器中
        registry.registerBeanDefinition("djNewsProvider", newProvider);
        registry.registerBeanDefinition("djListener", newListener);
        registry.registerBeanDefinition("djPersister", newPersister);
//        // 1、可以通过构造方法注入方式
//        ConstructorArgumentValues argValues = new ConstructorArgumentValues();
//        argValues.addIndexedArgumentValue(0, newListener);
//        argValues.addIndexedArgumentValue(1, newPersister);
//        newProvider.setConstructorArgumentValues(argValues);
        // 2、后者通过setter方式注入
        MutablePropertyValues propertyValues = new MutablePropertyValues();
        propertyValues.addPropertyValue(new PropertyValue("newsListener",newListener));
        propertyValues.addPropertyValue(new PropertyValue("newsPersistener",newPersister));
        newProvider.setPropertyValues(propertyValues);
        return (BeanFactory) registry;

    }

    ;
}
