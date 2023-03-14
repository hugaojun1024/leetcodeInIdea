package com.leetcode.exer2;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author hugaojun Email:nat17185546@163.com
 * @create 2023-02-13-[上午 11:10]-周一
 */
public class No2022_TheLittlePrinceSingleLinkedList {

    public static class Node {

        int value;// 链表的值
        Node next;// 指向下一个链表节点的地址

        //构造器
        public Node(int data) {
            value = data;
        }

        public Node() {
        }
    }

    public static Node InitLink(Node head) {// 初始化
        head = new Node();
        head.next = null;
        return head;// 返回头结点
    }

    public static Node changeHead(Node head, int temp) {
        Node pre = head;
        Node cur = head;
        Node next = head;

        while (next.value != temp) {
            next = head.next;
            cur = head;
            head = head.next;
        }
        cur.next = next.next;
        next.next = pre.next;
        pre.next = next;
        return pre;
    }

    public static void PrintLink(Node head) {// 打印链表
        if (head == null) {
            System.out.println("error");
        }
        Node next = head.next;
        while (next != null) {
            System.out.print(next.value + " ");
            next = next.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {

        LinkedList<String> list = new LinkedList();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        list.add("6");
        list.add("7");
        list.add("8");
        list.add("9");
        list.add("10");

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        for(int i = 0; i < n; i++) {
            String str = scan.next();
            list.remove(str);
            list.addFirst(str);
            for (String s : list) {
                System.out.print(s + " ");
            }
            System.out.println();
        }

        scan.close();
    }
}
