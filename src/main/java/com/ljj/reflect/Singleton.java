package com.ljj.reflect;

import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @Author liujj
 * @Description TODO
 * @Date 2019/11/25 16:32
 */
public class Singleton implements Serializable {

    private static final Singleton singleton = new Singleton();
    private static final long serialVersionUID = -8067750173845314796L;
    public static boolean flag = false;


    private Singleton() {
        if (flag) {
            throw new RuntimeException("fdsafdasf");
        }
        flag = true;
    }

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Constructor constructor = Singleton.class.getDeclaredConstructor(null);
        constructor.setAccessible(true);
        Singleton ref = (Singleton) constructor.newInstance(null);
        System.out.println(ref);
        System.out.println(singleton);
    }

}
