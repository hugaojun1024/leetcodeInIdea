package com.algorithm.acwingOne;

import java.util.Scanner;
/** 快速排序
 * 给定你一个长度为 n的整数数列。
 *
 * 请你使用快速排序对这个数列按照从小到大进行排序。并将排好序的数列按顺序输出。
 *
 * 输入格式
 * 输入共两行，第一行包含整数 n
 *
 * 第二行包含 n 个整数（所有整数均在 1∼109 范围内），表示整个数列。
 *
 * 输出格式
 * 输出共一行，包含 n 个整数，表示排好序的数列。
 *
 * 数据范围
 * 1≤n≤100000
 * 输入样例：
 * 5
 * 3 1 2 4 5
 * 输出样例：
 * 1 2 3 4 5
 *
 * @author hugaojun Email:nat17185546@163.com
 * @create 2024-04-01-[上午 9:32]-周一
 */
public class No785_quickSort2 {
    private static final int N = 100010;
    private static int[] arr = new int[N];

    // Swap function
    public static void swap(int x, int y) {

        // Wrong!!
//        int temp = x;
//        x = y;
//        y = temp;

        // Wrong!!
//        int temp = x;
//        arr[x] = arr[y];
//        arr[y] = arr[temp];

        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;

    }

    // quick_sort function
    private static void quick_sort(int l, int r) {
        if (l >= r) return;
        //int x = arr[(l + r + 1) >> 1], i = l - 1, j = r + 1; //MEmory limit error
        int i = l - 1, j = r + 1, x = arr[l + r >> 1];
        while (i < j) {
            do {i++;} while(arr[i] < x);
            do {j--;} while(arr[j] > x);

            // Through the above while loop
            // We find that x (x <= arr[i] && x >= arr[j])
            // Next we will swap the values of arr[i] & arr[j]

            // Conditions need to be added: if (i < j)
            // swap(i , j);
            if (i < j) swap(i , j);

            //在Java中，数组是按值传递的，因此不能直接交换数组元素值。
            //但是可以通过传递数组和元素索引来模拟交换元素的值。
        }

        // recursion
        quick_sort(l , j);
        quick_sort(j + 1 , r);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        // Input Element
        for(int i = 0; i < n; i++ ) {
            arr[i] = in.nextInt();
        }

        quick_sort(0, n - 1);
        // Output Element
        for(int i = 0; i < n; i++ ) {
            System.out.print(arr[i] + " ");
        }
    }
}
