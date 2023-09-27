package com.algorithm.others;

import java.util.Scanner;

/**
 * @author hugaojun Email:nat17185546@163.com
 * @create 2023-09-22-[上午 11:19]-周五
 */
public class Main {
    public static void main(String[] args) {

        int n1, n2;
        Scanner in = new Scanner(System.in);
        System.out.println("请输入n1的值");
        n1 = in.nextInt();
        System.out.println("请输入n2的值");
        n2 = in.nextInt();

        System.out.println("n1 + n2 = " + n1 + n2);
        System.out.println("n1 - n2 = " + (n1 - n2));
        System.out.println("n1 * n2 = " + n1 * n2);
        System.out.println("n1 / n2 = " + n1 / n2);
        System.out.println("n1 % n2 = " + n1 % n2);
    }
}
