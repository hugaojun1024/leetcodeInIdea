package com.leetcode.exer2;

import java.util.Arrays;

/**
 * 问题描述
 * 本题为填空题，只需要算出结果后，在代码中使用输出语句将所填结果输出即可。
 *
 * 小蓝要把一个字符串中的字母按其在字母表中的顺序排列。
 *
 * 例如，LANQIAO 排列后为 AAILNOQ。
 *
 * 又如，GOODGOODSTUDYDAYDAYUP 排列后为 AADDDDDGGOOOOPSTUUYYY。
 *
 * 请问对于以下字符串，排列之后字符串是什么？
 *
 * WHERETHEREISAWILLTHEREISAWAY
 */
public class No2022_ArrangeLetters {
    public static void main(String[] args) {
        String str = "WHERETHEREISAWILLTHEREISAWAY";
        char[] chars = str.toCharArray();
        //Arrays.sort(chars);

        //冒泡排序
        for (int i = 0; i < chars.length - 1; i++) {
            for (int j = 0; j < chars.length - 1 - i; j++) {
                if (chars[j] > chars[j + 1]) {
                    char temp =  chars[j];
                    chars[j] = chars[j + 1];
                    chars[j + 1] = temp;
                }
            }
        }

        for (int i = 0; i < chars.length; i++) {
            System.out.print(chars[i]);
        }
    }
}
