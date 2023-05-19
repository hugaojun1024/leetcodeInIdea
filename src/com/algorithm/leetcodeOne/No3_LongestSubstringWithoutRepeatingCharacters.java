package com.algorithm.leetcodeOne;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例1:
 *
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 *
 * 示例 2:
 *
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 *
 * 示例 3:
 *
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是"wke"，所以其长度为 3。
 *     请注意，你的答案必须是 子串 的长度，"pwke"是一个子序列，不是子串。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/longest-substring-without-repeating-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 * @author hugaojun Email:nat17185546@163.com
 * @create 2022-05-25-[19:23]-周三
 */
public class No3_LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {

        int n = s.length();
        int ans = 0;
        Map<Character, Integer> map = new HashMap<>();

        for (int start = 0, end = 0; end < n; end++) {
            char alpha = s.charAt(end);
            if (map.containsKey(alpha)){
                start = Math.max(map.get(alpha), start);
            }
            System.out.println("start=" + start);//
            ans = Math.max(ans, end - start + 1);
            System.out.println("ans=" + ans);//
            map.put(s.charAt(end), end + 1);
            System.out.println(map);//

            System.out.println("**********");
            System.out.println();
        }
        return ans;
    }

    @Test
    public void test1(){
        No3_LongestSubstringWithoutRepeatingCharacters test = new No3_LongestSubstringWithoutRepeatingCharacters();
        System.out.println(test.lengthOfLongestSubstring("pwwkew"));
    }
}
