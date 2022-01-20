package com.dai;

import java.util.Arrays;


public class 插排 {
    static void sort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0 ; j--) {
                if (arr[j] < arr[j-1]) {
                    swap(arr,j-1,j);
                }
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = {3, 5, 20, 7, 1,10};
        sort(arr);
        Arrays.stream(arr).forEach(System.out::println);
    }
}
