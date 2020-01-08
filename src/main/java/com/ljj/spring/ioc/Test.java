package com.ljj.spring.ioc;

import com.ljj.spring.ioc.chapter4.User;
import org.springframework.beans.BeanUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.xml.parsers.ParserConfigurationException;

public class Test {

    public static void main(String[] args) throws ParserConfigurationException {
//        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-context.xml");
//        MyDataSource dataSource = (MyDataSource) applicationContext.getBean("dataSource");
//        System.out.println(dataSource);

//        Teacher teacher = new Teacher();
//        teacher.setId("ddd");
//        teacher.setName("dafadfdaf");
//        Student student = new Student();
//        student.setAge(34);
//        teacher.setStudent(student);
//        Teacher1 teacher1 = new Teacher1();
//        BeanUtils.copyProperties(teacher, teacher1);
//        System.out.println(teacher1);

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-context.xml");
        User user = (User) applicationContext.getBean("user");
        System.out.println(user);

//
//        DateFoo dateFoo = (DateFoo) applicationContext.getBean("dateFoo");
//
//        System.out.println(dateFoo);

//        XmlBeanFactory xmlBeanFactory = new XmlBeanFactory(new ClassPathResource("spring-context.xml"));
//        BeanPostProcessor beanPostProcessor = new BeanPostProcessorDemo();
//        xmlBeanFactory.addBeanPostProcessor(beanPostProcessor);
//        Demo demo = (Demo) xmlBeanFactory.getBean("demo");
//        System.out.println(demo.getClass());
//        System.out.println(xmlBeanFactory.);


    }
}
