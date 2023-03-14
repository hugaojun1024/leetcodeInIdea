package com.leetcode.acwing;

/**
 * @author hugaojun Email:nat17185546@163.com
 * @create 2023-03-09-[下午 2:47]-周四
 */
public class No_TheKDigitsInBinary {

    public static void main(String[] args) {
        int n = 10;
        for(int k = 3; k >= 0; k--) {
            System.out.print(n >> k & 1);
        }
    }
}
