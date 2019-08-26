package com.ljj.ioc.chapter4;

import org.springframework.beans.factory.config.CustomEditorConfigurer;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author liujj
 * @Description TODO
 * @Date 2019/8/26 11:45
 */
public class DateFoo {

    private Date date;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "DateFoo{" +
                "date=" + date +
                '}';
    }

    public static void main(String[] args) {
        XmlBeanFactory beanFactory =new XmlBeanFactory(new ClassPathResource("spring-context.xml"));

//        //beanfactory代码注册
//        CustomEditorConfigurer ceConfigurer = new CustomEditorConfigurer();
//        Map customerEditors =  new HashMap<>();
//        customerEditors.put(java.util.Date.class,new DatePropertyEditor());
//        ceConfigurer.postProcessBeanFactory(beanFactory);
        DateFoo dateFoo = (DateFoo) beanFactory.getBean("dateFoo");
        System.out.println(dateFoo);

    }
}
