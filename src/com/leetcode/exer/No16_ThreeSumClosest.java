package com.leetcode.exer;

import java.util.Arrays;

/**
 *给你一个长度为 n 的整数数组 nums 和 一个目标值 target。请你从 nums 中选出三个整数，使它们的和与 target 最接近。
 *
 * 返回这三个数的和。
 *
 * 假定每组输入只存在恰好一个解。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [-1,2,1,-4], target = 1
 * 输出：2
 * 解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
 * 示例 2：
 *
 * 输入：nums = [0,0,0], target = 1
 * 输出：0
 *  
 *
 * 提示：
 *
 * 3 <= nums.length <= 1000
 * -1000 <= nums[i] <= 1000
 * -104 <= target <= 104
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum-closest
 */

public class No16_ThreeSumClosest {

    /*
    暴力解法
     */
    public int threeSumClosest(int[] nums, int target) {

        int n = nums.length;
//        System.out.println(n);//
        int closet = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {

                    int sum = nums[i] + nums[j] + nums[k];
                    if (sum == target) return target;
                    if (Math.abs(target - closet) > Math.abs(target - sum)) {
                        closet = sum;
                        System.out.println(closet);
                    }

                }
            }
        }
        return closet;
    }

    public int threeSumClosest2(int[] nums, int target) {
        if (nums == null || nums.length < 3) throw new IllegalArgumentException("No Three sum solution");
        Arrays.sort(nums);
        int closest = nums[0] + nums[1] + nums[2];
        for (int i = 0;i < nums.length;i++){
            int j = i + 1;
            int l = nums.length -1;
            while (j < l){
                int sum = nums[i] + nums[j] + nums[l];
                if (Math.abs(target - closest) > Math.abs(target - sum))
                    closest = sum;
                if (sum == target) return target;
                else if(sum > target)   l--;
                else j++;
                }
            }
        return closest;
        }

    public static void main(String[] args) {
        No16_ThreeSumClosest tsc = new No16_ThreeSumClosest();
         System.out.println(tsc.threeSumClosest(new int[]{-1, 2, 1, -4}, 1));
    }
}
