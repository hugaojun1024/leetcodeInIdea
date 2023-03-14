package com.leetcode.exer2;

import java.util.Scanner;

/**
 * 小蓝正在学习一门神奇的语言，这门语言中的单词都是由小写英文字母组 成，有些单词很长，远远超过正常英文单词的长度。
 * 小蓝学了很长时间也记不住一些单词，他准备不再完全记忆这些单词，而是根据单词中哪个字母出现得最多来分辨单词。
 *
 * 现在，请你帮助小蓝，给了一个单词后，帮助他找到出现最多的字母和这 个字母出现的次数。
 *
 * 输入描述
 * 输入一行包含一个单词，单词只由小写英文字母组成。
 *
 * 对于所有的评测用例，输入的单词长度不超过 1000。
 *
 * 输出描述
 * 输出两行，第一行包含一个英文字母，表示单词中出现得最多的字母是哪 个。如果有多个字母出现的次数相等，输出字典序最小的那个。
 *
 * 第二行包含一个整数，表示出现得最多的那个字母在单词中出现的次数。
 *
 * 输入输出样例
 * 示例 1
 * 输入
 *
 * lanqiao
 * copy
 * 输出
 *
 * a
 * 2
 * copy
 * 示例 2
 * 输入
 *
 * longlonglongistoolong
 * copy
 * 输出
 *
 * o
 * 6
 *
 * @author hugaojun Email:nat17185546@163.com
 * @create 2023-02-03-[下午 4:20]-周五
 */
public class No2020_WordAnalysis {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();

        int[] a = new int[26];
        for (int i = 0; i < str.length(); i++) {
            a[str.charAt(i) - 'a']++;
        }

        char ch = 'a';
        int max = 0;
        for (int i = 0; i < 26; i++) {
            if (a[i] > max) {
                max = a[i];
                ch = (char)('a' + i);
            }
        }
        System.out.println(ch);
        System.out.println(max);
    }
}
