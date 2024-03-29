package com.algorithm.acwingOne;

import java.util.Scanner;

/**
 *
 * 797. 差分
 *
 * 输入一个长度为 n 的整数序列。
 *
 * 接下来输入 m 个操作，每个操作包含三个整数 l,r,c，表示将序列中 [l,r] 之间的每个数加上 c。
 *
 * 请你输出进行完所有操作后的序列。
 *
 * 输入格式
 * 第一行包含两个整数 n 和 m。
 *
 * 第二行包含 n 个整数，表示整数序列。
 *
 * 接下来 m 行，每行包含三个整数 l，r，c，表示一个操作。
 *
 * 输出格式
 * 共一行，包含 n 个整数，表示最终序列。
 *
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
 *
 * https://www.acwing.com/problem/content/799/
 * @author hugaojun Email:nat17185546@163.com
 * @create 2023-03-06-[下午 9:37]-周一
 */
public class No797_Difference {

    private static final int N = 1010;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] arr = new int[N];
        int[] brr = new int[N];

        for(int i = 1; i <= n; i++) {
            arr[i] = scan.nextInt();
        }

        for(int i = 1; i <= n; i++) {
            insert(brr, i, i, arr[i]);
        }

        for(int i = 1; i <= n; i++) {
            brr[i] = brr[i - 1];
        }

        for(int i = 1; i <= n; i++) {
            System.out.println(brr[i] + " ");
        }
    }

    public static void insert(int[] brr, int r, int l, int c) {
        brr[l] += c;
        brr[r + 1] -= c;
    }
}
