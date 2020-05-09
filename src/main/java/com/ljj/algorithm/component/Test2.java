package com.ljj.algorithm.component;

import java.util.Arrays;

/**
 * @Author liujj
 * @Description TODO
 * @Date 2020/5/9 10:02
 */
public class Test2 {

    public static void main(String[] args) {
        int[] array1 = new int[]{9, 11, 12, 14};
        int[] array2 = new int[]{7, 9, 11, 12};
        System.out.println(Arrays.toString(getSubArray(array1, array2)));
        System.out.println(Arrays.toString(getAddArray(array1, array2)));
    }

    // 求两个数组的并集
    private static int[] getAddArray(int[] array1, int[] array2) {
        int cycleTime = array1.length > array2.length ? array2.length : array1.length;
        int i = 0;
        int j = 0;
        int[] addArray = new int[array1.length + array2.length];
        int addI = 0;
        while (cycleTime-- > 0) {
            if (array1[i] > array2[j]) {
                addArray[addI++] = array2[j];
                j++;
                continue;
            }
            if (array1[i] < array2[j]) {
                addArray[addI++] = array1[i];
                i++;
                continue;
            }
            addArray[addI++] = array1[i];
            i++;
            j++;
        }
        if (i == array1.length) {
            for (int i1 = j; i1 < array2.length; i1++) {
                addArray[addI++] = array2[i1];
            }
        }
        if (j == array2.length) {
            for (int i1 = i; i1 < array1.length; i1++) {
                addArray[addI++] = array1[i1];
            }
        }
        return addArray;
    }

    // 求两个数组的交集
    private static int[] getSubArray(int[] array1, int[] array2) {
        int cycleTimes = array1.length > array2.length ? array2.length : array1.length;
        int i = 0;
        int j = 0;
        int[] subArray = new int[cycleTimes];
        int subi = 0;
        while (cycleTimes-- > 0) {
            if (array1[i] > array2[j]) {
                j++;
                continue;
            }
            if (array1[i] < array2[j]) {
                i++;
                continue;
            }
            subArray[subi++] = array1[i];
            i++;
            j++;
        }
        return subArray;
    }
}
