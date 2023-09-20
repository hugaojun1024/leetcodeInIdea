package com.algorithm.leetcodeTwo;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 18. 4Sum
 * Given an array nums of n integers, return an array of all the unique quadruplets
 * [nums[a], nums[b], nums[c], nums[d]] such that:
 *
 * 0 <= a, b, c, d < n
 * a, b, c, and d are distinct.
 * nums[a] + nums[b] + nums[c] + nums[d] == target
 * You may return the answer in any order.
 *
 * Example 1:
 *
 * Input: nums = [1,0,-1,0,-2,2], target = 0
 * Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
 * Example 2:
 *
 * Input: nums = [2,2,2,2,2], target = 8
 * Output: [[2,2,2,2]]
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 200
 * -109 <= nums[i] <= 109
 * -109 <= target <= 109
 *
 * @author hugaojun Email:nat17185546@163.com
 * @create 2023-06-02-[上午 10:02]-周五
 */
public class No18_FourNum {
    /**
     * 排序 + 双指针
     * @param nums
     * @param target
     * @return
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        int len = nums.length;
        Arrays.sort(nums);
        if (len < 4 || nums[0] >= 0 && nums[0] > target || nums[len - 1] < 0 && nums[len - 1] < target) return list;
        for (int i = 0; i < len -1; i++) {
            if (i > 0 && nums[i + 1] == nums[i]) continue;//去重
            for (int j = i + 1; j < len - 2; j++) {
                if (j > i + 1 && nums[j - 1] == nums[j]) continue;//去重
                int L = j + 1 , R = len - 1;
                while (L < R && L < len - 1 && R > 0) {
                    int sum = nums[i] + nums[j] + nums[L] + nums[R];
                    if (sum == target) {
                        list.add(Arrays.asList(nums[i],nums[j], nums[L], nums[R]));
                        //去重
                        while (R > L && nums[L] == nums[L + 1]) L++;
                        while (R > L && nums[R] == nums[R - 1]) R--;
                        L++;R--;
                    } else if (sum < target) {
                        L++;
                    } else {
                        R--;
                    }
                }
            }
        }
        return list;
    }

    @Test
    public void testNo18_FourNum() {
        int[] nums = new int[] {
                1000000000,1000000000,1000000000,1000000000
        };
        System.out.println(fourSum(nums, -294967296));
    }
}
