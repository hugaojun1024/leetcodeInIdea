package com.algorithm.others;

import java.util.Scanner;

/**
 * @author hugaojun Email:nat17185546@163.com
 * @create 2023-09-22-[上午 11:19]-周五
 */
public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("请输入是否高（true或false）：");
        boolean isTall = scanner.nextBoolean();

        System.out.print("请输入是否富（true或false）：");
        boolean isRich = scanner.nextBoolean();

        System.out.print("请输入是否帅（true或false）：");
        boolean isHandsome = scanner.nextBoolean();

        scanner.close();

        if (isTall && isRich && isHandsome) {
            System.out.println("我一定要嫁给他!!!");
        } else if (isTall || isRich || isHandsome) {
            System.out.println("嫁吧，比上不足，比下有余。");
        } else {
            System.out.println("不嫁！");
        }
    }
}
