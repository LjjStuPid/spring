package com.ljj.test;

import java.lang.annotation.*;

/**
 * @Author liujj
 * @Description TODO
 * @Date 2019/11/19 13:53
 */
@Target(value = ElementType.TYPE)
@Retention(value = RetentionPolicy.RUNTIME)
@Inherited
@Mapper(scanPackages = "wrewqrwreewrewrwerew")
public @interface Configuration {

    String value();

}
