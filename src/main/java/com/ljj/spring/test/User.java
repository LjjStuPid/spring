package com.ljj.spring.test;

import org.springframework.core.LocalVariableTableParameterNameDiscoverer;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

/**
 * @Author liujj
 * @Description TODO
 * @Date 2020/1/9 16:32
 */
public class User {

    private String userName;

    public User(String userName) {
        this.userName = userName;
        System.out.println("fdasfdafafhsad");
    }

    public void say(String ww) {
        System.out.println(ww);
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                '}';
    }

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Constructor[] constructors = User.class.getDeclaredConstructors();
        for (Constructor constructor : constructors) {
           Parameter[] parameters = constructor.getParameters();
            for (Parameter parameter : parameters) {
                System.out.println(parameter.getName());
            }
        }


//        LocalVariableTableParameterNameDiscoverer u = new LocalVariableTableParameterNameDiscoverer();
//        Method[] methods = User.class.getDeclaredMethods();
//        for (Method method : methods) {
//
//            //获取到该方法的参数们
//            String[] params = u.getParameterNames(method);
//            for (String param : params) {
//                System.out.println(param);
//            }
//
//        }
    }
}
