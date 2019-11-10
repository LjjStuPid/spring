package com.ljj.spring.aop.chapter9;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StopWatch;

public class PerformanceMethodInterctptor implements MethodInterceptor {

    private final Log logger = LogFactory.getLog(this.getClass());

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        StopWatch watch = new StopWatch();
        try {
            watch.start();
            return invocation.proceed();
        } finally {
            watch.stop();
            if (logger.isInfoEnabled()) {
                logger.info(watch.toString());
            }
        }
    }
}
