package com.algorithm.leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 * @author hugaojun Email:nat17185546@163.com
 * @create 2024-03-21-[上午 10:38]-周四
 */
public class No2_AddTwoNumbers2 {

    public static void main(String[] args) {
        ListNodeByArray node1 = new ListNodeByArray();
        ListNodeByArray node2 = new ListNodeByArray();
        Scanner in = new Scanner(System.in);
        System.out.println("输入第一个链表的节点值（以空格分隔）：");
        String[] value1 = in.nextLine().split(" ");
        Collections.reverse(Arrays.asList(value1));
        node1.init();
        for(String value : value1) {
            int val = Integer.parseInt(value);
            node1.addToHead(val);
        }
        System.out.println("输入第二个链表的节点值（以空格分隔）：");
        String[] values2 = in.nextLine().split(" ");
        Collections.reverse(Arrays.asList(values2));
        node2.init();
        for(String value : values2) {
            int val = Integer.parseInt(value);
            node2.addToHead(val);
        }
        // 输出
        for(int i = node1.head; i != -1; i = node1.ne[i]) {
            System.out.print(node1.e[i] + " ");
        }
        for(int i = node2.head; i != -1; i = node2.ne[i]) {
            System.out.print(node2.e[i] + " ");
        }


    }
}

class ListNodeByArray {

    int N = 100010; // 数据规模为 10w
    int head;       // 表示头结点的下标
    int[] e = new int[N];   // 表示结点 i的值
    int[] ne = new int[N];  // 表示结点 i的 next指针是多少
    int idx;        // 表示存储当前结点已经使用结点的下一个结点

    void init() {
        head = -1;
        idx = 0;
    }

    void addToHead(int val) {
        e[idx] = val;
        ne[idx] = head;
        head = idx;
        idx ++;
    }

    void add(int k, int val) {
        e[idx] = val;
        ne[idx] = ne[k];
        ne[k] = idx;
        idx ++;
    }

    void remove(int k) {
        ne[k] = ne[ne[k]];
    }
}
