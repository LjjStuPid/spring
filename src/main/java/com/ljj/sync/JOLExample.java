package com.ljj.sync;

import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.vm.VM;

/**
 * @Author liujj
 * @Description TODO
 * @Date 2020/4/28 15:19
 */
public class JOLExample {
    static A a = new A();

    public static void main(String[] args) {
        System.out.println(VM.current().details());
        System.out.println(ClassLayout.parseInstance(a).toPrintable());
    }
}
