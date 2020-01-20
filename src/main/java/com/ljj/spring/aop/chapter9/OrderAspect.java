package com.ljj.spring.aop.chapter9;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @Author liujj
 * @Description TODO
 * @Date 2020/1/17 10:55
 */
@Aspect
@Component
public class OrderAspect {

    @Pointcut("execution(* com.ljj.spring.aop.chapter9.OrderService.*())")
    public void pointcut() {

    }

    @After(value = "pointcut()")
    public void before() {
        System.out.println("fdsafdasfdasf");
    }

}
