package com.algorithm.others;

import java.util.Scanner;

/**
 * @author hugaojun Email:nat17185546@163.com
 * @create 2023-09-22-[上午 11:19]-周五
 */
public class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int V = in.nextInt();

        int[] v = new int[N + 1];   // 第i个物品的体积
        int[] w = new int[N + 1];   // 第i个物品的价值

        for(int i = 1; i <= N; i++ ) {
            v[i] = in.nextInt();
            w[i] = in.nextInt();
        }

        in.close();

        int[][] f = new int[N + 1][V + 1];
        f[0][0] = 0;

        for(int i = 1; i <= N; i++ ) {
            for(int j = 0; j <= V; j++ ) {
                f[i][j] = f[i - 1][j];
                if (j >= v[i]) f[i][j] = Math.max(f[i - 1][j], f[i - 1][j - v[i]] + w[i]);
            }
        }

        System.out.println(f[N][V]);
    }
}
