package com.ljj.spring.aop.chapter7;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface MyAnnotation {

    String desc() default "Hello";
}
