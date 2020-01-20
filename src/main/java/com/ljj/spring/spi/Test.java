package com.ljj.spring.spi;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @Author liujj
 * @Description TODO
 * @Date 2020/1/20 11:13
 */
public class Test {


    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(2);
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            Integer integer = iterator.next();
            if (integer == 2) {
                list.remove(integer);
            }
        }
    }
}
