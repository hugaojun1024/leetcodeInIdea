package com.algorithm.acwingOne;

import java.util.Scanner;

/**
 * 797. 差分
 * <p>
 * 输入一个长度为 n 的整数序列。
 * <p>
 * 接下来输入 m 个操作，每个操作包含三个整数 l,r,c，表示将序列中 [l,r] 之间的每个数加上 c。
 * <p>
 * 请你输出进行完所有操作后的序列。
 * <p>
 * 输入格式
 * 第一行包含两个整数 n 和 m。
 * <p>
 * 第二行包含 n 个整数，表示整数序列。
 * <p>
 * 接下来 m 行，每行包含三个整数 l，r，c，表示一个操作。
 * <p>
 * 输出格式
 * 共一行，包含 n 个整数，表示最终序列。
 * <p>
 * 数据范围
 * 1≤n,m≤100000,
 * 1≤l≤r≤n,
 * −1000≤c≤1000,
 * −1000≤整数序列中元素的值≤1000
 * 输入样例：
 * 6 3
 * 1 2 2 1 2 1
 * 1 3 1
 * 3 5 1
 * 1 6 1
 * 输出样例：
 * 3 4 5 3 4 2
 * <p>
 * https://www.acwing.com/problem/content/799/
 *
 * @author hugaojun Email:nat17185546@163.com
 * @create 2023-03-06-[下午 9:37]-周一
 * @update 2024-03-29-[下午 3:37]-周五
 */
public class No797_Difference {

    private static final int N = 1010;
    private static int[] arr = new int[N];
    private static int[] brr = new int[N];

    private static void insert(int l, int r, int c) {
        brr[l] += c;
        brr[r + 1] -= c;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        //初始化arr,下标从1开始
        for (int i = 1; i <= n; i ++ ) {
            arr[i] = in.nextInt();
        }
        //初始化brr,下标从1开始
        for (int i = 1; i <= n; i ++ ) {
            //insert(i, i, arr[i]); ②
            brr[i] = arr[i] - arr[i - 1];
        }
        while (m -- > 0) {
            int l = in.nextInt();
            int r = in.nextInt();
            int c = in.nextInt();
            insert(l, r, c);
        }
        //输出改变区间值arr
        for (int i = 1; i <= n; i ++ ) {
            arr[i] = arr[i - 1] + brr[i]; //前缀和计算
            System.out.print(arr[i] + " ");
        }
    }
}
