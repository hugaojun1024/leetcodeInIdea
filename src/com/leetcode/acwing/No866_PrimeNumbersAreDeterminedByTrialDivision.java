package com.leetcode.acwing;

import java.util.Scanner;

/**
 * @author hugaojun Email:nat17185546@163.com
 * @create 2023-02-26-[下午 5:05]-周日
 */
public class No866_PrimeNumbersAreDeterminedByTrialDivision {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] a = new int[n];

        for(int i = 0; i < n; i++) {
            a[i] = scan.nextInt();
            System.out.println(a[i]);
            System.out.println(is_prime(a[i]));
        }
    }

    private static String is_prime(int n ) {
        if (n < 2) return "No";
        for(int i = 2; i <= n / i; i++) {
            if (n % i == 0)
                return "No";
        }
        return "Yes";
    }
}
