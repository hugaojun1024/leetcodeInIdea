package com.algorithm.acwingOne;

import java.util.Scanner;
/** 归并排序
 * 给定你一个长度为 n 的整数数列。
 *
 * 请你使用归并排序对这个数列按照从小到大进行排序。并将排好序的数列按顺序输出。
 *
 * 输入格式
 * 输入共两行，第一行包含整数 n
 *
 * 第二行包含 n 个整数（所有整数均在 1∼109 范围内），表示整个数列。
 *
 * 输出格式
 * 输出共一行，包含 n个整数，表示排好序的数列。
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
 * @create 2023-03-02-[下午 9:49]-周四
 * @update 2023-04-01-[上午 9:49]-周一
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

        // 临时数组, 用于临时存储 [l,r]区间内排好序的数据
        int[] tmp = new int[r - l + 1];
        int i = l, j = mid + 1, k = 0;

        while (i <= mid && j <= r ) {
            if (arr[i] <= arr[j]) tmp[k++] = arr[i++];
            else tmp[k++] = arr[j++];
        }

        while (i <= mid) tmp[k++] = arr[i++];
        while (j <= r) tmp[k++] = arr[j++];

        for( i= l, j = 0; i <= r; i++, j++) { // ?为什么从l开始,不是从0开始
            arr[i] = tmp[j];
        }
    }

}
