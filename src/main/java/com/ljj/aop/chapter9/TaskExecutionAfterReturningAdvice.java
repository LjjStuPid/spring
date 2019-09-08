package com.ljj.aop.chapter9;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

public class TaskExecutionAfterReturningAdvice implements AfterReturningAdvice {
    @Override
    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
        System.out.println("保存任务执行状态");
    }
}
