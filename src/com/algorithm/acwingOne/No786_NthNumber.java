package com.algorithm.acwingOne;

import java.util.Scanner;

/**
 * @author hugaojun Email:nat17185546@163.com
 * @create 2023-03-03-[下午 10:16]-周五
 */
public class No786_NthNumber {

    private static int N = 100010;
    private static int[] arr = new int[N];

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int k = scan.nextInt();

        for(int i = 0; i < n; i++) {
            arr[i] = scan.nextInt();
        }

        int l = 0, r = n - 1;
        //传入参数为下标k-1
        System.out.println(quick_sort(l, r, k - 1));
    }

    private static int quick_sort(int l, int r, int k) {

        if (l == r) return arr[l];
        int x = arr[l + r >> 1];
        int i = l - 1, j = r + 1;
        while (i < j) {
            do {
                i++;
            } while (arr[i] < x);
            do {
                j--;
            } while (arr[j] > x);

            if (i < j) {
                swap(arr, i, j);
            }
        }
        int sl = j - l + 1;
        if (k <= sl) return quick_sort(l, j, k);
        else return quick_sort(j + 1, r, k - sl);
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
