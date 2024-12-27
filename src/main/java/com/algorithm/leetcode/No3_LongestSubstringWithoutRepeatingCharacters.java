package com.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个字符串 s ，请你找出其中不含有重复字符的最长子串的长度。
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
 * @update 2024-04-03-[09:23]-周三
 */
public class No3_LongestSubstringWithoutRepeatingCharacters {

    public static int lengthOfLongestSubstring(String s) {
        int n = s.length(), r = 0;
        Map<Character, Integer> map = new HashMap<>();

        for(int i = 0, j = 0; i < n; i ++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) j = Math.max(map.get(c), j);
            map.put(s.charAt(i), i + 1); // i ++ && i + 1
            r = Math.max(r, i - j + 1);
        }

        return r;
    }

    public static void main(String[] args) {
        int x = lengthOfLongestSubstring("abcabcbb");
        System.out.println(x);
    }
}
