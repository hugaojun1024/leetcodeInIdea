package com.leetcode.acwing;

import java.util.Scanner;

/**
 * @author hugaojun Email:nat17185546@163.com
 * @create 2023-03-07-[上午 9:52]-周二
 */
public class No798_DifferenceMatrix {

    private static final int N = 1010;


    private static void insert(int[][] b, int x1, int y1, int x2, int y2, int c) {
        b[x1][y1] += c;
        b[x2 + 1][y1] -= c;
        b[x1][y2 + 1] -= c;
        b[x2 + 1][y2 + 1] += c;
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int q = in.nextInt();
        int[][] arr = new int[N][N];
        int[][] b = new int[N][N];

        for(int i = 1; i <= n;  i++)
            for(int j = 1; j <= m; j++)
                arr[i][j] = in.nextInt();

        for(int i = 1; i <= n; i++)
            for(int j = 1; j <= m; j++)
                insert(b, i, j, i, j , arr[i][j]);

        while (q-- != 0) {
            int x1 = in.nextInt();
            int y1 = in.nextInt();
            int x2 = in.nextInt();
            int y2 = in.nextInt();
            int c = in.nextInt();
            insert(b, x1, y1, x2, y2, c);
        }

        //求前置和
        for(int i = 1; i <= n; i++)
            for(int j = 1; j <= m; j++)
                b[i][j] = b[i][j - 1] + b[i - 1][j] - b[i- 1][j - 1];

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                System.out.print(b[i][j] + " ");
            }
            System.out.println();
        }
    }
}
