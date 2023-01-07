package com.leetcode.exer;

import com.leetcode.pub.ListNode;
import org.junit.Test;

/**
 * You are given the heads of two sorted linked lists list1 and list2.
 *
 * Merge the two lists in a one sorted list. The list should be made by splicing together the nodes of the first two lists.
 *
 * Return the head of the merged linked list.
 *
 * Example 1:
 *
 * Input: list1 = [1,2,4], list2 = [1,3,4]
 * Output: [1,1,2,3,4,4]
 * Example 2:
 *
 * Input: list1 = [], list2 = []
 * Output: []
 * Example 3:
 *
 * Input: list1 = [], list2 = [0]
 * Output: [0]
 *
 * Constraints:
 *
 * The number of nodes in both lists is in the range [0, 50].
 * -100 <= Node.val <= 100
 * Both list1 and list2 are sorted in non-decreasing order.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/merge-two-sorted-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author hugaojun Email:nat17185546@163.com
 * @create 2022-07-23-[上午 11:27]-周六
 */
public class No21_MergeTwoSortedLists {
    /**
     * @Description: 方法一：递归
     * @version v1.0
     * @author hugaojun
     * @date 2022/7/23 上午 11:33
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        } else if (list1.val < list2.val) {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }
    }

    @Test
    public void test1(){
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(3);
        ListNode list2 = new ListNode(2);
        list2.next = new ListNode(4);
        ListNode listNode = mergeTwoLists(list1, list2);
        listNode.interatedListNode(listNode);
    }
}


