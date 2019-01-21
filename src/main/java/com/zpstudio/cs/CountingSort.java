package com.zpstudio.cs;

import java.util.Arrays;

/**
 * @Description 计数排序
 * @Author zhangpeng
 * @Date 2019/1/18 15:49
 **/
public class CountingSort implements IArraySort {
    @Override
    public int[] sort(int[] sourceArray) {
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);
        int maxValue = getMaxValue(arr);
        return countingSort(arr, maxValue);
    }

    private int[] countingSort(int[] arr, int maxValue) {
        int bucketLen = maxValue + 1;
        int[] bucket = new int[bucketLen];
        for(int value : arr){
            bucket[value]++;
        }
        int sortIndex = 0;
        for (int j = 0; j < bucketLen; j++) {
            while (bucket[j] > 0){
                arr[sortIndex++] = j;
                bucket[j]--;
            }
        }
        return arr;
    }

    private int getMaxValue(int[] arr) {
        int maxValue = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (maxValue < arr[i]) {
                maxValue = arr[i];
            }
        }
        return maxValue;
    }
}
