package com.leetcode.acwing;

import java.util.Scanner;

/**
 * @author hugaojun Email:nat17185546@163.com
 * @create 2023-03-28-[上午 8:52]-周二
 */
public class No837_TheNumberOfPointsInTheConnectedBlock {

    private static int N = 100010;
    private static int[] p = new int[N];
    private static int[] size = new int[N];
//    private static int n, m;

    private static int find(int x) {
        if (x != p[x]) p[x] = find(p[x]);
        return p[x];
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();

        for (int i = 0; i <= n; i++) {
            p[i] = i;
            size[i] = 1;
        }

        int a, b;
        String opt;
        while (m-- != 0) {
            opt = in.next();
            if (opt.equals("C")) {
                a = in.nextInt();
                b = in.nextInt();
                if (find(a) == find(b)) continue;
                size[find(b)] += size[find(a)];
                p[find(a)] = find(b);
            } else if (opt.equals("Q1")) {
                a = in.nextInt();
                b = in.nextInt();
                if (find(a) == find(b)) System.out.println("Yes");
                else System.out.println("No");
            } else {
                a = in.nextInt();
                System.out.println(size[find(a)]);
            }
        }
    }
}
