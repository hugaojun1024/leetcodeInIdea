package com.algorithm.leetcode;

import com.algorithm.acwingOne.No826_SingleLinkedList;
import com.algorithm.publicClass.ListNode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author hugaojun Email:nat17185546@163.com
 * @create 2024-03-21-[上午 10:38]-周四
 */
public class No2_AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        if (l1 == null && l2 == null) return null;
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        int addOne = 0;

        while (l1 != null || l2 != null) {
            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;
            int sum = x + y + addOne;
            addOne = sum / 10;
            sum %= 10;
            current.next = new ListNode(sum);
            current = current.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
            if (addOne == 1) {
                current.next = new ListNode(addOne);
            }
        }
        return dummy.next;
    }

    public static void main(String[] args) throws IOException {
        No826_SingleLinkedList node1 = new No826_SingleLinkedList();
        No826_SingleLinkedList node2 = new No826_SingleLinkedList();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

//        No826_SingleLinkedList.addToHead();

        for(int i = 0; i < 2; i ++) {
            String[] values1 = reader.readLine().split(" ");
            for (String value : values1) {
                int val = Integer.parseInt(value);

            }
        }
    }
}
