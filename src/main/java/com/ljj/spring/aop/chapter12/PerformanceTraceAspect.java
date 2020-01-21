package com.ljj.spring.aop.chapter12;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;
import org.springframework.util.StopWatch;

@Aspect
public class PerformanceTraceAspect {

    private final Log logger = LogFactory.getLog(PerformanceTraceAspect.class);

    @Pointcut("execution(void com.ljj.spring.aop.chapter12.*.*(..))")
    public void method1() {
    }

    @Pointcut("execution(void com.ljj.spring.aop.chapter12.*.*(..))")
    public void method2() {
    }

    @Pointcut("method1() || method2()")
    public void compositePointcut() {
    }

    @Around("compositePointcut()")
    public Object performanceTrace(ProceedingJoinPoint joinPoint) throws Throwable {
        StopWatch watch = new StopWatch();
        watch.start();
        try {
            return joinPoint.proceed();
        } finally {
            watch.stop();
            System.out.println("PT in method[" + joinPoint.getSignature().getName() + "]>>>>" + watch.toString());

        }
    }

    public static void main(String[] args) {
        AspectJProxyFactory weaver = new AspectJProxyFactory(new NestableInvocationBO());
        weaver.setProxyTargetClass(true);
        weaver.setExposeProxy(true);
        weaver.addAspect(PerformanceTraceAspect.class);
        Object proxy = weaver.getProxy();
//        ((NestableInvocationBO) proxy).method2();
        ((NestableInvocationBO) proxy).method1();
    }

}
