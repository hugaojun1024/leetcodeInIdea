package com.leetcode.acwing;

import java.util.Scanner;

/**
 * @author hugaojun Email:nat17185546@163.com
 * @create 2023-03-24-[下午 3:26]-周五
 */
public class No835_TrieStringStatistics {

    private static int N = 100010;
    private static int son[][] = new int[N][26];
    private static int cnt[] = new int[N];
    private static char str[] = new char[N];
    private static int idx;

    private static void insert(char[] str) {
        int p = 0;
        for (int i = 0; i < str.length; i++) {
            int u = str[i] - 'a';
            if (son[p][u] == 0) son[p][u] = ++idx;
            p = son[p][u];
        }
        cnt[p]++;
    }

    private static int query(char[] str) {
        int p = 0;
        for (int i = 0; i < str.length; i++) {
            int u = str[i] - 'a';
            if (son[p][u] == 0) return 0;
            p = son[p][u];
        }
        return cnt[p];
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        while (n-- > 0) {
            String op = in.next();
            String str = in.next();
            if ("I".equals(op)) {
                insert(str.toCharArray());
            } else if ("Q".equals(op)) {
                System.out.println(query(str.toCharArray()));
            }
        }
    }

}
