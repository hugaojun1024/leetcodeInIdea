package com.algorithm.acwingOne;

import java.util.Scanner;

/**
 * @author hugaojun Email:nat17185546@163.com
 * @create 2023-03-25-[下午 3:06]-周六
 */
public class No836_CombinedSet {

    private static int n, m;
    private static int N = 100010;
    private static int[] p = new int[N];

    private static int find(int x) {
        if (p[x] != x) p[x] = find(p[x]);
        return p[x];
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();

        //初始化p
        for (int i = 0; i < n; i++) {
            p[i] = i;
        }
        int a, b;
        String opt;
        while (m-- != 0) {
            opt = in.next();
            a = in.nextInt();
            b = in.nextInt();
            if (opt.equals("M")) {
                p[find(a)] = find(b);
            } else {
                if (find(a) == find(b)) System.out.println("Yes");
                else System.out.println("No");
            }
        }
    }
}
