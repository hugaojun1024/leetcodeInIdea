package com.algorithm.leetcode;

/**
 * @author hugaojun Email:nat17185546@163.com
 * @create 2024-10-08-[上午 11:08]-周二
 */
public class No32_LongestValidParentheses {
    public int longestValidParentheses(String s) {
        int maxLen = 0;

        // 遍历所有可能的子串
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 2; j <= s.length(); j += 2) {
                if (isValid(s.substring(i, j))) {
                    maxLen = Math.max(maxLen, j - i);
                }
            }
        }
        return maxLen;
    }

    // 检查子串是否为有效括号序列
    private boolean isValid(String s) {
        int balance = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                balance ++;
            } else {
                balance --;
            }
            if (balance < 0) return false;
        }
        return balance == 0;
    }
}
