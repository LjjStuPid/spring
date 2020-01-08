package com.ljj.spring.ioc;

/**
 * @Author liujj
 * @Description TODO
 * @Date 2019/12/5 14:48
 */
public class Student {

    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                '}';
    }
}
