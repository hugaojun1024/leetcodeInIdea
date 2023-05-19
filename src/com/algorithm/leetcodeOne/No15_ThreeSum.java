package com.algorithm.leetcodeOne;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 *
 * 示例 1：
 *
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 * 示例 2：
 *
 * 输入：nums = []
 * 输出：[]
 * 示例 3：
 *
 * 输入：nums = [0]
 * 输出：[]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum
 */
public class No15_ThreeSum {

    //编译错误，测试用例：{-1,0,1,2,-1,-4}， 重复
    public List<List<Integer>> threeSum(int[] nums) {

        if (nums == null || nums.length == 0) return null;
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {

                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        res.add(list);
                    }
                }
            }
        }
        return res;
    }

    //编译错误，测试用例：{-1,0,1,2,-1,-4}， 重复
    public List<List<Integer>> threeSum2(int[] nums) {

        if (nums == null || nums.length == 0) return null;
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                int z = j + 1;
                while(z < nums.length){
                    if (nums[i] + nums[j] == - nums[z]){
                        res.add(Arrays.asList(nums[i],nums[j],nums[z]));
                    }
                    z++;
                }
            }
        }
        return res;
    }

    public List<List<Integer>> threeSum3(int[] nums){

//        if (nums == null || nums.length == 0) return null;
        List<List<Integer>> res = new ArrayList<>();

        Arrays.sort(nums);
//        System.out.println(Arrays.toString(nums));

        for (int i = 0; i < nums.length; i++) {

            int j = i + 1;
            int k = nums.length - 1;

            if (i > 0 && nums[i] == nums[i - 1]) continue;

            while (j < k && j < nums.length - 1) {

                if (nums[i] + nums[j] + nums[k] < 0){

                    j++;
//                    while ( j < k && nums[j] == nums[j + 1]) j++;
                } else if (nums[i] + nums[j] + nums[k] > 0){

                    k--;
//                    while (j < k && nums[k] == nums[k - 1]) k--;
                } else {

                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    res.add(list);
                    while ( j < k && nums[j] == nums[j + 1]) j++;
                    while (j < k && nums[k] == nums[k - 1]) k--;
                    j++;k--;
                }
            }

        }
        return res;
    }

    //测试类
    public static void main(String[] args) {
        No15_ThreeSum ts = new No15_ThreeSum();
        System.out.println(ts.threeSum3(new int[] {-1,0,1,2,-1,-4}));
    }

    @Test
    public void test(){

        List<List<Integer>> list = new ArrayList<>();
        System.out.println(list.size());
        System.out.println(list.toString());
        System.out.println(list.isEmpty());
    }
}
