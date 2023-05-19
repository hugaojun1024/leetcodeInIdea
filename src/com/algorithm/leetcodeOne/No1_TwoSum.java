package com.algorithm.leetcodeOne;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组 nums和一个整数目标值 target，请你在该数组中找出 和为目标值 target 的那两个整数，并返回它们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 *
 * 你可以按任意顺序返回答案。
 *
 *
 * 示例 1：
 *
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[0,1]
 * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 * 示例 2：
 *
 * 输入：nums = [3,2,4], target = 6
 * 输出：[1,2]
 * 示例 3：
 *
 * 输入：nums = [3,3], target = 6
 * 输出：[0,1]
 *
 * 提示：
 *
 * 2 <= nums.length <= 104
 * -109 <= nums[i] <= 109
 * -109 <= target <= 109
 * 只会存在一个有效答案
 * 进阶：你可以想出一个时间复杂度小于 O(n2) 的算法吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class No1_TwoSum {

	//方法一：暴力枚举 时间复杂度：O(N²)，空间复杂度：O(1)
	public int[] twoSum1(int[] nums, int target){

		for(int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {

				if (nums[i] + nums[j] == target){
					return new int[] {i ,j};
				}
			}
		}
		throw new IllegalArgumentException("No two sum solution");
	}

	//方法二：哈希映射 时间复杂度：O(N)，空间复杂度：O(N)
	public int[] twoSum(int[] nums, int target) {

		Map<Integer, Integer> map = new HashMap<>();
		for(int i = 0;i < nums.length;i++) {
			if(map.containsKey(target - nums[i])) {
				return new int[] {map.get(target - nums[i]), i};
			}
			map.put(nums[i], i);
		}
		throw new IllegalArgumentException("No two sum solution");
	}

	//方法三：哈希映射 时间复杂度：O(N)，空间复杂度：O(N)
	public int[] twoSum3(int[] nums, int target) {

		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {

			int find = target - nums[i];

			if (map.get(find) != null) {

				return new int[] {i , map.get(find)};
			}

			map.put(nums[i], i);
		}

		throw new IllegalArgumentException("No two sum solution");
	}


	//测试类
	public static void main(String[] args) {

		No1_TwoSum twosum = new No1_TwoSum();
		System.out.println(Arrays.toString(twosum.twoSum1(new int[] {2,7,11,15}, 9)));
		System.out.println(Arrays.toString(twosum.twoSum(new int[] {2,7,11,15}, 9)));
	}
}


