package com.algorithm.acwingOne;

import java.util.Scanner;

/**单调队列
 * 给定一个大小为 n≤106 的数组。有一个大小为 k 的滑动窗口，它从数组的最左边移动到最右边。
 * 你只能在窗口中看到 k 个数字。次滑动窗口向右移动一个位置。
 *
 * 以下是一个例子：
 * 该数组为 [1 3 -1 -3 5 3 6 7]，k 为 3 。
 *
 * 窗口位置	最小值	最大值
 * [1 3 -1] -3 5 3 6 7	-1	3
 * 1 [3 -1 -3] 5 3 6 7	-3	3
 * 1 3 [-1 -3 5] 3 6 7	-3	5
 * 1 3 -1 [-3 5 3] 6 7	-3	5
 * 1 3 -1 -3 [5 3 6] 7	3	6
 * 1 3 -1 -3 5 [3 6 7]	3	7
 *
 * 你的任务是确定滑动窗口位于每个位置时，窗口中的最大值和最小值。
 *
 * 输入格式
 * 输入包含两行。
 *
 * 第一行包含两个整数 n 和 k ，分别代表数组长度和滑动窗口的长度。
 *
 * 第二行有 n 个整数，代表数组的具体数值。 同行数据之间用空格隔开。
 *
 * 输出格式 输出包含两个。
 *
 * 第一行输出，从左至右，每个位置滑动窗口中的最小值。
 * 第二行输出，从左至右，每个位置滑动窗口中的最大值。
 *
 * 输入样例：
 * 8 3
 * 1 3 -1 -3 5 3 6 7
 * 输出样例：
 * -1 -3 -3 -3 3 3
 * 3 3 5 5 6 7
 * 难度：简单
 * 时/空限制：1s / 64MB
 *
 * @author hugaojun Email:nat17185546@163.com
 * @create 2024-04-02-[下午 5:58]-周二
 */
public class No154_SlidingWindow2 {

    static int N = 1000010;
    static int a[] = new int[N];
    static int q[] = new int[N];
    static int hh = 0, tt = -1;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();

        for(int i = 0; i < n; i ++) {
            a[i] = in.nextInt();
        }

        for(int i = 0; i < n; i ++) {
            while (hh <= tt && a[q[tt]] >= a[i]) tt--;
            q[++ tt] = i;
            if (q[hh] < i - k + 1) hh ++;
            if (i + 1>= k) System.out.print(a[q[hh]] + " ");
        }

        System.out.println();
        hh = 0;tt = -1;

        for(int i = 0; i < n; i ++) {  // i = 0, i + 1 >= k; i = 1, i >= k
            while (hh <= tt && a[q[tt]] <= a[i]) tt--;
            q[++ tt] = i;
            if (q[hh] < i - k + 1) hh ++;
            if (i + 1>= k) System.out.print(a[q[hh]] + " ");
        }
    }
}
