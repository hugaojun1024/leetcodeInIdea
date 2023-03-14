package com.leetcode.others;

import org.junit.Test;

import java.lang.reflect.Parameter;
import java.util.List;

/**
 * @author hugaojun Email:nat17185546@163.com
 * @create 2023-02-12-[下午 8:42]-周日
 */
public class LongestIncreasingSubsequences {

//    private int[] memo = new int[100];
    private int l(int[] nums, int i) {

        if (i == nums.length - 1) {
            return 1;
        }

        //直接返回备忘录里的值
//        if (memo.get(i) != 0) {
//            return memo.get(i);
//        }

        int max_len = 1;

        for (int j = i + 1; j < nums.length; j++) {
            if (nums[j] > nums[i]) {
                max_len = Math.max(max_len, l( nums, j) + 1);
            }
        }
//        memo[i] = max_len;
        return max_len;
    }

    private int length_of_LIS(int[] nums) {

        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(l(nums, i), max);
        }
        return max;
    }

    @Test
    public void test() {

        int nums[] = new int[] {1, 5, 2, 4, 3, 11, 12, 9, 15, 14};
        System.out.println(length_of_LIS(nums));    //O(n* 2ⁿ) 指数级别的算法
    }
}
