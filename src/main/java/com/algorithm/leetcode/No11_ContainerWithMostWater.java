package com.algorithm.leetcode;

/**
 * 给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
 *
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * 返回容器可以储存的最大水量。
 *
 * 说明：你不能倾斜容器。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/container-with-most-water
 */
public class No11_ContainerWithMostWater {

    public int maxArea(int[] height) {
        if (height == null || height.length == 0) return 0;
        int area = 0, i = 0, j = height.length - 1;
        int maxArea = 0;
        while (i < j) {

            if (height[i] < height[j]){
                area = height[i] * (j - i);
                i++;
            }else {
                area = height[j] * (j - i);
                j--;
            }
            maxArea = maxArea > area ? maxArea : area;
        }
        return maxArea;
    }

    //测试类
    public static void main(String[] args) {
        No11_ContainerWithMostWater cw = new No11_ContainerWithMostWater();
        int i = cw.maxArea(new int[] {1,3,2});
        System.out.println(i);
    }
}
