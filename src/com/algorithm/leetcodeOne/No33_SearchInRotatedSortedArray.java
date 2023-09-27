package com.algorithm.leetcodeOne;

import org.junit.Test;

/**There is an integer array nums sorted in ascending order (with distinct values).
 Prior to being passed to your function, nums is possibly rotated at an unknown pivot
 index k (1 <= k < nums.length) such that the resulting array is
 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed).
 For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].
 Given the array nums after the possible rotation and an integer target,
 return the index of target if it is in nums, or -1 if it is not in nums.
 You must write an algorithm with O(log n) runtime complexity.

 Example 1:

 Input: nums = [4,5,6,7,0,1,2], target = 0
 Output: 4
 Example 2:

 Input: nums = [4,5,6,7,0,1,2], target = 3
 Output: -1
 Example 3:

 Input: nums = [1], target = 0
 Output: -1

 Constraints:
 1 <= nums.length <= 5000
 -104 <= nums[i] <= 104
 All values of nums are unique.
 nums is an ascending array that is possibly rotated.
 -104 <= target <= 104

 * @author hugaojun Email:nat17185546@163.com
 * @create 2023-12-14-[上午 11:02]-周四
 */
public class No33_SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        int n = nums.length;
        if (n == 0 ) return -1;
        if (n == 1 ) return target == nums[0] ? 0 : -1;
        int l = 0, r = n - 1;

        while (l <= r) {
            int mid = l + r >> 1;
            if (nums[mid] == target) return mid;
            if (nums[0] <= nums[mid]) { //0~mid有序
                if (nums[0] <= target && target < nums[mid]) {
                    r = mid - 1;
                }else {
                    l = mid + 1;
                }
            } else { //mid ~ n -1有序
                if (nums[mid] < target && target <= nums[n - 1]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        return -1;
    }

    @Test
    public void test() {
        System.out.println(search(new int[]{4, 5, 6, 7, 0, 1, 2}, 6));
    }
}
