package com.ljj.spring.aop.test;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class UserServiceAspect {

    @Before("execution(* com.ljj.spring.aop.test.UserService.work(..))")
    public void logBefore(JoinPoint jointPoint) {
        System.out.println("UserServiceAspect..........()");
    }
}
