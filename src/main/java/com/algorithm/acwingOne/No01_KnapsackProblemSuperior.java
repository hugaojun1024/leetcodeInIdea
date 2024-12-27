package com.algorithm.acwingOne;

import java.util.Scanner;

/**
 * @author hugaojun Email:nat17185546@163.com
 * @create 2024-10-15-[下午 4:40]-周二
 */
public class No01_KnapsackProblemSuperior {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(); //物品数量
        int m = in.nextInt(); //背包容积

        int[] v = new int[n + 1]; //体积
        int[] w = new int[n + 1]; //价值
        //前 𝑖 个物品，背包容量 𝑗 下的最优解（最大价值)
        int[] f = new int[m + 1]; //状态表示

        for (int i = 1; i < n; i ++) {
            v[i] = in.nextInt();
            w[i] = in.nextInt();
        }

        for (int i = 1; i <= n; i ++) {
            for (int j = m; j >= v[i]; j --) {
                f[j] = Math.max(f[j], f[j - v[i]] + w[i]);
            }
        }

        System.out.println(f[m]);
    }
}
