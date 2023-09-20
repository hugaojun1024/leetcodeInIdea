package com.algorithm.leetcodeTwo;

import org.junit.Test;

/**
 * 5. Longest Palindromic Substring
 * Given a string s, return the longest palindromic substring in s.
 *
 * Example 1:
 *
 * Input: s = "babad"
 * Output: "bab"
 * Explanation: "aba" is also a valid answer.
 * Example 2:
 *
 * Input: s = "cbbd"
 * Output: "bb"
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 1000
 * s consist of only digits and English letters.
 * 通过次数1,429,561提交次数3,804,455
 *
 * @author hugaojun Email:nat17185546@163.com
 * @create 2023-06-05-[下午 8:42]-周一
 */
public class No5_LongestPalindromicSubstring {

    /**
     * 中心扩散法
     * @param s
     * @return
     */
    public String longestPalindromeCenterDiffusionMethod(String s) {

        if (s == null || s.length() == 0) {
            return "";
        }
        int strLen = s.length();
        int left = 0;//记录最长回文子串的起点
        int right = 0;//记录最长回文子串的终点
        int len = 1;
        int maxLen = 0; //记录最长回文子串的长度
        int maxStart = 0;

        for (int i = 0; i < strLen; i++) {
            left = i - 1;
            right = i + 1;
            while (left >= 0 && s.charAt(left) == s.charAt(i)) {
                len++;
                left--;
            }
            while (right < strLen && s.charAt(right) == s.charAt(i)) {
                len++;
                right++;
            }
            while (left >= 0 && right < strLen && s.charAt(right) == s.charAt(left)) {
                len = len + 2;
                left--;right++;
            }
            if (len > maxLen) {
                maxLen = len;
                maxStart = left;
            }
            len = 1;
        }
        return s.substring(maxStart + 1, maxStart + maxLen + 1);
    }

    /**
     * 动态规划法优化
     * @param s
     * @return
     */
    public String longestPalindromeDynamic(String s) {

        return "";
    }

    @Test
    public void testCenterDiffusionMethod() {
        System.out.println(longestPalindromeCenterDiffusionMethod("baaacv"));
    }
}
