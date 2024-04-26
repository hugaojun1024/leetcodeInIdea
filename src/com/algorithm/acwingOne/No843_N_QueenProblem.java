package com.algorithm.acwingOne;

import java.util.Scanner;

/** N皇后问题 DFS
 * @author hugaojun Email:nat17185546@163.com
 * @create 2024-04-11-[上午 10:36]-周四
 */
public class No843_N_QueenProblem {

    private static final int N = 20;
    private static int n;
    private static char[][] g = new char[N][N]; //g[N][N]用来存路径
    // col列，dg对角线，udg反对角线
    private static boolean[] col = new boolean[N];
    private static boolean[] dg = new boolean[N];
    private static boolean[] udg = new boolean[N];

    private static void dfs(int u) {
        if (u == n) {
            for (int i = 0; i < n; i ++) {
                for (int j = 0; j < n; j ++) {
                    System.out.print(g[i][j]);
                }
                System.out.println();
            }
            System.out.println();
        }

        for (int i = 0; i < n; i ++) {
            if (!col[i] && !dg[i - u + n] && !udg[i + u]) {
                col[i] = dg[i - u + n] = udg[i + u] = true;
                g[u][i] = 'Q';
                dfs(u + 1);
                g[u][i] = '.';
                col[i] = dg[i - u + n] = udg[i + u] = false;
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        for (int i = 0; i < n; i ++)
            for (int j = 0; j < n; j ++)
                g[i][j] = '.';
        dfs(0);
    }
}