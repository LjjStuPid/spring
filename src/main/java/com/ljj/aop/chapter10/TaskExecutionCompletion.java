package com.ljj.aop.chapter10;

/**
 * @Author liujj
 * @Description TODO
 * @Date 2019/9/10 15:29
 */
public class TaskExecutionCompletion {

    public String execute(String mds) {
        System.out.println(mds);
        return "complete:" + mds;
    }

}
