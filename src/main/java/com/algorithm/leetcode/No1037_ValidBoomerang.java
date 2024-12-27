package com.algorithm.leetcode;

import org.junit.Test;

/**
 *
 * 给定一个数组points，其中points[i] = [xi, yi]表示 X-Y 平面上的一个点，如果这些点构成一个回旋镖则返回true。
 *
 * 回旋镖定义为一组三个点，这些点各不相同且不在一条直线上。
 *
 *
 * 示例 1：
 *
 * 输入：points = [[1,1],[2,3],[3,2]]
 * 输出：true
 * 示例 2：
 *
 * 输入：points = [[1,1],[2,2],[3,3]]
 * 输出：false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/valid-boomerang
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author hugaojun Email:nat17185546@163.com
 * @create 2022-06-08-[20:31]-周三
 */
public class No1037_ValidBoomerang {
    public boolean isBoomerang(int[][] points) {

        int[] v1 = {points[1][0] - points[0][0], points[1][1] - points[0][1]};
        int[] v2 = {points[2][0] - points[0][0], points[2][1] - points[0][1]};
        return v1[0] * v2[1] - v1[1] * v2[0] != 0;

    }

    @Test
    public void test(){

        System.out.println(isBoomerang(new int[][]{{1, 1}, {2, 3}, {3, 2}}));
        System.out.println(isBoomerang(new int[][]{{1, 1}, {2, 2}, {3, 3}}));
    }
}
