package com.ljj.aop.chapter10;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;

/**
 * @Author liujj
 * @Description TODO
 * @Date 2019/9/10 15:48
 */
@Aspect
public class AroundAspect {

    @Around(value = "execution(Integer com.ljj.aop.chapter10.AroundTest.test(String)) && args(taskName)")
    public void around(ProceedingJoinPoint joinPoint, String taskName) throws Throwable {

        System.out.println("任务名:" + taskName);
        taskName = "修改后";
        Object object = joinPoint.proceed(new Object[]{taskName});
        System.out.println("around:" + object);

    }

    public static void main(String[] args) {
        AspectJProxyFactory aspectJProxyFactory = new AspectJProxyFactory();
        aspectJProxyFactory.setTarget(new AroundTest());
        aspectJProxyFactory.addAspect(AroundAspect.class);
        aspectJProxyFactory.setProxyTargetClass(true);
        Object object = aspectJProxyFactory.getProxy();
        ((AroundTest) object).test("fdsfd");
    }

}
