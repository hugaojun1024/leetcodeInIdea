package com.algorithm.acwingOne;

import java.util.Scanner;

/**
 * @author hugaojun Email:nat17185546@163.com
 * @create 2023-03-09-[下午 5:03]-周四
 */
public class No801_TheNumberOfOnesInBinarytheNumberOfOnesInBinary {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        while (n-- != 0) {
            int x = in.nextInt();
            int res = 0;
            while (x != 0) {
                x -= lowbit(x);
                res ++;
            }
            System.out.print(res + " ");
        }
    }

    private static int lowbit(int x) {
        return x & -x;
    }
}
