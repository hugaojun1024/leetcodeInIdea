package com.algorithm.acwingOne;

import java.util.Scanner;

/**
 * @author hugaojun Email:nat17185546@163.com
 * @create 2024-04-03-[上午 9:20]-周三
 */
public class No829_SimulationQueue {

    static int N = 100010;
    static int[] q = new int[N];
    static int hh = 0, tt = -1;
//    [static int hh = 1, tt = 0;

    static void push(int x) { //向队尾插入一个数x
        q[++ tt] = x;
    }

    static void pop() { //从队头弹出一个数
         hh ++;
    }

    static String empty() { //判断队列是否为空
        // 空: hh > tt 当 tt == hh 时,队列中有一个元素
        // if (hh >= tt) return "YES";
        if (hh > tt) return "YES";
        return "NO";
    }

    static int query() { //查询队头元素
        return q[hh];
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();

        while (m -- > 0) {
            String s = in.next();
            if (s.equals("push")) {
                int x = in.nextInt();
                push(x);
            } else if (s.equals("pop")) {
                pop();
            } else if (s.equals("empty")) {
                System.out.println(empty());
            } else if (s.equals("query")) {
                System.out.println(query());
            }
        }
    }
}
