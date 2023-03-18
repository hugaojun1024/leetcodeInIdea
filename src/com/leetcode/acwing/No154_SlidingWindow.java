package com.leetcode.acwing;

import java.io.IOException;
import java.util.Scanner;

/**
 * @author hugaojun Email:nat17185546@163.com
 * @create 2023-03-18-[下午 6:17]-周六
 */
public class No154_SlidingWindow {

    static final int len = 1000010;
    static int a[], q[], tt, hh;

    static void init() {
        q = new int[len];
        tt = -1; //对尾
        hh = 0; //对头
    }

    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int n = Integer.parseInt(br.readLine());

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        a = new int[len];
        for (int i = 0; i < n; i++) {
            a[i ++] = in.nextInt();
        }
        init();
        for (int i = 0; i < n; i ++ ) {
            //判断对头是否已经滑出窗口
            if (hh <= tt && i - k + 1 > q[hh]) hh ++;
            while (hh <= tt && a[q[tt]] >= a[i]) tt --;//出队 //双端队列
            q[ ++ tt] = i;
            if (i >= k - 1) System.out.print(a[q[hh]] + " ");
        }
        System.out.println();

        init();
        for (int i = 0; i < n; i ++ ) {
            //判断对头是否已经滑出窗口
            if (hh <= tt && i - k + 1 > q[hh]) hh ++;
            while (hh <= tt && a[q[tt]] <= a[i]) tt --;
            q[ ++ tt] = i;
            if (i >= k - 1) System.out.print(a[q[hh]] + " ");
        }
        System.out.println();

    }
}
