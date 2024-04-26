package com.algorithm.acwingOne;

import java.util.Scanner;

/** 单调栈
 * 给定一个长度为 N的整数数列，输出每个数左边第一个比它小的数，如果不存在则输出 −1 。
 *
 * 输入格式
 * 第一行包含整数 N，表示数列长度。
 * 第二行包含 N 个整数，表示整数数列。
 *
 * 输出格式 共一行，包含 N 个整数，其中第 i 个数表示第 i 个数的左边第一个比它小的数，如果不存在则输出 −1。
 *
 * 数据范围
 * 1≤N≤105
 *
 * 1≤数列中元素≤109
 * 输入样例：
 * 5
 * 3 4 2 7 5
 * 输出样例：
 * -1 3 -1 2 2
 *
 * @author hugaojun Email:nat17185546@163.com
 * @create 2024-04-02-[下午 4:28]-周二
 */
public class No830_MonotoneStack2 {

    static int N = 10;
    static int[] stk = new int[N];
    static int tt;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        while (n -- > 0) {
            int x = in.nextInt();
            while (tt > 0 && stk[tt] >= x) tt --; //如果栈顶元素大于当前待入栈元素，则出栈
            if (tt <= 0) System.out.print("-1 "); //如果栈空，则没有比该元素小的值。
            else System.out.print(stk[tt] + " "); //栈顶元素就是左侧第一个比它小的元素
            stk[++ tt] = x;
            //System.out.println("||" + tt + " :: " +  Arrays.toString(stk));
        }
    }
}
