package com.leetcode.exer;

/**
 * 
 * @Description	
 * 
 * 给你一个 升序排列 的数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。元素的 相对顺序 应该保持 一致 。
 * 由于在某些语言中不能改变数组的长度，所以必须将结果放在数组nums的第一部分。更规范地说，如果在删除重复项之后有 k 个元素，那么 nums 的前 k 个元素应该保存最终结果。
 * 将最终结果插入 nums 的前 k 个位置后返回 k 。
 * 不要使用额外的空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 * 判题标准:
 * 系统会用下面的代码来测试你的题解:
 * 
 * int[] nums = [...]; // 输入数
 * int[] expectedNums = [...]; // 长度正确的期望答案
 * 
 * int k = removeDuplicates(nums); // 调用
 * 
 * assert k == expectedNums.length
 * for (int i = 0; i < k; i++) {
 * 	   assert nums[i] == expectedNums[i];
 * }
 * 
 * 如果所有断言都通过，那么您的题解将被通过。
 * 
 * 示例 1：
 * 输入：nums = [1,1,2]
 * 输出：2, nums = [1,2,_]
 * 解释：函数应该返回新的长度 2 ，并且原数组 nums 的前两个元素被修改为 1, 2 。不需要考虑数组中超出新长度后面的元素。
 * 
 * 
 * 示例 2：
 * 输入：nums = [0,0,1,1,1,2,2,3,3,4
 * 输出：5, nums = [0,1,2,3,4]
 * 解释：函数应该返回新的长度 5 ， 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4 。不需要考虑数组中超出新长度后面的元素。

 * @author hugaojun Email:nat17185546@163.com
 * 
 * @version
 * 
 * @date 2022年3月7日下午1:45:50
 *
 */
public class No26_RemoveDuplicates {
	
	public int removeDuplicates(int[] nums) {
		
		if(nums == null || nums.length == 0) return 0;
		int p = 0;
		int q = 1;
		
		while(q < nums.length) {
			if(nums[p] != nums[q]) {
				nums[p + 1] = nums[q];
				p++;
			}
			q++;
		}
		return p + 1;
    }
	
	
	//测试类
	public static void main(String[] args) {
		
		No26_RemoveDuplicates rd = new No26_RemoveDuplicates();
		int[] a = new int[] {1,2,2,3,3,4,5,6,6};
		int k = rd.removeDuplicates(a);
		//System.out.println(Arrays.toString(a));
		System.out.println(k);
	}
}

















