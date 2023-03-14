package com.leetcode.acwing;

import java.io.BufferedInputStream;
import java.util.Scanner;

public class No787_OrderByMerging {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        int n = in.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[n] = in.nextInt();
        }

        //归并排序
        merge_sort(arr, 0, n - 1);

        //打印输出
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i]  + " ");
        }
    }

    private static void merge_sort(int[] arr, int l, int r) {
        if (l >= r) return;
        int mid = 1 + r >> 1;
        merge_sort(arr, l, mid);
        merge_sort(arr, mid + 1, r);

        int[] tmp = new int[r - l + 1];
        int k = 0, i = l , j = mid + 1;
        while(i <= mid && j <= r) {
            if (arr[i] <= arr[j]) tmp[k++] = arr[i++];
            else tmp[k++] = arr[j++];
        }

        while (i <= mid) tmp[k++] = arr[i++];
        while (j <= r) tmp[k++] = arr[j++];

        // 进行赋值
        for (i = 1, j = 0; i <= r; i++, j++) {
            arr[i] = tmp[j];
        }
    }
}
