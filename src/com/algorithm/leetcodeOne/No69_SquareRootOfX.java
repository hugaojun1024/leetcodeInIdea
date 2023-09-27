package com.algorithm.leetcodeOne;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 给你一个非负整数 x ，计算并返回 x 的 算术平方根 。
 * 由于返回类型是整数，结果只保留 整数部分 ，小数部分将被 舍去 。
 * 注意：不允许使用任何内置指数函数和算符，例如 pow(x, 0.5) 或者 x ** 0.5 。
 *
 * 示例 1：
 *
 * 输入：x = 4
 * 输出：2
 * 示例 2：
 *
 * 输入：x = 8
 * 输出：2
 * 解释：8 的算术平方根是 2.82842..., 由于返回类型是整数，小数部分将被舍去。
 *
 * 提示：
 *
 * 0 <= x <= 231 - 1
 *
 * @author hugaojun Email:nat17185546@163.com
 * @create 2023-09-23-[下午 7:51]-周六
 */
public class No69_SquareRootOfX {

    /**
     * 方法二：二分查找
     * @param x
     * @return
     */
    public int mySqrtWithDichotomy(int x) {

        int l = 0;  // 左指针
        int r = x;  // 右指针即上界
        int ans = -1; // 结果
        while(l <= r) {
            int mid = l + (r - l) /2; // 计算中间索引位置
            if ((long) mid * mid <= x) {
                ans = mid;
                l = mid + 1; // 更新l
            } else {
                r = mid - 1; // 更新r
            }
        }
        return ans;
    }

    /**
     * 方法三：牛顿迭代
     * @param x
     * @return
     */
    public int mySqrtWithNewtonM(int x) {

        if (x == 0) {
            return 0;
        }
        double C = x, x0 = x;
        while (true) {
            double xi = 0.5 * (x0 + C / x0);
            // 终止条件
            if (Math.abs(x0 - xi) < 1e-7) {
                break;
            }
            x0 = xi;
        }
        return (int)x0; //强转
    }

    public int mySqrtWithTestError(int x) {
        int left = 0;
        int right = x;
        int ans = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if ((long) mid * mid > x) {
                right = mid - 1;
            } else {
                ans = mid;
                left = mid + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        No69_SquareRootOfX squareRootOfX = new No69_SquareRootOfX();
//        int result = squareRootOfX.mySqrtWithDichotomy(8);
//        int result2 = squareRootOfX.mySqrtWithNewtonM(8);
        int ans1 = squareRootOfX.mySqrtWithTestError(4);
        System.out.println(ans1);
    }
}
