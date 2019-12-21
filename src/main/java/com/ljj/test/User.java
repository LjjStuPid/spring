package com.ljj.test;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class User extends Comparable<String> {
    @Override
    public int compare(String o1, String o2) {
        return 0;
    }

    public static void main(String[] args) {
        User user = new User();
        Type type = user.getClass().getGenericSuperclass();
        System.out.println(type);
        ParameterizedType pt = (ParameterizedType) (type);
        System.out.println(pt);

    }
}
