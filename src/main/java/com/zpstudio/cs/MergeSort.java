package com.zpstudio.cs;

import java.util.Arrays;

/**
 * @Description 归并排序
 * @Author zhangpeng
 * @Date 2019/1/17 15:49
 **/
public class MergeSort implements IArraySort {
    @Override
    public int[] sort(int[] sourceArray) {
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);
        if(arr.length < 2){
            return arr;
        }
        int middle = (int) Math.floor(arr.length / 2);
        int[] left = Arrays.copyOfRange(arr, 0, middle);
        int[] right = Arrays.copyOfRange(arr, middle, arr.length);
        return merge(sort(left), sort(right));
    }

    private int[] merge(int[] left, int[] right){
        int[] result = new int[left.length + right.length];
        int i = 0;
        while (left.length > 0 & right.length > 0){
            if(left[0] < right[0]){
                result[i++] = left[0];
                left = Arrays.copyOfRange(left, 1, left.length);
            }else{
                result[i++] = right[0];
                right = Arrays.copyOfRange(right, 1, right.length);
            }
        }
        while (left.length > 0){
            result[i++] = left[0];
            left = Arrays.copyOfRange(left, 1, left.length);
        }
        while (right.length > 0){
            result[i++] = right[0];
            right = Arrays.copyOfRange(right, 1, right.length);
        }
        return result;


    }
}
