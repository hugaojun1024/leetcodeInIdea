package com.algorithm.leetcodeOne;

/**
 * 给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串的第一个匹配项的下标（下标从 0 开始）。
 * 如果 needle 不是 haystack 的一部分，则返回  -1 。
 *
 * 示例 1：
 *
 * 输入：haystack = "sadbutsad", needle = "sad"
 * 输出：0
 * 解释："sad" 在下标 0 和 6 处匹配。
 * 第一个匹配项的下标是 0 ，所以返回 0 。
 * 示例 2：
 *
 * 输入：haystack = "leetcode", needle = "leeto"
 * 输出：-1
 * 解释："leeto" 没有在 "leetcode" 中出现，所以返回 -1 。
 *
 * 提示：
 *
 * 1 <= haystack.length, needle.length <= 104
 * haystack 和 needle 仅由小写英文字符组成
 *
 * @author hugaojun Email:nat17185546@163.com
 * @create 2023-09-27-[上午 10:04]-周三
 */
public class No28_FindTheSubScriptOfTheFirstMatchInTheString {

    /**
     * 朴素算法
     * @param haystack
     * @param needle
     * @return
     */
    public int strStr(String haystack, String needle) {
        int n = haystack.length();
        int m = needle.length();
//        System.out.println(m);
        char[] ha = haystack.toCharArray();
        char[] ne = needle.toCharArray();

        for (int i = 0; i <= n - m; i++) {

            int leftN = i;
            int leftM = 0;

            while (leftM < m && ha[leftN] == ne[leftM]) {
                leftM++;
                leftN++;
            }
            if (leftM == m) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        No28_FindTheSubScriptOfTheFirstMatchInTheString firstMatchInTheString = new No28_FindTheSubScriptOfTheFirstMatchInTheString();
        int result = firstMatchInTheString.strStr("sadbutsad","sad");
        int result2 = firstMatchInTheString.strStr("leetcode", "leeto");
        System.out.println(result);
        System.out.println(result2);
    }
}
