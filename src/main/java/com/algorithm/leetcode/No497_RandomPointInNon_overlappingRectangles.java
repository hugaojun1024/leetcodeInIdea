package com.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * 给定一个由非重叠的轴对齐矩形的数组 rects ，其中 rects[i] = [ai, bi, xi, yi] 表示 (ai, bi) 是第 i 个矩形的左下角点，(xi, yi) 是第 i 个矩形的右上角点。设计一个算法来随机挑选一个被某一矩形覆盖的整数点。矩形周长上的点也算做是被矩形覆盖。所有满足要求的点必须等概率被返回。
 *
 * 在给定的矩形覆盖的空间内的任何整数点都有可能被返回。
 *
 * 请注意，整数点是具有整数坐标的点。
 *
 * 实现Solution类:
 *
 * Solution(int[][] rects)用给定的矩形数组rects 初始化对象。
 * int[] pick()返回一个随机的整数点 [u, v] 在给定的矩形所覆盖的空间内。
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/random-point-in-non-overlapping-rectangles
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 * @author hugaojun Email:nat17185546@163.com
 * @create 2022-06-09-[22:23]-周四
 */
public class No497_RandomPointInNon_overlappingRectangles {

    Random rand;
    List<Integer> arr;
    int[][] rects;

    public No497_RandomPointInNon_overlappingRectangles(int[][] rects) {

        rand = new Random();
        arr = new ArrayList<Integer>();
        arr.add(0);
        this.rects = rects;
        for (int[] rect : rects) {
            int a = rect[0], b = rect[1], x = rect[2], y = rect[3];
            arr.add(arr.get(arr.size() - 1) + (x - a + 1) * (y - b + 1));
        }
    }

    public int[] pick() {

        int k = rand.nextInt(arr.get(arr.size() - 1));
        int rectIndex = binarySearch(arr, k + 1) - 1;
        k -= arr.get(rectIndex);
        int[] rect = rects[rectIndex];
        int a = rect[0], b = rect[1], y = rect[3];
        int col = y - b + 1;
        int da = k / col;
        int db = k - col * da;
        return new int[]{a + da, b + db};

    }

    private int binarySearch(List<Integer> arr, int target) {

        int low = 0, high = arr.size() - 1;
        while (low <= high) {
            int mid = (high - low) / 2 + low;
            int num = arr.get(mid);
            if (num == target) {
                return mid;
            } else if (num > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(rects);
 * int[] param_1 = obj.pick();
 */

