package com.zpstudio.cs;

import java.util.Arrays;

/**
 * @Description 桶排序
 * @Author zhangpeng
 * @Date 2019/1/18 16:08
 **/
public class BuckectSort implements IArraySort {

    InsertSort insertSort = new InsertSort();
    @Override
    public int[] sort(int[] sourceArray) {
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);
        return buckectSort(arr, 5);
    }

    private int[] buckectSort(int[] arr, int bucketSize) {
        if (arr.length == 0) {
            return arr;
        }
        int minValue = arr[0];
        int maxValue = arr[0];
        for (int value : arr) {
            if(value < minValue)
                minValue = value;
            else if(value > maxValue)
                maxValue = value;
        }

        int bucketCount = (int) Math.floor((maxValue - minValue) / bucketSize) + 1;
        int[][] buckets = new int[bucketCount][0];

        for (int i = 0; i < arr.length; i++) {
            int index = (int) Math.floor((arr[i] - minValue) / bucketSize);
            buckets[index] = arrAppend(buckets[index], arr[i]);
        }

        int arrIndex = 0;
        for (int[] bucket : buckets) {
            if(bucket.length <= 0){
                continue;
            }
            bucket = insertSort.sort(bucket);
            for(int value : bucket){
                arr[arrIndex++]=value;
            }
        }
        return arr;
    }

    private int[] arrAppend(int[] arr, int value) {
        arr = Arrays.copyOf(arr, arr.length + 1);
        arr[arr.length - 1] = value;
        return arr;
    }
}
