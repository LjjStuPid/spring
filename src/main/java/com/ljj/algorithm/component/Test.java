package com.ljj.algorithm.component;

import java.util.Arrays;

/**
 * @Author liujj
 * @Description TODO
 * @Date 2020/5/9 9:41
 */
public class Test {

    public static void main(String[] args) {
        int[] array1 = new int[]{3, 7, 9, 10,34,4324};
        int[] array2 = new int[]{4, 5, 8, 13, 90};
        int[] allArray = new int[array1.length + array2.length];
        int cycleSize = array2.length > array1.length ? array2.length : array1.length;
        int i = array1.length - 1;
        int j = array2.length - 1;
        int c = allArray.length - 1;
        while (cycleSize > 0) {
            if (i < 0 || j < 0) {
                break;
            }
            if (array1[i] >= array2[j]) {
                allArray[c--] = array1[i];
                i--;
            } else {
                allArray[c--] = array2[j];
                j--;
            }
        }
        if (i > 0) {
            for (int i1 = 0; i1 < i; i1++) {
                allArray[i1] = array1[i1];
            }
        }
        if (j > 0) {
            for (int i1 = 0; i1 < i; i1++) {
                allArray[i1] = array2[i1];
            }
        }
        System.out.println(Arrays.toString(allArray));
    }


}
