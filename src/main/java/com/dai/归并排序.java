package com.dai;

import java.util.Arrays;

public class 归并排序 {
    static void merge_sort(int[] arr) {
        int[] tmp = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            tmp[i] = arr[i];
        }
        merge_sort(arr, tmp, 0 ,arr.length-1);
        Arrays.stream(arr).forEach(System.out::println);
    }

    private static void merge_sort(int[] arr, int[] tmp, int i, int j) {
        if (i == j) return ;
        int mid = (i+j)/2;
        merge_sort(arr,tmp, i, mid);
        merge_sort(arr,tmp, mid+1, j);
        merge(arr,tmp, mid, i, j);
    }

    private static void merge(int[] arr, int[] tmp, int mid, int i, int j) {
        int left = i;
        int right = mid+1;
        for (int k = i; k <= j ; k++) {
            if (left <= mid && right <= j) {
                if (arr[left] <= arr[right]) {
                    tmp[k] = arr[left++];
                    continue;
                } else {
                    tmp[k] = arr[right++];
                    continue;
                }
            }
            if (right <= j) {
                tmp[k] = arr[right++];
            }
            if (left <= mid) {
                tmp[k] = arr[left++];
            }
        }
        for (int k = i; k <= j; k++) {
            arr[k] = tmp[k];
        }

    }

    public static void main(String[] args) {
        int[] arr = new int[]{8,7,1,5,4,1};
        merge_sort(arr);
    }
}
