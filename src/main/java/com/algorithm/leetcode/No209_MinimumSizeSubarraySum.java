package com.algorithm.leetcode;

import java.util.Arrays;
import java.util.Scanner;

/** 209. 长度最小的子数组
 *
 *给定一个含有 n 个正整数的数组和一个正整数 target 。找出该数组中满足其总和大于等于 target 的长度最小的 连续子数组
 * [nums l, nums l+1, ..., nums r-1, nums r] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
 *
 * 示例 1：
 *
 * 输入：target = 7, nums = [2,3,1,2,4,3]
 * 输出：2
 * 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
 *
 * 示例 2：
 *
 * 输入：target = 4, nums = [1,4,4]
 * 输出：1
 * 示例 3：
 *
 * 输入：target = 11, nums = [1,1,1,1,1,1,1,1]
 * 输出：0
 *
 * 提示：
 * 1 <= target <= 109
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 105
 *
 * @author hugaojun Email:nat17185546@163.com
 * @create 2024-04-08-[上午 11:15]-周一
 */
public class No209_MinimumSizeSubarraySum {

    private static int N = 11;
    private static int[] arr = new int[N];
    private static int[] sum = new int[N];

    public static int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        int[] sums = new int[n + 1];
        int ans = Integer.MAX_VALUE;

        // 构建前缀和数组
        for (int i = 1; i <= n; i ++) {
            sums[i] = sums[i - 1] + nums[i - 1];
        }

        for (int i = 1; i <= n; i ++) {
            int total = target + sums[i - 1];
            // 二分查找
            int bound = Arrays.binarySearch(sums, total);
            // 如果它包含在数组中，则返回搜索键的索引；否则返回 (-(插入点) - 1)。
            if (bound < 0) bound = -bound - 1;
            if (bound <= n) ans = Math.max(ans, bound - i + 1);
        }
        return ans == Integer.MIN_VALUE ? 0 : ans;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int x = in.nextInt();
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i ++) {
            arr[i] = in.nextInt();
        }

//        // Wrong!!
//        for(int i = 0; i < n; i ++) {
//            sum[i] += arr[i];// sum[i] = sum[i] + arr[i]
//        }

        for (int i = 1; i <= n; i ++) {
            //sum1[i] = sum1[i - 1] + arr[i];
            sum[i] = sum[i - 1] + arr[i];
        }

        for (int i = 0, j = n; i <= n; i ++) {
            while (j > 0 && sum[j] - sum[i] > x) j--;
            if (sum[j] - sum[i] == x) ans = Math.min(ans, j - i);
        }

        if (ans != Integer.MAX_VALUE) System.out.println(ans);// Answer wrong!!
    }
}