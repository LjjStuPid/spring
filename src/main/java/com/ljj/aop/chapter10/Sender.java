package com.ljj.aop.chapter10;

/**
 * @Author liujj
 * @Description TODO
 * @Date 2019/9/10 14:59
 */
public class Sender {

    public boolean execute(String content) {
        System.out.println(content);
        int i = 1 / 0;
        return true;
    }

}
