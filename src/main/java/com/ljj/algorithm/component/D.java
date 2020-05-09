package com.ljj.algorithm.component;

/**
 * @Author liujj
 * @Description TODO
 * @Date 2020/4/30 10:44
 */
public class D {

    public static void main(String[] args) {

        //1,1,2,3,5,8,13,21....

        System.out.println(f(6));

    }

    private static int f(int a) {
        if (a == 1 || a == 2) {
            return 1;
        }
        return f(a - 1) + f(a - 2);
    }
}
