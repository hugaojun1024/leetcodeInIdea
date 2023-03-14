package com.leetcode.test;

import java.util.Scanner;

/**
 * @author hugaojun Email:nat17185546@163.com
 * @create 2023-02-04-[下午 12:00]-周六
 */
public class ScannerTest {
    public static void main(String[] args) {
        String s1,s2;
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入第一个字符串：");
        s1 = sc.next();
        sc.nextLine();
        System.out.print("请输入第二个字符串：");
        s2 = sc.nextLine();
        System.out.println("输入的字符串是："+s1+" "+s2);
    }
}
