package com.leetcode.exer;

import org.junit.Test;

import java.util.Arrays;

/**
 * You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n,
 * representing the number of elements in nums1 and nums2 respectively.
 *
 * Merge nums1 and nums2 into a single array sorted in non-decreasing order.
 *
 * The final sorted array should not be returned by the function, but instead be stored inside the array nums1.
 * To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be merged,
 * and the last n elements are set to 0 and should be ignored. nums2 has a length of n.
 *
 * Example 1:
 *
 * Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 * Output: [1,2,2,3,5,6]
 * Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
 * The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.
 * Example 2:
 *
 * Input: nums1 = [1], m = 1, nums2 = [], n = 0
 * Output: [1]
 * Explanation: The arrays we are merging are [1] and [].
 * The result of the merge is [1].
 * Example 3:
 *
 * Input: nums1 = [0], m = 0, nums2 = [1], n = 1
 * Output: [1]
 * Explanation: The arrays we are merging are [] and [1].
 * The result of the merge is [1].
 * Note that because m = 0, there are no elements in nums1. The 0 is only there to ensure the merge result can fit in nums1.
 *
 * Constraints:
 *
 * nums1.length == m + n
 * nums2.length == n
 * 0 <= m, n <= 200
 * 1 <= m + n <= 200
 * -109 <= nums1[i], nums2[j] <= 109
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/merge-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author hugaojun Email:nat17185546@163.com
 * @create 2022-07-22-[上午 11:37]-周五
 */
public class No88_MergeSortedArray {
    /**
     * @Description: 方法一：直接合并后排序
     * @version v1.0
     * @author hugaojun
     * @date 2022/7/22 上午 11:44
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0; i != n; i++) {
            nums1[m + i] = nums2[i];
        }
        Arrays.sort(nums1);
    }
    
    /**
     * @Description: 方法二：双指针
     * @version v1.0
     * @author hugaojun
     * @date 2022/7/22 上午 11:49
     */
    public void mergeForTwoPoint(int[] nums1, int m, int[] nums2, int n) {
        int p1 = 0, p2 = 0;
        int[] sorted = new int[m + n];
        int cur;
        while (p1 < m || p2 < n) {
            if (p1 == m) {
                cur = nums2[p2++];
            } else if (p2 == n) {
                cur = nums1[p1++];
            } else if (nums1[p1] < nums2[p2]) {
                cur = nums1[p1++];
            } else {
                cur = nums2[p2++];
            }
            sorted[p1 + p2 - 1] = cur;
        }
        for (int i = 0; i != m + n; ++i) {
            nums1[i] = sorted[i];
        }
    }

    /**
     * @Description: 方法三：逆向双指针
     * @version v1.0
     * @author hugaojun
     * @date 2022/7/22 上午 11:58
     */
    public void mergeForConverseTP(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1, p2 = n - 1;
        int tail = m + n - 1;
        int cur;
        while (p1 >= 0 || p2 >= 0) {
            if (p1 == -1) {
                cur = nums2[p2--];
            } else if (p2 == -1) {
                cur = nums1[p1--];
            } else if (nums1[p1] > nums2[p2]) {
                cur = nums1[p1--];
            } else {
                cur = nums2[p2--];
            }
            nums1[tail--] = cur;
        }
    }

    @Test
    public void test1() {
        int[] a = new int[] {1,2,3,0,0,0};
        merge(a, 3, new int[] {2,5,6}, 3);
        System.out.println(Arrays.toString(a));
    }
    @Test
    public void test2() {
        int[] a = new int[] {1,2,3,0,0,0};
        mergeForTwoPoint(a, 3, new int[] {2,5,6}, 3);
        System.out.println(Arrays.toString(a));
    }
    @Test
    public void test3() {
        int[] a = new int[] {1,2,3,0,0,0};
        mergeForConverseTP(a, 3, new int[] {2,5,6}, 3);
        System.out.println(Arrays.toString(a));
    }

}
