package com.algorithm.leetcode;

import org.junit.Test;

/**
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组nums1 和nums2。请你找出并返回这两个正序数组的 中位数 。
 *
 * 算法的时间复杂度应该为 O(log (m+n)) 。
 *
 * 示例 1：
 *
 * 输入：nums1 = [1,3], nums2 = [2]
 * 输出：2.00000
 * 解释：合并数组 = [1,2,3] ，中位数 2
 * 示例 2：
 *
 * 输入：nums1 = [1,2], nums2 = [3,4]
 * 输出：2.50000
 * 解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/median-of-two-sorted-arrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author hugaojun Email:nat17185546@163.com
 * @create 2022-06-16-[10:26]-周四
 */
public class No4_MedianOfTwoSortedArrays {

    /**
     * Merge two arrays first, and the merging of two ordered arrays is part of merge sort.
     * And then return the median depending on whether it's odd or even.
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArraysByMerger(int[] nums1, int[] nums2) {
        int m = nums1.length,n = nums2.length;
        int[] nums = new int[m + n];
        // When nums1[].length is Zero
        if (m == 0) {
            if (n % 2 == 0) {
                return (nums2[n / 2 - 1]  + nums2[n / 2]) / 2.0;//[1,2,3,4]
            } else {
                return nums2[n / 2];//[1,2,3]
            }
        }
        // When nums2[].length is Zero
        if (n == 0) {
            if (m % 2 == 0) {
                return (nums1[m / 2 - 1] + nums1[m / 2]) / 2.0;
            } else {
                return nums1[m / 2];
            }
        }

        int count = 0, i = 0, j = 0;
        // Merger nums1,nums2
        while (count != (m + n)) {

            // When nums1[] ends
            if (i == m) {
                while (j != n) nums[count++] = nums2[j++];break;
            }

            // When nums2[] ends
            if (j == n) {
                while (i != m) nums[count++] = nums1[i++];break;
            }

            // Neither is ends
            if (nums1[i] < nums2[j]) {
                nums[count++] = nums1[i++];
            } else {
                nums[count++] = nums2[j++];
            }
        }

        //Even or Odd Solution
        if (count % 2 == 0) {
            return (nums[count / 2 - 1] + nums[count / 2]) / 2.0;
        } else {
            return nums[count / 2];
        }
    }

    /**
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int sum = nums1.length + nums2.length;
        if (sum % 2 == 0) {
            return ((double)findKth(nums1, 0, nums2, 0, sum /2) + (double) findKth(nums1, 0, nums2, 0, sum / 2 + 1) ) /2;
        }
        return findKth(nums1, 0, nums2, 0, (sum + 1) / 2);
    }

    private int findKth(int[] nums1, int left1, int[] nums2, int left2, int k) {
        if (left1 >= nums1.length) return nums2[left2 + k - 1];
        if (left2 >= nums2.length) return nums1[left1 + k - 1];
        if (k == 1) return Math.min(nums1[left1], nums2[left2]);
        int mid1 = left1 + k / 2 - 1 < nums1.length ? nums1[left1 + k / 2 - 1] : Integer.MAX_VALUE;
        int mid2 = left2 + k / 2 - 1 < nums2.length ? nums2[left2 + k / 2 - 1] : Integer.MAX_VALUE;
        if (mid1 <= mid2) {
            return findKth(nums1, left1 + k / 2, nums2, left2, k - k / 2);
        }
        return findKth(nums1, left1, nums2, left2 + k / 2, k - k / 2);
    }

    @Test
    public void test() {
        System.out.println(findMedianSortedArraysByMerger(new int[]{1, 3}, new int[]{1}));
    }
}
