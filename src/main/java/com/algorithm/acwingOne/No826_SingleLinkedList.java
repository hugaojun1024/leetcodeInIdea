package com.algorithm.acwingOne;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/** 数组模拟单链表
 * 实现一个单链表，链表初始为空，支持三种操作：向链表头插入一个数；删除第 k 个插入的数后面的一个数；
 * 在第 k 个插入的数后插入一个数。现在要对该链表进行 M 次操作，进行完所有操作后，从头到尾输出整个链表。
 *
 * 注意:题目中第 k 个插入的数并不是指当前链表的第 k 个数。例如操作过程中一共插入了 n 个数，
 * 则按照插入的时间顺序，这 n 个数依次为：第 1 个插入的数，第 2 插入的数，…第 n个插入的数。
 *
 * 输入格式
 * 第一行包含整数 M，表示操作次数。接下来 M 行，每行包含一个操作命令，操作命令可能为以下几种：
 * H x，表示向链表头插入一个数 x 。D k，表示删除第 k 个插入的数后面的数（当 k为 0 时，表示删除头结点）。
 * I k x，表示在第 k 个插入的数后面插入一个数 x （此操作中 k 均大于 0）。
 *
 * 输出格式 共一行，将整个链表从头到尾输出。
 *
 * 数据范围
 * 1≤M≤100000
 * 所有操作保证合法。
 *
 * 输入样例：
 * 10
 * H 9
 * I 1 1
 * D 1
 * D 0
 * H 6
 * I 3 6
 * I 4 5
 * I 4 5
 * I 3 4
 * D 6
 * 输出样例：
 * 6 4 6 5
 *
 * @author hugaojun Email:nat17185546@163.com
 * @create 2024-03-22-[上午 11:25]-周五
 */
public class No826_SingleLinkedList {

     private static int N = 100010; // 数据规模为 10w
     private static int head;       // 表示头结点的下标
     private static int[] e = new int[N];   // 表示结点 i的值
     private static int[] ne = new int[N];  // 表示结点 i的 next指针是多少
     private static int idx;//指针        // 表示存储当前结点已经使用结点的下一个结点

    //初始化
    public static void init() {
        head = -1;
        idx = 0;
    }

    // 将 val插到头结点
    public static void addToHead(int val) {
        e[idx] = val;
        ne[idx] = head;
        head = idx;
        idx ++;
    }

    // 将下标是 k的点后面的点删掉
    public static void remove(int k) {
        ne[k] = ne[ne[k]];
    }

    // 将 val插入下标为 k的点的后面
    public static void add(int k, int val) {
        e[idx] = val;
        ne[idx] = ne[k];
        ne[k] = idx;
        idx ++;
    }

    // 程序入口
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(reader.readLine());
        init(); // 初始化操作

        while (m -- > 0) {
            String[] s = reader.readLine().split(" ");
            if (s[0].equals("H")) {
                int x = Integer.parseInt(s[1]);
                addToHead(x);
            } else if (s[0].equals("D")) {
                int k = Integer.parseInt(s[1]);
                if (k == 0) {
                    head = ne[head];
                } else {
                    remove(k - 1);
                }
            } else if (s[0].equals("I")) {
                int k = Integer.parseInt(s[1]);
                int x = Integer.parseInt(s[2]);
                add(k - 1, x);
            }
        }

        for(int i = head; i != -1; i = ne[i]) {
            System.out.print(e[i] + " ");
        }
    }
}
