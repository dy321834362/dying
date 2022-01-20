package com.dai;

import java.util.Arrays;
import java.util.Random;

public class 快排 {
    static void quick_sort(int[] arr) {
        Random r = new Random();
        int k = r.nextInt(arr.length);
        swap(arr, k, arr.length-1);
        quick_sort(arr, 0, arr.length-1);
    }

    private static void quick_sort(int[] arr, int start, int end) {
        if (start >= end) return ;
        int head = start;
        int line = start;
        int tail = end-1;
        int k = arr[end];
        while (head <= tail) {
            if (arr[head] < k) {
                swap(arr,head++,line++);
            } else if (arr[head] == k){
                head++;
            } else {
                swap(arr,head,tail--);
            }
        }
        swap(arr,head,end);
        quick_sort(arr, start, line-1);
        quick_sort(arr, head, end);
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
    public static void main(String[] args) {
        int[] arr = {3, 5, 9, 7, 6,10};
        quick_sort(arr);
        Arrays.stream(arr).forEach(System.out::println);
    }

}
