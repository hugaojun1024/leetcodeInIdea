package com.leetcode.exer;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an integer rowIndex, return the rowIndexth (0-indexed) row of the Pascal's triangle.
 *
 * In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:
 *
 * Example 1:
 *
 * Input: rowIndex = 3
 * Output: [1,3,3,1]
 *
 * Example 2:
 *
 * Input: rowIndex = 0
 * Output: [1]
 *
 * Example 3:
 *
 * Input: rowIndex = 1
 * Output: [1,1]
 *
 * Constraints:
 *
 * 0 <= rowIndex <= 33
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/pascals-triangle-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author hugaojun Email:nat17185546@163.com
 * @create 2022-07-20-[下午 12:17]-周三
 */
public class No119_Pascal_s_Triangle_Two {
    /**
     * @Description: TODO methods
     * @version v1.0
     * @author hugaojun
     * @date 2022/7/21 下午 12:00
     */
    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> ret = new ArrayList<>();
        for (int i = 0; i <= rowIndex; ++i) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j <= i; ++j) {
                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    row.add(ret.get(i - 1).get(j - 1) + ret.get(i - 1).get(j));
                }
                ret.add(row);
            }
        }
        return ret.get(rowIndex);
    }

    @Test
    public void test1(){
        List<Integer> row = getRow(0);
        System.out.println(row.toString());
    }
}
