package com.zpstudio.cs;

import java.util.Arrays;

/**
 * @Description
 * @Author zhangpeng
 * @Date 2019/1/17 11:13
 **/
public class Test {

    public static void main(String[] args) {
        int maxLength = 100000;
        int[] arrays = {2, 5, 10, 3, 7, 4, 1, 9, 8, 6};
        int[] arraysRandom = new int[maxLength];
        for (int i = 0; i < maxLength; i++) {
            arraysRandom[i] = (int) (Math.random() * maxLength);
        }
        IArraySort sort = new RadixSort();
        try {
            System.out.println(Arrays.toString(sort.sort(arrays)));
            long startTime = System.currentTimeMillis();
            sort.sort(arraysRandom);
            long endTime = System.currentTimeMillis();
            System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
