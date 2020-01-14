package com.ljj.spring.aop.chapter7;

public aspect MyAspectJDemo {

    pointcut recordLog():call(* com.ljj.spring.aop.chapter7.HelloWorld.sayHello(..));

    pointcut authcheck():call(* com.ljj.spring.aop.chapter7.HelloWorld.sayHello(..));

    before():authcheck(){
        System.out.println("sayHello方法执行前验证权限");
    }

    after():recordLog(){
        System.out.println("sayHello方法执行后记录日志");
    }

}
