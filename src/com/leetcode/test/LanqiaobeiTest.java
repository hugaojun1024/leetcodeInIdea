package com.leetcode.test;

import java.util.Scanner;

/**
 * @author hugaojun Email:nat17185546@163.com
 * @create 2023-04-06-[下午 3:20]-周四
 */
public class LanqiaobeiTest {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        //在此输入您的代码...
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();

        int[] a = new int[26];
        for(int i = 0; i < str.length(); i++ ) {
            a[str.charAt(i) - 'a']++;
        }

        char ch = 'a';int max = 0;
        for(int i = 0; i < 26; i++ ) {
            if (a[i] > max) {
                max = a[i];
                ch = (char)('a' + i);
            }
        }
        System.out.println(ch);
        System.out.println(max);
        scan.close();
    }
}
