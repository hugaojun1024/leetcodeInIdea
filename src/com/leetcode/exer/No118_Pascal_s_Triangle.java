package com.leetcode.exer;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 *Given an integer numRows, return the first numRows of Pascal's triangle.
 *
 * In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:
 *
 * Example 1:
 *
 * Input: numRows = 5
 * Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
 * Example 2:
 *
 * Input: numRows = 1
 * Output: [[1]]
 *
 * Constraints:
 *
 * 1 <= numRows <= 30
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/pascals-triangle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author hugaojun Email:nat17185546@163.com
 * @create 2022-07-20-[下午 12:17]-周三
 */
public class No118_Pascal_s_Triangle {
    /**
     * @Description: 用ArrayList集合存储
     * @version v1.0
     * @author hugaojun
     * @date 2022/7/21 下午 11:50
     */
    public List<List<Integer>> generateForList(int numRows) {
        ArrayList<List<Integer>> ret = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            ArrayList<Integer> row = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    row.add(ret.get(i - 1).get(j - 1) + ret.get(i - 1).get(j));
                }
            }
            ret.add(row);
        }
        return ret;
    }
    /**
     * @Description: 用数组存储
     * @version v1.0
     * @author hugaojun
     * @date 2022/7/22 上午 10:39
     */
    public int[][] generateForArray(int numRows) {
        final int NMAX = numRows - 1;
        int[][] odds = new int[NMAX + 1][];
        for (int n = 0; n <= NMAX; n++) {
            odds[n] = new int[n + 1];
        }
        for (int n = 0; n < odds.length; n++) {
            for (int k = 0; k < odds[n].length; k++) {
                int lotteryOdds = 1;
                for(int i = 1; i <= k; i++) {
                    //compute binomial coefficient n*(n-1)*(n-2)*...*(n-k+1)/(1*2*3*...*k)
                    lotteryOdds = lotteryOdds * (n - i + 1) / i;
                }
                odds[n][k] = lotteryOdds;
            }
        }
        for (int[] row : odds) {
            for (int odd : row) {
                System.out.printf("%4d", odd);
            }
            System.out.println();
        }
        return odds;
    }

    @Test
    public void test1(){
        List<List<Integer>> generate = generateForList(5);
        System.out.println(generate.toString());
    }

    @Test
    public void test2(){
        int[][] ints = generateForArray(5);
    }

}
