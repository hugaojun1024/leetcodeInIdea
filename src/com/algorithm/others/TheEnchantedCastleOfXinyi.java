package com.algorithm.others;

import java.util.Scanner;

/**
 *
 * 链接：https://ac.nowcoder.com/acm/contest/44482/A
 * 来源：牛客网
 *
 * 题目描述 
 * 在黑暗深处，心怡女巫有一座魔法城堡，传说这个城堡会带来无尽的财富，因此人们成群结队的闯入城堡。但这个城堡有一种魔力，每次只允许进入一个闯入者，并且会将闯入者随机传送到城堡的某一层，城堡一楼和顶楼各有一个出口，假设上一层楼和下一层楼的时间相同。现在闯入者需要用最短的时间达到上出口或下出口，否则将会受到心怡女巫的诅咒。
 *
 * 现在聪明的你请帮忙计算这群闯入者所需要花费的总时间。
 *
 * 输入描述:
 *
 * 第一行有两个整数n, m,tn,m,t(1 \le n,m \le 1000, 1\le t \le 101≤n,m≤1000,1≤t≤10)。
 *
 * nn为闯入者人数，mm为城堡层数,tt为上或下一层楼所需要的时间。
 *
 * 第二行有nn个整数分别表示每个闯入者被传送到的楼层。
 *
 * 输出描述:
 * 输出占一行，表示这群闯入者出去所需要花费的总时间。
 *
 * 示例1
 * 输入
 *  
 * 5  5  2
 * 1  2  3  4  5
 * 输出
 *  
 * 8
 * 示例2
 * 输入
 *  
 * 5 5 10
 * 1 1 1 1 1
 * 输出
 *  
 * 0
 *
 * @author hugaojun Email:nat17185546@163.com
 * @create 2023-02-11-[下午 7:41]-周六
 */
public class TheEnchantedCastleOfXinyi {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int t = scanner.nextInt();
        int a[] = new int[n];

        int result = 0;

        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        for (int i = 0; i < n; i++) {
            if (a[i] <= m / 2) {
                result += (a[i] - 1) * t;
            } else {
                result += (m - a[i]) * t;
            }
        }

        System.out.println(result);
    }
}
