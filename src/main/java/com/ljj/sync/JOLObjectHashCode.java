package com.ljj.sync;

import org.openjdk.jol.info.ClassLayout;

/**
 * @Author liujj
 * @Description 对象头hashCode存储位置
 * @Date 2020/4/28 15:31
 */
public class JOLObjectHashCode {

    static A a = new A();

    public static void main(String[] args) {
        A a = new A();
        System.out.println("before hash");

        System.out.println(ClassLayout.parseInstance(a).toPrintable());
        System.out.println("jvm----------Ox" + Integer.toHexString(a.hashCode()));

        System.out.println("after hash");
        System.out.println(ClassLayout.parseInstance(a).toPrintable());
    }
}
