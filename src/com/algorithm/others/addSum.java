package com.algorithm.others;

import org.junit.Test;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author hugaojun Email:nat17185546@163.com
 * @create 2024-03-29-[上午 9:53]-周五
 */
public class addSum {

    // 暴力方法求前缀和
    public static void main(String[] args) {

        int[] nums = new int[] {1,2,3,4,5,6};
        int n = nums.length;
        int[] preSum = new int[n];

        for(int i = 0; i < n; i ++ ) {
            int curSum = 0;
            for(int j = 0; j <= i; j ++ ) {
                curSum += nums[j];
            }
            preSum[i] = curSum;
        }

        System.out.println(Arrays.toString(preSum));
    }

    private static final int N = 1010;
    private static int[] arr = new int[N];
    private static int[] brr = new int[N];

    @Test
    public void test_Difference() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        for(int i = 1; i <= n; i ++ ) {
            arr[i] = in.nextInt();
        }

        // 初始化差分数组
        for(int i = 1; i <= n; i ++ ) {
            insert(brr, i, i, arr[i]);
        }

        for(int i = 1; i <= n; i ++ ) {
            System.out.print(brr[i] + " ");
        }

        while (m-- > 0) {
            int l = in.nextInt();
            int r = in.nextInt();
            int c = in.nextInt();
            insert(brr, l, r, c);
        }

        for(int i = 1; i <= n; i ++ ) {
            arr[i] = brr[i] + arr[i - 1];
            System.out.println(Arrays.toString(arr));
        }

//        for(int i = 1; i <= n; i ++ ) {
//            brr[i] += brr[i - 1];
//        }
//
//        for(int i = 1; i <= n; i ++ ) {
//            System.out.print(brr[i] + " ");
//        }
    }

    public static void insert(int[] brr, int l, int r, int c) {
        brr[l] += c;
        brr[r + 1] -= c;
    }
}
