package com.leetcode.acwing;

import java.util.Scanner;

/**
 * @author hugaojun Email:nat17185546@163.com
 * @create 2023-03-09-[上午 9:20]-周四
 */
public class No799_LongestContinuousNonRepeatingSubsequence {

    private static final int N= 100010;
    private static int[] arr = new int[N];
    private static int[] s = new int[N];


    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for(int i = 0; i < n; i ++ ) {
            arr[i] = in.nextInt();
        }
        int res = 0;

        for(int i = 0, j = 0; i < n; i ++ ) {
            s[arr[i]] ++;
            while (s[arr[i]] > 1) {
                s[arr[j]] --;
                j ++;
            }

            res = Math.max(res, i - j + 1);
        }

        System.out.println(res);
    }
}
