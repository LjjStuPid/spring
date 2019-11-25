package com.ljj.test;

import java.lang.annotation.Annotation;

/**
 * @Author liujj
 * @Description TODO
 * @Date 2019/11/19 18:07
 */
public class C extends B {

    public static void main(String[] args) {
        Annotation[] annotations = B.class.getAnnotations();
        for (Annotation annotation : annotations) {
            if (annotation instanceof Mapper) {
                Mapper mapper = (Mapper) annotation;
                System.out.println(mapper.scanPackages());
            }
        }
    }
}
