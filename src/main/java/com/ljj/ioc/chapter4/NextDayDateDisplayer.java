package com.ljj.ioc.chapter4;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public class NextDayDateDisplayer {

    @Autowired
    private LocalDate dateOfNextDay;

    public LocalDate getDateOfNextDay() {
        return dateOfNextDay;
    }

    public void setDateOfNextDay(LocalDate dateOfNextDay) {
        this.dateOfNextDay = dateOfNextDay;
    }

    @Override
    public String toString() {
        return "NextDayDateDisplayer{" +
                "dateOfNextDay=" + dateOfNextDay +
                '}';
    }

    public static void main(String[] args) {
//        BeanFactory factory = new XmlBeanFactory(new ClassPathResource("spring-context.xml"));
//        NextDayDateDisplayer nextDayDateDisplayer = (NextDayDateDisplayer) factory.getBean("nextDayDateDisplayer");
//        System.out.println(nextDayDateDisplayer);
//        System.out.println(factory.getBean("&nextDayDate"));

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.scan("com.ljj.ioc.chapter4");
        applicationContext.refresh();
        NextDayDateDisplayer dayDateDisplayer = (NextDayDateDisplayer) applicationContext.getBean("nextDayDateDisplayer");
        System.out.println(dayDateDisplayer);
    }
}
