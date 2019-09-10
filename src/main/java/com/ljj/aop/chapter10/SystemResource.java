package com.ljj.aop.chapter10;

/**
 * @Author liujj
 * @Description TODO
 * @Date 2019/9/10 15:39
 */
public class SystemResource {

    public String send(String content) {
        System.out.println(content);
        return "send:" + content;
    }

}
