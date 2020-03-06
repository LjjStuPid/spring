package com.ljj.spring.datasource;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Inherited
public @interface Tx {

    String value() default "刘雪梅";
}
