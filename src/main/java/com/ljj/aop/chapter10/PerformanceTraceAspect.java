package com.ljj.aop.chapter10;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.util.StopWatch;

/**
 * @Author liujj
 * @Description TODO
 * @Date 2019/9/9 14:11
 */

@Aspect
public class PerformanceTraceAspect {

    public PerformanceTraceAspect() {
    }

    private final Log logger = LogFactory.getLog(PerformanceTraceAspect.class);

    @Pointcut(value = "execution(public void com.ljj.aop.chapter10.*.method1()) || execution(public void com.ljj.aop.chapter10.*.method2())")
    public void pointcutName() {
    }

    @Around(value = "pointcutName()")
    public Object performanceTrace(ProceedingJoinPoint joinPoint) throws Throwable {
        StopWatch watch = new StopWatch();
        try {
            watch.start();
            return joinPoint.proceed();
        } finally {
            watch.stop();
            if (logger.isInfoEnabled()) {
                logger.info("PT in method[" + joinPoint.getSignature().getName() + "]" + watch.toString());
            }
        }
    }

}
