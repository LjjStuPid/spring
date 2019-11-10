package com.ljj.spring.aop.chapter10;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;

/**
 * @Author liujj
 * @Description TODO
 * @Date 2019/9/10 14:55
 */
@Aspect
public class ExceptionBarrierAspect {

    @AfterThrowing(pointcut = "execution(public  boolean com.ljj.spring.aop.chapter10.Sender.execute(String))", throwing = "e")
    public void afterThrowing(RuntimeException e) {
//        System.out.println("dfafdafdassfadfafa");
        System.out.println(e.getMessage());
    }

    public static void main(String[] args) {
        AspectJProxyFactory weaver = new AspectJProxyFactory();
        weaver.setProxyTargetClass(true);
        weaver.setTarget(new Sender());
        weaver.addAspect(ExceptionBarrierAspect.class);
        Object proxy = weaver.getProxy();
        ((Sender) proxy).execute("fdasfddafadfaa");
    }


}
