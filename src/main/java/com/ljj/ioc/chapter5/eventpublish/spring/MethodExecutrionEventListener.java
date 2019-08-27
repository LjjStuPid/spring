package com.ljj.ioc.chapter5.eventpublish.spring;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

/**
 * @Author liujj
 * @Description TODO
 * @Date 2019/8/27 17:32
 */
public class MethodExecutrionEventListener implements ApplicationListener {
    @Override
    public void onApplicationEvent(ApplicationEvent applicationEvent) {
        if (applicationEvent instanceof MethodExecutionEvent) {
            MethodExecutionEvent methodExecutionEvent = (MethodExecutionEvent) applicationEvent;
            System.out.println(methodExecutionEvent.getMethodName()+":"+methodExecutionEvent.getMethodExecutionStatus());
        }
    }
}
