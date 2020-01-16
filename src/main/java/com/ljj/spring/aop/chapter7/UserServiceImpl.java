package com.ljj.spring.aop.chapter7;

import java.lang.annotation.Annotation;

/**
 * @Author liujj
 * @Description TODO
 * @Date 2020/1/14 10:36
 */
@MyAnnotation
public class UserServiceImpl implements UserService {
    @Override
    public void saveUser() {
        System.out.println("保存用户");
    }

    @Override
    public void updateUser() {
        System.out.println("更新用户");
    }

    public static void main(String[] args) {

        DDD ddd = new DDD();
        Annotation[] annotations = ddd.getClass().getAnnotations();
        for (Annotation annotation : annotations) {
            Annotation[] annotations1 = annotation.annotationType().getAnnotations();
            for (Annotation annotation1 : annotations1) {
                System.out.println(annotation1.toString());
            }
            System.out.println(annotation.toString());
        }
    }
}
