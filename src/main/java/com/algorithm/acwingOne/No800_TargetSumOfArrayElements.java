package com.algorithm.acwingOne;

import java.util.Scanner;

/**
 * 给定两个升序排序的有序数组 A 和 B ，以及一个目标值 x 。
 * <p>
 * 数组下标从 0 开始。
 * <p>
 * 请你求出满足 A[i]+B[j]=x 的数对 (i,j)。
 * <p>
 * 数据保证有唯一解。
 * <p>
 * 输入格式
 * 第一行包含三个整数 n,m,x ，分别表示 A 的长度，B 的长度以及目标值 x 。
 * <p>
 * 第二行包含 n个整数，表示数组 A 。
 * <p>
 * 第三行包含 m 个整数，表示数组 B。
 * <p>
 * 输出格式
 * 共一行，包含两个整数 i 和 j 。
 * <p>
 * 数据范围
 * 数组长度不超过 105。
 * <p>
 * 同一数组内元素各不相同。
 * 1≤数组元素≤109
 * <p>
 * 输入样例：
 * 4 5 6
 * 1 2 4 7
 * 3 4 6 8 9
 * <p>
 * 输出样例：
 * 1 1
 *
 * @author hugaojun Email:nat17185546@163.com
 * @create 2024-04-03-[下午 3:47]-周三
 */
public class No800_TargetSumOfArrayElements {

    static int N = 100010;
    static int[] a = new int[N];
    static int[] b = new int[N];

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int x = in.nextInt();
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        for (int i = 0; i < m; i++) {
            b[i] = in.nextInt();
        }

        for(int i = 0, j = m - 1; i < n; i ++ ) {
            while (j >= 0 && a[i] + b[j] > x) j --;
            if (a[i] + b[j] == x) {
                System.out.println(i + " " + j);
                break;
            }
        }
    }
}
