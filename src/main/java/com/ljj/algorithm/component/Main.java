package com.ljj.algorithm.component;

import java.util.Stack;

/**
 * @Author liujj
 * @Description TODO
 * @Date 2020/4/29 17:41
 */
public class Main {

    public static Stack<Integer> stack = new Stack<Integer>();

    public static void main(String[] args) {
        int shu[] = {1, 2};
        f(shu, 2, 0);
    }

    private static void f(int[] shu, int targ, int cur) {
        if (cur == targ) {
            System.out.println(stack);
            return;
        }

        for (int i = 0; i < shu.length; i++) {
            stack.add(shu[i]);
            f(shu, targ, cur + 1);
            System.out.println("fdsaf");
            stack.pop();
        }
    }

}
