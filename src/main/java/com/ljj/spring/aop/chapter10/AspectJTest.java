package com.ljj.spring.aop.chapter10;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;

@Aspect
public class AspectJTest {
//
//    @Pointcut("execution(void test3(User))")
//    public void pointcut() {
//    }


    @Pointcut("@within(AnyJoinpointAnnotation)")
    public void pointcut() {
    }

//    @Before(value = "pointcut() && args(user)")
//    public void before(User user) throws Throwable {
//        System.out.println(user);
//
//    }


    @Before(value = "pointcut() && args(user,m)")
    public void before(User user,String m) throws Throwable {

        System.out.println(user);
    }

//    @Around(value = "pointcut()")
//    public void around(ProceedingJoinPoint joinPoint) throws Throwable {
//        System.out.println(joinPoint.getSignature().getName() + "方法调用开始");
//        joinPoint.proceed();
//        System.out.println(joinPoint.getSignature().getName() + "方法调用结束");
//    }

    public static void main(String[] args) {
        AspectJProxyFactory weaver = new AspectJProxyFactory();
        weaver.setProxyTargetClass(true);
        weaver.setTarget(new MockTarget());
        weaver.addAspect(AspectJTest.class);
        Object proxy = weaver.getProxy();
        User user = new User();
        user.setUsername("liu");
        user.setPassword("1223456");
        ((MockTarget) proxy).test3(user,"dfafas");
//        ((Foo)proxy).method1();
//        ((Foo)proxy).method2();
    }
}
