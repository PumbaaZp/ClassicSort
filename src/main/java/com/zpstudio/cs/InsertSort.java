package com.zpstudio.cs;

import java.util.Arrays;

/**
 * @Description 插入排序
 * @Author zhangpeng
 * @Date 2019/1/17 15:01
 **/
public class InsertSort implements IArraySort {
    @Override
    public int[] sort(int[] sourceArray){
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i;
            while (j > 0 && temp < arr[j - 1]) {
                arr[j] = arr[j-1];
                j--;
            }
            if(j != i){
                arr[j] = temp;
            }
        }
        return arr;
    }
}
