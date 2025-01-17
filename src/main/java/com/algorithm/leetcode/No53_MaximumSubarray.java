package com.algorithm.leetcode;

/**
 * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 子数组 是数组中的一个连续部分。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出：6
 * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
 * 示例 2：
 *
 * 输入：nums = [1]
 * 输出：1
 * 示例 3：
 *
 * 输入：nums = [5,4,-1,7,8]
 * 输出：23
 *  
 *
 * 提示：
 *
 * 1 <= nums.length <= 105
 * -104 <= nums[i] <= 104
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-subarray
 */

public class No53_MaximumSubarray {

    //动态化归法：
    public int maxSubArray(int[] nums) {
        int ans = nums[0];
        int sum = 0;
        for (int num : nums) {
            if(sum > 0){
                sum += num;
            }else {
                sum = num;
            }
            ans = Math.max(ans, sum);
        }
        return ans;
    }

    //测试类：
    public static void main(String[] args) {
        No53_MaximumSubarray ms = new No53_MaximumSubarray();
        System.out.println(ms.maxSubArray(new int[] {-2,1,-3,4,-1,2,1,-5,4}));
    }
}

