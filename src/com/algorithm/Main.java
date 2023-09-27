package com.algorithm;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author hugaojun Email:nat17185546@163.com
 * @create 2023-12-15-[上午 10:14]-周五
 */
public class Main {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i ++) {
            arr[i] = in.nextInt();
        }

        merge_sort(arr, 0, n - 1);

        for (int i = 0; i < n; i ++) {
            System.out.print(arr[i] + "");
        }
    }

    private static void merge_sort(int[] arr, int l, int r) {
        if (l >= r) return;
        int mid = l + r >> 1;
        merge_sort(arr, l , mid);
        merge_sort(arr, mid + 1, r);
        // l - r + 1 Wrong!!
        //int[] tmp = new int[l - r + 1];
        int[] tmp = new int[r - l + 1];
        int k = 0, i = l, j = mid + 1;

        System.out.println("$" + Arrays.toString(arr));
        while (i <= mid && j <= r) {
            if (arr[i] <= arr[j]) tmp[k ++] = arr[i ++];
            else tmp[k ++] = arr[j ++];
        }

        while (i <= mid) tmp[k ++] = arr[i ++];
        while (j <= r) tmp[k ++] = arr[j ++];

        for (i = l , j = 0; i <= r; j ++, i ++) {
            arr[i] = tmp[j];
        }

        System.out.println(Arrays.toString(arr));
    }
}
