package com.algorithm.leetcode;

import java.util.Arrays;

/**
 * 给你一个数组 nums和一个值 val，你需要 原地 移除所有数值等于val的元素，并返回移除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
 *
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 *
 * 说明:
 *
 * 为什么返回数值是整数，但输出的答案是数组呢?
 *
 * 请注意，输入数组是以「引用」方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。
 *
 * 你可以想象内部操作如下:
 *
 * // nums 是以“引用”方式传递的。也就是说，不对实参作任何拷贝
 * int len = removeElement(nums, val);
 *
 * // 在函数里修改输入数组对于调用者是可见的。
 * // 根据你的函数返回的长度, 它会打印出数组中 该长度范围内 的所有元素。
 * for (int i = 0; i < len; i++) {
 *   print(nums[i]);
 * }
 *
 * 示例 1：
 *
 * 输入：nums = [3,2,2,3], val = 3
 * 输出：2, nums = [2,2]
 * 解释：函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。你不需要考虑数组中超出新长度后面的元素。例如，函数返回的新长度为 2 ，而 nums = [2,2,3,3] 或 nums = [2,2,0,0]，也会被视作正确答案。
 * 示例 2：
 *
 * 输入：nums = [0,1,2,2,3,0,4,2], val = 2
 * 输出：5, nums = [0,1,4,0,3]
 * 解释：函数应该返回新的长度 5, 并且 nums 中的前五个元素为 0, 1, 3, 0, 4。注意这五个元素可为任意顺序。你不需要考虑数组中超出新长度后面的元素。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-element
 */

public class No27_RemoveElement {

    public int removeElement(int[] nums, int val) {
        int ans = 0;
        for (int num : nums) {
            if (num != val){
                nums[ans] = num;
                ans++;
            }
        }
        return ans;
    }

    public int removeElement2(int[] nums, int val){

        int ans = nums.length;
        for (int i = 0; i < ans;) {
            if (nums[i] == val) {
                nums[i] = nums[ans - 1];
                ans--;
            } else {
                i++;
            }
        }
        return ans;
    }

    /**
     * 方法一：双指针 2023/9/20
     * @param nums
     * @param val
     * @return
     */
    public int removeElement3(int[] nums, int val) {
        int n = nums.length;
        int left = 0;

        for (int right = 0; right < n; right++) {
            // 如果right不等于val
            if (nums[right] != val) {
                nums[left] = nums[right];
                left ++;
                // System.out.println(Arrays.toString(nums));
            }
        }
        return left;
    }

    /**
     * 方法二：双指针优化 2023/9/21
     * @param nums
     * @param val
     * @return
     */
    public int removeElement4(int[] nums, int val) {
        int right = nums.length - 1;
        int left = 0;

        // 如果是right = nums.length -1 ，while中条件应该为 right >= left
        while (right > left) {
            if (nums[left] == val) {
                nums[left] = nums[right];
                right --;
            } else {
                left ++;
            }
            System.out.println("错误的：" + Arrays.toString(nums));
        }
        return left;
    }

    //测试类：
    public static void main(String[] args) {

        No27_RemoveElement re = new No27_RemoveElement();
//        int[] nums = new int[] {0,1,2,2,3,0,4,2};
//        System.out.println(re.removeElement(nums, 2));
//        System.out.println(Arrays.toString(nums));
//
//        int[] nums2 = new int[] {0,1,2,2,3,0,4,2};
//        System.out.println(re.removeElement2(nums2, 2));
//        System.out.println(Arrays.toString(nums2));

        int[] nums3 = new int[] {3,2,2,3};
        System.out.println(re.removeElement3(nums3, 2));
        System.out.println(Arrays.toString(nums3));

        System.out.println(re.removeElement4(nums3, 2));
        System.out.println(Arrays.toString(nums3));
    }
}
