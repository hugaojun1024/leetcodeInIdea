package com.algorithm.leetcode;

import org.junit.Test;

/**
 * Given an integer x, return true if x is palindrome integer.
 *
 * An integer is a palindrome when it reads the same backward as forward.
 *
 * For example, 121 is a palindrome while 123 is not.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/palindrome-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author hugaojun Email:nat17185546@163.com
 * @create 2022-05-29-[17:35]-周日
 */
public class No9_PalindromeNumber {
    public boolean isPalindrome(int x) {

        if (x < 0) return false;

        String str = String.valueOf(x);

        StringBuffer sb = new StringBuffer(str);
        System.out.println(sb);
        sb.reverse();
        System.out.println(sb);

        String str1 = new String(sb);

        if (str.equals(str1))
            return true;
        else
            return false;
    }

    public static void main(String[] args) {
        No9_PalindromeNumber p = new No9_PalindromeNumber();
        boolean palindrome = p.isPalindrome(1237321);
        System.out.println(palindrome);
    }

    @Test
    public void test(){
        String s1 = "1234";
        StringBuffer sb = new StringBuffer(s1);
        StringBuffer reverse = sb.reverse();
        System.out.println(reverse);
    }

    @Test
    public void reverse(){
        String str = new String("1234");
        int count = str.length();
        System.out.println(count);

        int n = count -1;

        char[] chars = str.toCharArray();

        System.out.println(chars.length);//41111

        for (int j = (n - 1) >> 1; j >= 0; --j) {
            char temp = chars[j];
            char temp2 = chars[n -j];
            chars[j] = temp2;
            chars[n -j] = temp;
        }

        String str2 = new String(chars);
        System.out.println(str2);
    }
}
