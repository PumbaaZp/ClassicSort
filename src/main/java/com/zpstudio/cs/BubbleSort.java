package com.zpstudio.cs;

import java.util.Arrays;

/**
 * @Description 冒泡排序
 * @Author zhangpeng
 * @Date 2019/1/16 15:06
 **/
public class BubbleSort implements IArraySort {
    @Override
    public int[] sort(int[] sourceArray) {
        int arr[] = Arrays.copyOf(sourceArray, sourceArray.length);

        for (int i = 1; i < arr.length; i++) {
            boolean flag = true;
            for (int j = 0; j < arr.length - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    flag = false;
                }
            }
            if (flag) {
                break;
            }
        }
        return arr;
    }
}
