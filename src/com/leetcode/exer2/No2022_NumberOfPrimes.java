package com.leetcode.exer2;

import org.junit.Test;

import java.util.Scanner;

/**
 * [问题描述]
 * 给定正整数 n，请问有多少个质数是 n 的约数。
 *
 * [输入格式]
 * 输入的第一行包含一个整数 n。
 *
 * [输出格式]
 * 输出一个整数，表示 n 的质数约数个数。
 *
 * [样例输入]
 * 396
 * [样例输出]
 * 3
 * [样例说明]
 * 396 有 2.3.11 三个质数约数。
 *
 * [评测用例规模与约定]
 * 对于 30% 的评测用例，1≤ n ≤ 10000。
 * 对于 60% 的评测用例，1≤ n ≤  10^9。
 * 对于所有评测用例，1≤ n ≤ 10^16。
 *
 * @author hugaojun Email:nat17185546@163.com
 * @create 2023-02-19-[下午 4:08]-周日
 */
public class No2022_NumberOfPrimes {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        long n = scan.nextLong();

        int res = 0;
        double sqrt = Math.sqrt(n);
//        System.out.println(sqrt);

        for (int i = 2; i <= sqrt; i++) {
            if ((n % i) == 0 && judgeP(i)) {
                //System.out.println(i);
                res++;
            }
        }

        System.out.print(res);
    }

    //判断是否质数
    /*
    数论——质数：试除法判定质数
    https://zhuanlan.zhihu.com/p/415355724

    1 既不是质数也不是合数
    2 是最小的质数（也叫素数），也是唯一的偶质数，只有1、2两个因数，是一个有理数。2也是黑格纳数
     */
    public static boolean judgeP(long i) {

        //sqrt(x) 是调用了库函数，而每次判断的时候都会调用，效率会比较慢
        double sqrt = Math.sqrt(i);
        for (int j = 2; j <= sqrt; j++) {
            if (i % j == 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean judgeP2(long i) {

        for (int j = 2; j <= i / j ; j++) {
            if (i % j == 0) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void test() {
//        System.out.println(judgeP(10));
        System.out.println(judgeP2(9));
    }
}
