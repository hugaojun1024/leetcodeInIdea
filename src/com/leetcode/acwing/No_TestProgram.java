package com.leetcode.acwing;

import java.util.Scanner;

/**
 * @author hugaojun Email:nat17185546@163.com
 * @create 2023-03-11-[上午 10:33]-周六
 */
public class No_TestProgram {


    private static final int N = 100010;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[N];

        for(int i = 0; i < n; i++ ) {
            arr[i] = in.nextInt();
        }

        quick_sort(arr, 0, n - 1);

        for(int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void quick_sort(int[] arr, int l , int r) {
        if (l >= r) return;
        int mid = l + r >> 1;

        quick_sort(arr, l, mid);
        quick_sort(arr, mid + 1, r);
        int i = l, j = mid + 1, k = 0;
        int[] temp = new int[r - l + 1];
        while (i <= mid &&  j <= r) {
            if (arr[i] <= arr[j]) temp[k++] = arr[i++];
            else temp[k++] = arr[j++];
        }
        while (i <= mid) temp[k++] = arr[i++];
        while (j <= r) temp[k++] = arr[j++];

        for (i = l, j = 0; i <= r; i++, j++) {
            arr[i] = temp[j];
        }
    }
}
