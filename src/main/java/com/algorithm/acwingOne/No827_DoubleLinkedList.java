package com.algorithm.acwingOne;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/** 数组模拟双链表
 * 实现一个双链表，双链表初始为空，支持 5 种操作：
 *
 * 在最左侧插入一个数；
 * 在最右侧插入一个数；
 * 将第 k 个插入的数删除；
 * 在第 k 个插入的数左侧插入一个数；
 * 在第 k 个插入的数右侧插入一个数
 * 现在要对该链表进行 M 次操作，进行完所有操作后，从左到右输出整个链表。
 *
 * 注意:题目中第 k 个插入的数并不是指当前链表的第 k 个数。例如操作过程中一共插入了 n 个数，则按照插入的时间顺序，
 * 这 n个数依次为：第 1 插入的数，第 2个插入的数，…第 n 个插入的数。
 *
 * 输入格式
 * 第一行包含整数 M，表示操作次数。接下来 M 行，每行包含一个操作命令，操作命令可能为以下几种：
 * L x，表示在链表的最左端插入数 x 。R x，表示在链表的最右端插入数 x 。 D k，表示将第 k个插入的数删除。
 * IL k x，表示在第 k 个插入的数左侧插入一个数。IR k x，表示在第 k 个插入的数右侧插入一个数。
 * 输出格式 共一行，将整个链表从左到右输出。
 *
 * 数据范围
 * 1≤M≤100000
 * 所有操作保证合法。
 *
 * 输入样例：
 * 10
 * R 7
 * D 1
 * L 3
 * IL 2 10
 * D 3
 * IL 2 7
 * L 8
 * R 9
 * IL 4 7
 * IR 2 2
 * 输出样例：
 * 8 7 7 3 2 9
 *
 * @author hugaojun Email:nat17185546@163.com
 * @create 2024-04-01-[下午 3:39]-周一
 */
public class No827_DoubleLinkedList {

    private static final int N = 100010;
//    private static int head = 0;
//    private static int tail = 1;
    private static int[] e = new int[N];
    private static int[] l = new int[N];
    private static int[] r = new int[N];
    private static int idx = 0;

    private static void init() {
        // 0表示左端点，1表示右端点
        l[1] = 0; //头节点指针
        r[0] = 1; //尾节点指针
        idx = 2;
    }

    //在第k个点的右边插入一个数
    private static void add(int k, int x) {
        e[idx] = x;
        l[idx] = k;
        r[idx] = r[k];
        l[r[k]] = idx; //先把rk的左指针改了
        r[k] = idx;
        idx ++;
    }
    // 当然在 K 的左边插入一个数可以再写一个，也可以直接调用我们这个函数，
    // 在 k 的左边插入一个数等价于在 l[k] 的右边插入一个数 add(l[k],x)

    //删除第k个点
    private static void delete(int k) {
        l[r[k]] = l[k];
        r[l[k]] = r[k];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader rr = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(rr.readLine());
        init(); //初始化

        while (m -- > 0) {
            String[] s = rr.readLine().split(" ");
            if (s[0].equals("L")) { //表示在链表的最左端插入数x
                int x = Integer.parseInt(s[1]);
                add(0, x);
            } else if (s[0].equals("R")) { //表示在链表的最右端插入数x
                int x = Integer.parseInt(s[1]);
                add(l[1], x);
                //add(l[1], x); Wrong!!
            } else if (s[0].equals("D")) {
                int k = Integer.parseInt(s[1]);
                delete(k + 1); // k + 1?
            } else if (s[0].equals("IL")) {
                int k = Integer.parseInt(s[1]);
                int x = Integer.parseInt(s[2]);
                add(l[k + 1], x);
            } else if (s[0].equals("IR")) {
                int k = Integer.parseInt(s[1]);
                int x = Integer.parseInt(s[2]);
                add(k + 1, x);
            }
        }

        for(int i = r[0]; i != 1; i = r[i]) {
            System.out.print(e[i] + " ");
        }
    }
}
