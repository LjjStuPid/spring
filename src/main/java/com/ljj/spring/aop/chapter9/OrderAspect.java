package com.ljj.spring.aop.chapter9;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * @Author liujj
 * @Description TODO
 * @Date 2020/1/17 10:55
 */
@Aspect
public class OrderAspect {


    @Pointcut("execution(* com.ljj.spring.aop.chapter9.OrderServiceImpl.*())")
    public void pointcut() {

    }

    @After(value = "pointcut()")
    public void before() {
        System.out.println("fdsafdasfdasf");
    }

}
