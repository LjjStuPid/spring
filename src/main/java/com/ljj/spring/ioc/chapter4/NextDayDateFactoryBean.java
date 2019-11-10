package com.ljj.spring.ioc.chapter4;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

//@Repository
public class NextDayDateFactoryBean implements FactoryBean {

    @Override
    public Object getObject() throws Exception {
        return LocalDate.now().plusDays(1L);
    }


    @Override
    public Class<?> getObjectType() {
        return LocalDate.class;
    }


    @Override
    public boolean isSingleton() {
        return false;
    }
}
