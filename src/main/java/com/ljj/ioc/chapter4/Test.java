package com.ljj.ioc.chapter4;

import com.ljj.ioc.chapter4.FXNewsProvider;
import com.ljj.ioc.chapter4.impl.DowJonesNewsListener;
import com.ljj.ioc.chapter4.impl.DowJonesNewsPersister;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.PropertyValue;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author liujj
 * @Description 测试
 * @Date 2019/8/22 10:29
 */

public class Test {
    public static void main(String[] args) {
//        DefaultListableBeanFactory beanRegistry = new DefaultListableBeanFactory();
////        BeanFactory container = bindViaCode(beanRegistry);
//        BeanFactory container = bindViaXMLFile(beanRegistry);
//        FXNewsProvider newsProvider = (FXNewsProvider) container.getBean("djNewsProvider");
//        newsProvider.getAndPersistNews();

        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-context.xml");
        FXNewsProvider newsProvider = (FXNewsProvider) ctx.getBean("FXNewsProvider");
        newsProvider.getAndPersistNews();

    }


    /**
     * XMl声明绑定
     *
     * @param registry
     * @return
     */
    public static BeanFactory bindViaXMLFile(BeanDefinitionRegistry registry) {
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(registry);
        reader.loadBeanDefinitions("spring-context.xml");
        return (BeanFactory) registry;
        // 或者直接
        // return new XmlBeanFactory(new ClassPathResource("spring-context.xml"));
    }


    /**
     * 自定义绑定
     *
     * @param registry
     * @return
     */
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
        propertyValues.addPropertyValue(new PropertyValue("newsListener", newListener));
        propertyValues.addPropertyValue(new PropertyValue("newsPersistener", newPersister));
        newProvider.setPropertyValues(propertyValues);
        return (BeanFactory) registry;

    }

    ;
}
