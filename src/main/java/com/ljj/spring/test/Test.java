package com.ljj.spring.test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author liujj
 * @Description TODO
 * @Date 2020/1/10 17:13
 */
public class Test {

    public static int m = 1;

    public static void main(String[] args) {


        List<String> list = new ArrayList<>();

        while (true) {
            list.add(String.valueOf(m++).intern());
        }
    }
}
