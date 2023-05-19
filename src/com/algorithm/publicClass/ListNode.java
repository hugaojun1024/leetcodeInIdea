package com.algorithm.publicClass;

/**
 * Definition for singly-linked list.
 *
 * @author hugaojun Email:nat17185546@163.com
 * @create 2022-07-23-[上午 11:30]-周六
 */
public class ListNode {

    public int val;
    public ListNode next;

    public ListNode(){};

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public void interatedListNode(ListNode head) {

        for (ListNode p = head; p != null; p = p.next) {
            System.out.print(p.val + " ");
        }
    }
}
