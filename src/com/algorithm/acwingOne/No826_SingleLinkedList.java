package com.algorithm.acwingOne;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author hugaojun Email:nat17185546@163.com
 * @create 2024-03-22-[上午 11:25]-周五
 */
public class No826_SingleLinkedList {

     private static int N = 100010; // 数据规模为 10w
     private static int head;       // 表示头结点的下标
     private static int[] e = new int[N];   // 表示结点 i的值
     private static int[] ne = new int[N];  // 表示结点 i的 next指针是多少
     private static int idx;        // 表示存储当前结点已经使用结点的下一个结点

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
