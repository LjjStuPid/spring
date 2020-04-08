package com.ljj.jvm;

/**
 * @Author liujj
 * @Description TODO
 * @Date 2020/4/1 11:13
 */
public class B {

    int i = 0;

    public synchronized void parse() {
        i++;
    }
}
