package com.leetcode.acwing;

import java.util.Scanner;
/**
 * @author hugaojun Email:nat17185546@163.com
 * @create 2023-03-02-[下午 9:49]-周四
 */
public class No787_MergeSort {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] arr = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = scan.nextInt();
        }

        merge_sort(arr, 0, n - 1);

        for(int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    //归并排序
    private static void merge_sort(int[] arr, int l , int r) {
        //递归结束条件
        if (l >= r) return;

        int mid = l + ((r - l) >> 1);
        merge_sort(arr, l, mid);
        merge_sort(arr, mid + 1, r);

        int[] tmp = new int[r - l + 1];// 临时数组, 用于临时存储 [l,r]区间内排好序的数据
        int i = l, j = mid + 1, k = 0;

        while (i <= mid && j <= r ) {
            if (arr[i] <= arr[j]) tmp[k++] = arr[i++];
            else tmp[k++] = arr[j++];
        }

        while (i <= mid) tmp[k++] = arr[i++];
        while (j <= r) tmp[k++] = arr[j++];

        for( i= l, j = 0; i <= r; i++, j++) {
            arr[i] = tmp[j];
        }
    }
}
