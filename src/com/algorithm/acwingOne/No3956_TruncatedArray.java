package com.algorithm.acwingOne;

import java.util.Scanner;

/**
 * @author hugaojun Email:nat17185546@163.com
 * @create 2023-02-12-[下午 10:09]-周日
 */
public class No3956_TruncatedArray {
    public static void main(String[] args) {

        final int N = 100010;
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] s = new int[N];

        for (int i = 1; i <= n; i++) {
            s[i] = in.nextInt();
            s[i] += s[i - 1];
        }

        if ((s[n] % 3) != 0 ) {
            System.out.println("0");
            return;
        }
        long res = 0;

        for (int i = 3, cnt = 0; i <= n; i++) {
            if (s[i - 2] == s[n] / 3) cnt++;
            if (s[n] - s[i - 1] == s[n] / 3) res += cnt;
        }
    }
}
