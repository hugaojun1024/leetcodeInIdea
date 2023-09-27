package com.algorithm.acwingOne;

import java.util.Scanner;

public class No785_quickSort {

    private static final int N = 100010;
    private static int[] arr = new int[N];

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for(int i = 0; i < n; i++ ) {
            arr[i] = in.nextInt();
        }

        // for(int i = 0; i < n; i++ ) {
        //     System.out.print(arr[i] + " ");
        // }

        quick_sort(0, n - 1);

        for(int i = 0; i < n; i++ ) {
            System.out.print(arr[i] + " ");
        }
    }

    private static void quick_sort(int l, int r) {
        if (l >= r ) return;
        int i = l - 1, j = r + 1, x = arr[l + r >> 1];
        while (i < j) {
            do
                i++;
             while (arr[i] < x);
            do
                j--;
             while (arr[j] > x);

            //swap function
            if (i < j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        quick_sort(l, j);
        quick_sort(j + 1, r);
    }
}