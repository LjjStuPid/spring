package com.ljj.aop.chapter10;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;

/**
 * @Author liujj
 * @Description TODO
 * @Date 2019/9/10 15:37
 */
@Aspect
public class SystemCleanerAspect {

    @After("execution(String com.ljj.aop.chapter10.SystemResource.send(String,..))")
    public void cleanUpResourcesIfNecessary() {
        System.out.println("after");
    }

    public static void main(String[] args) {
        AspectJProxyFactory weaver = new AspectJProxyFactory();
        weaver.setProxyTargetClass(true);
        weaver.setTarget(new SystemResource());
        weaver.addAspect(SystemCleanerAspect.class);
        Object proxy = weaver.getProxy();
        ((SystemResource) proxy).send("fdasfddafadfaa");
    }
}
