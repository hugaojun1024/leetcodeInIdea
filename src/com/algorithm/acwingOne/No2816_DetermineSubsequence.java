package com.algorithm.acwingOne;

import java.util.Scanner;

/** 子序列--双指针
 * 给定一个长度为 n的整数序列 a1,a2,…,an以及一个长度为 m 的整数序列 b1,b2,…,bm。
 *
 * 请你判断 a 序列是否为 b 序列的子序列。
 *
 * 子序列指序列的一部分项按原有次序排列而得的序列，例如序列 {a1,a3,a5} 是序列 {a1,a2,a3,a4,a5} 的一个子序列。
 *
 * 输入格式
 * 第一行包含两个整数 n,m。
 *
 * 第二行包含 n 个整数，表示 a1,a2,…,an。
 *
 * 第三行包含 m 个整数，表示 b1,b2,…,bm。
 *
 * 输出格式
 * 如果 a 序列是 b序列的子序列，输出一行 Yes。 否则，输出 No。
 *
 * 数据范围
 * 1≤n≤m≤105,
 * −109≤ai,bi≤109
 *
 * 输入样例：
 * 3 5
 * 1 3 5
 * 1 2 3 4 5
 *
 * 输出样例：
 * Yes
 *
 * @author hugaojun Email:nat17185546@163.com
 * @create 2024-04-07-[上午 10:15]-周日
 */
public class No2816_DetermineSubsequence {

    static final int N = 100010;
    static int[] a = new int[N];
    static int[] b = new int[N];

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        for(int i = 0; i < n; i ++) {
            a[i] = in.nextInt();
        }
        for(int i = 0; i < m; i ++) {
            b[i] = in.nextInt();
        }
        int i = 0, j = 0;
        for(;i < n && j < m; j ++) {
            if (a[i] == b[j]) i ++;
        }
        if (i == n) System.out.println("Yes");
        else System.out.println("No");
    }
}
