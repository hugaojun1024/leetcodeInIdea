package com.leetcode.exer;

import com.leetcode.pub.ListNode;
import org.junit.Test;

import java.util.PriorityQueue;

/**
 * You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
 *
 * Merge all the linked-lists into one sorted linked-list and return it.
 *
 * Example 1:
 *
 * Input: lists = [[1,4,5],[1,3,4],[2,6]]
 * Output: [1,1,2,3,4,4,5,6]
 * Explanation: The linked-lists are:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * merging them into one sorted list:
 * 1->1->2->3->4->4->5->6
 * Example 2:
 *
 * Input: lists = []
 * Output: []
 * Example 3:
 *
 * Input: lists = [[]]
 * Output: []
 *
 * Constraints:
 *
 * k == lists.length
 * 0 <= k <= 104
 * 0 <= lists[i].length <= 500
 * -104 <= lists[i][j] <= 104
 * lists[i] is sorted in ascending order.
 * The sum of lists[i].length will not exceed 104.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/merge-k-sorted-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author hugaojun Email:nat17185546@163.com
 * @create 2022-07-30-[下午 9:25]-周六
 */
public class No23_MergeKSortedLists {
    /**
     * @Description: TODO methods
     * @version v1.0
     * @author hugaojun
     * @date 2022/7/30 下午 9:28
     */
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        //优先队列解法
        PriorityQueue<ListNode> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.val, o2.val));
        for (ListNode list : lists) {
            if (list != null) pq.add(list);
        }
        while (!pq.isEmpty()) {
            ListNode curr = pq.poll();
            head.next = curr;
            head = head.next;
            if (curr.next != null) pq.add(curr.next);
        }
        return dummy.next;
    }

    @Test
    public void test(){

    }
}
