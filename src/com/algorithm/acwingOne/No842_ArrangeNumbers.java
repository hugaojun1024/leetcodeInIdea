package com.algorithm.acwingOne;

import java.util.Scanner;

/** 全排列 DFS (深度优先遍历)
 * 给定一个整数 n，将数字 1∼n 排成一排，将会有很多种排列方法。
 * 现在，请你按照字典序将所有的排列方法输出。
 *
 * 输入格式 共一行，包含一个整数 n 。
 *
 * 输出格式 按字典序输出所有排列方案，每个方案占一行。
 *
 * 数据范围
 * 1≤n≤7
 *
 * 输入样例：
 * 3
 *
 * 输出样例：
 * 1 2 3
 * 1 3 2
 * 2 1 3
 * 2 3 1
 * 3 1 2
 * 3 2 1
 *
 * @author hugaojun Email:nat17185546@163.com
 * @create 2024-04-10-[上午 10:24]-周三
 */
public class No842_ArrangeNumbers {

    private static final int N = 10;
    private static int[] path = new int[N];
    private static int[] state = new int[N];
    private static int n;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        dfs(0);
    }

    private static void dfs(int u) {

        // u > n & i = 1 start & dfs(1)
//        if (u > n) {
//            for (int i = 1; i <= n; i ++) {
//                System.out.print(path[i] + " ");
//            }
//            System.out.println();
//        }

        if (u == n) {
            for (int i = 0; i < n; i ++) {
                System.out.print(path[i] + " ");
            }
            System.out.println();
        }

        for (int i = 1; i <= n; i ++) {
            if (state[i] == 0) {
                path[u] = i;
                state[i] = 1;
                dfs(u + 1);
                state[i] = 0;
            }
        }
    }
}
