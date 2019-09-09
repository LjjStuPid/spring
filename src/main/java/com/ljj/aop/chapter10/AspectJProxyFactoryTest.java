package com.ljj.aop.chapter10;

import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;

/**
 * @Author liujj
 * @Description TODO
 * @Date 2019/9/9 14:27
 */
public class AspectJProxyFactoryTest {

    public static void main(String[] args) {
        AspectJProxyFactory weaver = new AspectJProxyFactory(new Foo());
        weaver.setProxyTargetClass(true);
        weaver.addAspect(PerformanceTraceAspect.class);
        Object proxy = weaver.getProxy();
        ((Foo) proxy).method1();
        ((Foo) proxy).method2();
    }
}
