package com.ljj.aop.chapter9;

import org.springframework.aop.ThrowsAdvice;

import java.lang.reflect.Method;

public class ExceptionBarrierThrowsAdvice implements ThrowsAdvice {

    public void afterThrowing(Throwable t) {

    }

    public void afterThrowing(RuntimeException e) {

    }

    public void afterThrowing(Method m, Object[] args, Object target, RuntimeException e) {

    }

}
