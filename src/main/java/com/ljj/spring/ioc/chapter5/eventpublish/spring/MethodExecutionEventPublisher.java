package com.ljj.spring.ioc.chapter5.eventpublish.spring;

import com.ljj.spring.ioc.chapter5.eventpublish.MethodExecutionStatus;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author liujj
 * @Description TODO
 * @Date 2019/8/27 17:35
 */
public class MethodExecutionEventPublisher implements ApplicationEventPublisherAware {

    private ApplicationEventPublisher eventPublisher;

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.eventPublisher = applicationEventPublisher;
    }

    public void methodToMonitor() {
        MethodExecutionEvent beginEvt = new MethodExecutionEvent(this, "methodToMonitor", MethodExecutionStatus.BEGIN);
        this.eventPublisher.publishEvent(beginEvt);
        MethodExecutionEvent endEvt = new MethodExecutionEvent(this, "methodToMonitor", MethodExecutionStatus.END);
        this.eventPublisher.publishEvent(endEvt);
    }

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-context.xml");
        MethodExecutionEventPublisher executionEventPublisher = (MethodExecutionEventPublisher) applicationContext.getBean("evtPublisher");
        executionEventPublisher.methodToMonitor();
    }
}
