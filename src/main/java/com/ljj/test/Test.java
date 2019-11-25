package com.ljj.test;

import java.lang.annotation.Annotation;

/**
 * @Author liujj
 * @Description TODO
 * @Date 2019/11/19 13:54
 */
@Configuration(value = "shsh")
public class Test {
    public static void main(String[] args) {
        Test test = new Test();
        Annotation[] annotations = test.getClass().getAnnotations();
        for (Annotation annotation : annotations) {
            Configuration configuration = (Configuration) annotation;
            Annotation[] annotation1 = configuration.annotationType().getAnnotations();
            for (Annotation annotation2 : annotation1) {
                System.out.println(annotation2);
            }
//            Annotation[] annotations1 = configuration.getClass().getAnnotations();
//            for (Annotation c : annotations1) {
//                if (c instanceof Mapper) {
//                    Mapper mapper = (Mapper) c;
//                    System.out.println(mapper.scanPackages());
//                }
//            }
        }
    }


}
