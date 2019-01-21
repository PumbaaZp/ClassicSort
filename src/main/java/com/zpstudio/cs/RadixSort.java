package com.zpstudio.cs;

import java.util.Arrays;

/**
 * @Description 基数排序
 * 待明确逻辑
 * @Author zhangpeng
 * @Date 2019/1/21 16:18
 **/
public class RadixSort implements IArraySort {
    @Override
    public int[] sort(int[] sourceArray) {
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);

        int maxDigit = getMaxDigit(arr);

        return redixSort(arr, maxDigit);
    }

    private int[] redixSort(int[] arr, int maxDigit) {
        int mod = 10;
        int dev = 1;
        for (int i = 0; i < maxDigit; i++, dev *= 10, mod*=10) {
            int[][] counter = new int[mod * 2][0];
            for (int j = 0; j < arr.length; j++) {
                int bucket = ((arr[j] % mod) / dev) + mod;
                counter[bucket] = arrayAppend(counter[bucket], arr[j]);
            }
            int pos = 0;
            for (int[] bucket: counter) {
                for(int value : bucket){
                    arr[pos++] = value;
                }
            }
        }
        return arr;
    }

    private int[] arrayAppend(int[] arr, int value) {
        arr = Arrays.copyOf(arr, arr.length + 1);
        arr[arr.length - 1] = value;
        return arr;
    }

    private int getMaxDigit(int[] arr) {
        int maxValue = getMaxValue(arr);
        return getNumLength(maxValue);
    }

    private int getNumLength(int num) {
        if(num == 0){
            return 1;
        }
        int length = 0;
        for (long temp = num; temp != 0; temp /= 10) {
            length ++;
        }
        return length;
    }

    private int getMaxValue(int[] arr) {
        int maxValue = arr[0];
        for (int value : arr) {
            if(maxValue < value)
                maxValue = value;
        }
        return maxValue;
    }
}
