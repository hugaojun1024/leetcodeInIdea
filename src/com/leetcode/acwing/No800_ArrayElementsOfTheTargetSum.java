package com.leetcode.acwing;

import java.util.Scanner;

/**
 * 800. 数组元素的目标和
 * @author hugaojun Email:nat17185546@163.com
 * @create 2023-03-22-[下午 4:55]-周三
 */
public class No800_ArrayElementsOfTheTargetSum {

    private static int N = 100010;
    private static int[] a = new int[N];
    private static int[] b = new int[N];

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int x = in.nextInt();

        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        for (int i = 0; i < m; i++) {
            b[i] = in.nextInt();
        }
        for(int i = 0, j = m - 1; i < n; i ++) {
            while (j > 0 && a[i] + b[j] > x) {
                j --;
            }
            if (a[i] + b[j] == x) {
                System.out.println(i + " " + j);
                break;
            }
        }
    }
}
