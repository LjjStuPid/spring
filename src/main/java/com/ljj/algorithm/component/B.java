package com.ljj.algorithm.component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author liujj
 * @Description TODO
 * @Date 2020/5/15 17:00
 */
public class B {

    public static void main(String[] args) {
        int[] a = new int[]{1, 3, 5, 7, 9,321321};
        int[] b = new int[]{2, 3, 6, 7, 10};

        System.out.println(Arrays.toString(getSubArray(a, b)));

    }


    private static final Object[] getSubArray(int[] a, int[] b) {
        int i = 0;
        int j = 0;
        List<Integer> list = new ArrayList<>();
        while (i < a.length && j < b.length) {
            if (a[i] < b[j]) {
                list.add(a[i]);
                i++;
                continue;
            }
            if (a[i] > b[j]) {
                list.add(b[j]);
                j++;
                continue;
            }
            list.add(a[i]);
            i++;
            j++;
        }
        if (i == a.length) {
            for (int m = j; m < b.length; m++) {
                list.add(b[m]);
            }
            return list.toArray();
        }

        for (int m = i; m < a.length; m++) {
            list.add(a[m]);
        }
        return list.toArray();

    }

}
