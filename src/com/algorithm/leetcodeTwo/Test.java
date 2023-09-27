package com.algorithm.leetcodeTwo;

import jdk.management.resource.internal.inst.SocketOutputStreamRMHooks;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author hugaojun Email:nat17185546@163.com
 * @create 2023-12-14-[上午 9:38]-周四
 */
public class Test {
    private static final int N = 10;
    private static int[] arr = new int[N];

    private static void quick_sort(int l , int r) {
        if (l >= r) return;
        int mid = l + r >> 1;
        int i = l - 1, j = r + 1;
        while (i < j) {
            do {i ++;} while (arr[i] < arr[mid]);
            do {j --;} while (arr[j] > arr[mid]);
            if (i < j) {
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }
        quick_sort(l, j);
        quick_sort(j + 1, r);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for(int i = 0; i < n; i ++ ) {
            arr[i] = in.nextInt();
        }
        //System.out.println(Arrays.toString(arr));

        quick_sort(0, n - 1);
        for(int i = 0; i < n; i ++ ) {
            System.out.print(arr[i] + " ");
        }

        //System.out.println(Arrays.toString(arr));
    }
}
