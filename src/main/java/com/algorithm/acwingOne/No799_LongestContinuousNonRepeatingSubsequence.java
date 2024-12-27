package com.algorithm.acwingOne;

import java.util.Scanner;

/** 最长连续不重复子序列--双指针
 * 给定一个长度为 n 的整数序列，请找出最长的不包含重复的数的连续区间，输出它的长度。
 *
 * 输入格式
 * 第一行包含整数 n。
 *
 * 第二行包含 n 个整数（均在 0∼105 范围内），表示整数序列。
 *
 * 输出格式
 * 共一行，包含一个整数，表示最长的不包含重复的数的连续区间的长度。
 *
 * 数据范围
 * 1≤n≤105
 * 输入样例：
 * 5
 * 1 2 2 3 5
 * 输出样例：
 * 3
 *
 * @author hugaojun Email:nat17185546@163.com
 * @create 2023-03-09-[上午 9:20]-周四
 * @update 2024-04-03-[上午 9:20]-周三
 */
public class No799_LongestContinuousNonRepeatingSubsequence {

    static int N = 100010;
    static int[] a = new int[N];
    static int[] s = new int[N];

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(), r = 0;
        for(int i = 0; i < n; i ++) {
            a[i] = in.nextInt();
        }
        for(int i = 0, j = 0; i < n; ++ i) {
            ++ s[a[i]];
            while (s[a[i]] > 1) --s[a[j++]];
            r = Math.max(r, i - j + 1);
        }
        System.out.println(r);
    }
}
