package com.algorithm.leetcodeOne;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 *
 * 说明：
 *
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 *
 * 示例 1:
 *
 * 输入: [2,2,1]
 * 输出: 1
 * 示例 2:
 *
 * 输入: [4,1,2,1,2]
 * 输出: 4
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/single-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author hugaojun Email:nat17185546@163.com
 * @create 2022-09-07-[下午 6:37]-周三
 */
public class No136_singleNumber {
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            Integer count = map.get(num);
            count = count == null ? 1 : ++count;
//            System.out.println(count);
            map.put(num , count);
        }
        for (Integer keynum : map.keySet()) {
            Integer count = map.get(keynum);

        }
        return 0;
    }

    @Test
    public void test1(){
        int[] a = new int[] {1,2,3,4};
        int i = singleNumber(a);
        System.out.println(i);
    }
}
