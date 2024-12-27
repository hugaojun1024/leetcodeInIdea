package com.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个由 n 个整数组成的数组 nums ，和一个目标值 target 。请你找出并返回满足下述全部条件且不重复的四元组 [nums[a], nums[b], nums[c], nums[d]] （若两个四元组元素一一对应，则认为两个四元组重复）：
 *
 * 0 <= a, b, c, d < n
 * a、b、c 和 d 互不相同
 * nums[a] + nums[b] + nums[c] + nums[d] == target
 * 你可以按 任意顺序 返回答案 。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [1,0,-1,0,-2,2], target = 0
 * 输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
 * 示例 2：
 *
 * 输入：nums = [2,2,2,2,2], target = 8
 * 输出：[[2,2,2,2]]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/4sum
 */
public class No18_FourSum {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length < 4) return res;
//        System.out.println(res);    //[] 空
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i - 1] == nums[i]) continue;   //去重
//            if (i > 0 && nums[i + 1] == nums[i]) continue;    //ArrayIndexOutOfBounds！
            for (int j = i + 1; j < nums.length; j++) {
                if (j > i + 1 && nums[j - 1] == nums[j]) continue;  //去重
                int m = j + 1;
                int n = nums.length - 1;
                while(m < n && m < nums.length -1 && n > 0){
                    if (nums[j] + nums[m] + nums[n] + nums[i] == target){
                        res.add(Arrays.asList(nums[i],nums[j],nums[m],nums[n]));
                        m++;n--;
                        while(m < n && nums[m - 1] == nums[m]) m++; //去重
                        while(m < n && nums[n + 1] == nums[n]) n--;
                    }else if(nums[j] + nums[m] + nums[n] + nums[i] > target){
                        n--;
                    }else{
                        m++;
                    }
                }
            }
        }
        return res;
    }

    public List<List<Integer>> fourSum2(int[] nums, int target) {

        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 4 ) return res;
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {

            if ( i > 0 && nums[i - 1] == nums[i]) continue;

            for (int j = i + 1; j < nums.length; j++) {

                if (j > i + 1 && nums[j] == nums[j - 1]) continue;

                int k = j + 1;
                int l = nums.length - 1;

                while (k < l) {

                    if (nums[i] + nums[j] + nums[k] + nums[l] == target) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        list.add(nums[l]);
                        res.add(list);
                        k++;l--;
                        while (k < l && nums[k] == nums[k - 1]) k++;
                        while (k < l && nums[l] == nums[l + 1]) l--;

                    } else if (nums[i] + nums[j] + nums[k] + nums[l] > target) {
                        l--;
                    } else {
                        k++;
                    }
                }
            }
        }
        return res;

    }

    //测试类：
    public static void main(String[] args) {
        No18_FourSum fs = new No18_FourSum();
//        System.out.println(fs.fourSum2(new int[] {1,0,-1,0,-2,2}, 0));
        System.out.println(fs.fourSum2(new int[] {2,2,2,2,2}, 8));
    }
}