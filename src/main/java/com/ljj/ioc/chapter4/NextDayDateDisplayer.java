package com.ljj.ioc.chapter4;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import java.time.LocalDate;

public class NextDayDateDisplayer {

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
        BeanFactory factory = new XmlBeanFactory(new ClassPathResource("spring-context.xml"));

        NextDayDateDisplayer nextDayDateDisplayer = (NextDayDateDisplayer) factory.getBean("nextDayDateDisplayer");
        System.out.println(nextDayDateDisplayer);

        System.out.println(factory.getBean("&nextDayDate"));
    }
}
