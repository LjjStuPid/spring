package com.ljj.spring.aop.chapter9;

import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.interceptor.PerformanceMonitorInterceptor;
import org.springframework.aop.support.NameMatchMethodPointcutAdvisor;

/**
 * @Author liujj
 * @Description TODO
 * @Date 2019/9/6 15:00
 */
public class Executable {

    public void execute() {
        System.out.println("Executable without any Interfaces");
    }


    public static void main(String[] args) {
        ProxyFactory weaver = new ProxyFactory(new Executable());
        NameMatchMethodPointcutAdvisor advisor = new NameMatchMethodPointcutAdvisor();
        advisor.setMappedName("execute");
        advisor.setAdvice(new PerformanceMonitorInterceptor());
        weaver.addAdvisor(advisor);
        Executable proxyObject = (Executable) weaver.getProxy();
        proxyObject.execute();

        System.out.println(proxyObject.getClass());
    }

}
