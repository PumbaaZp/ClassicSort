package com.zpstudio.cs;

import java.util.Arrays;

/**
 * @Description 选择排序
 * @Author zhangpeng
 * @Date 2019/1/17 14:43
 **/
public class SelectionSort implements IArraySort{
    @Override
    public int[] sort(int[] sourceArray){
        int arr[] = Arrays.copyOf(sourceArray, sourceArray.length);

        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;
            for(int j = i+1; j < arr.length; j++){
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }

            if(i != min){
                int temp = arr[i];
                arr[i] = arr[min];
                arr[min] = temp;
            }
        }
        return arr;
    }
}
