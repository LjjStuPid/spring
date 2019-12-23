package com.ljj.jdk.test;

import javax.annotation.Generated;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resources;
import java.lang.annotation.*;
import java.util.ArrayList;

@SomeAnno
public class Test {
    private static ArrayList<Annotation> annos = new ArrayList<>();

    public static void main(String[] args) {
        Test test = new Test();
        Class<?> c1 = test.getClass();
        Annotation[] annotations = c1.getAnnotations();

        for (Annotation annotation : annotations) {
            System.out.println(annotation.annotationType());
            if (annotation instanceof SomeAnno) {
                SomeAnno someAnno = (SomeAnno) annotation;
                System.out.println(someAnno.annotationType());
                System.out.println(someAnno.annotationType());
            }
        }
//        getAnnos(c1);
//        for (Annotation annotation : annos) {
//            System.out.println(annotation.annotationType());
//        }
    }

    private static void getAnnos(Class<?> c1) {
        Annotation[] annotations = c1.getAnnotations();
        for (Annotation annotation : annotations) {
            if (annotation.annotationType() != Deprecated.class &&
                    annotation.annotationType() != SuppressWarnings.class &&
                    annotation.annotationType() != Override.class &&
                    annotation.annotationType() != PostConstruct.class &&
                    annotation.annotationType() != PreDestroy.class &&
                    annotation.annotationType() != Resources.class &&
                    annotation.annotationType() != Generated.class &&
                    annotation.annotationType() != Target.class &&
                    annotation.annotationType() != Retention.class &&
                    annotation.annotationType() != Documented.class &&
                    annotation.annotationType() != Inherited.class
                    ) {
                annos.add(annotation);
                getAnnos(annotation.annotationType());
            }
        }
    }
}
