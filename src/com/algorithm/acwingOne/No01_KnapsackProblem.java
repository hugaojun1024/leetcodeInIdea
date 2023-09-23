package com.algorithm.acwingOne;

import java.util.Scanner;

/**
 有 N件物品和一个容量是 V
 的背包。每件物品只能使用一次。

 第 i件物品的体积是 vi，价值是 wi。

 求解将哪些物品装入背包，可使这些物品的总体积不超过背包容量，且总价值最大。
 输出最大价值。

 输入格式
 第一行两个整数，N，V，用空格隔开，分别表示物品数量和背包容积。

 接下来有 N行，每行两个整数 vi,wi，用空格隔开，分别表示第 i件物品的体积和价值。

 输出格式
 输出一个整数，表示最大价值。

 数据范围 0<N,V≤1000

 0<vi,wi≤1000
 输入样例
 4 5
 1 2
 2 4
 3 4
 4 5

 输出样例：
 8
 * @author hugaojun Email:nat17185546@163.com
 * @create 2023-09-22-[上午 10:25]-周五
 */
public class No01_KnapsackProblem {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt(); // 物品数量
        int V = in.nextInt(); // 背包的容量

        // 一个长度为 N的数组，第i个元素表示第i个物品的体积
        int[] v = new int[N + 1];
        System.out.println(v.length);

        // 一个长度为 N的数组，第i个元素表示第i个物品的价值
        int[] w = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            v[i] = in.nextInt();
            w[i] = in.nextInt();
        }

        in.close();

        int[][] f = new int[N + 1][V + 1];
        f[0][0] = 0;

        for (int i = 1; i <= N; i++) {
            for (int j = 0; j <= V; j++) {
                f[i][j] = f[i - 1][j];
                if (j >= v[i]) f[i][j] = Math.max(f[i - 1][j], f[i - 1][j - v[i]] + w[i]);
            }
        }
        System.out.println(f[N][V]);
    }
}
