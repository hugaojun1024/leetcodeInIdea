package com.algorithm.acwingOne;

import java.util.Scanner;

/**
 * 795. 前缀和
 *
 * 输入一个长度为 n 的整数序列。
 *
 * 接下来再输入 m 个询问，每个询问输入一对 l,r。
 *
 * 对于每个询问，输出原序列中从第 l 个数到第 r 个数的和。
 *
 * 输入格式
 * 第一行包含两个整数 n 和 m。
 *
 * 第二行包含 n 个整数，表示整数数列。
 *
 * 接下来 m 行，每行包含两个整数 l 和 r，表示一个询问的区间范围。
 *
 * 输出格式
 * 共 m 行，每行输出一个询问的结果。
 *
 * 数据范围
 * 1≤l≤r≤n,
 * 1≤n,m≤100000,
 * −1000≤数列中元素的值≤1000
 *
 * 输入样例：
 * 5 3
 * 2 1 3 6 4
 * 1 2
 * 1 3
 * 2 4
 * 输出样例：
 * 3
 * 6
 * 10
 * https://www.acwing.com/problem/content/797/
 *
 * @author hugaojun Email:nat17185546@163.com
 * @create 2023-03-06-[下午 2:42]-周一
 */
public class No795_PrefixSum {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        final int N = 100010;
        int[] arr = new int[N];
        int[] s = new int[N];

        for(int i = 1; i <= n; i++) {
            arr[i] = scan.nextInt();
        }
        for(int i = 1; i <= n; i++) {   //前缀和的初始化
            s[i] = s[i - 1] + arr[i];
        }

        while (m-- != 0) {
            int l = scan.nextInt();
            int r = scan.nextInt();
            System.out.print(s[r] - s[l - 1]);  //区间和的计算
        }
    }
}
