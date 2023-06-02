package com.algorithm.acwingTwo;

import java.util.Scanner;

/**
 * 问题描述
 * 爱丽丝要完成一项修剪灌木的工作。
 *
 * 有 NN 棵灌木整齐的从左到右排成一排。爱丽丝在每天傍晩会修剪一棵灌 木, 让灌木的高度变为 0 厘米。爱丽丝修剪灌木的顺序是从最左侧的灌木开始, 每天向右修剪一棵灌木。
 * 当修剪了最右侧的灌木后, 她会调转方向, 下一天开 始向左修剪灌木。直到修剪了最左的灌木后再次调转方向。然后如此循环往复。
 *
 * 灌木每天从早上到傍晩会长高 1 厘米, 而其余时间不会长高。在第一天的 早晨, 所有灌木的高度都是 0 厘米。爱丽丝想知道每棵灌木最高长到多高。
 *
 * 输入格式
 * 一个正整数 NN, 含义如题面所述。
 *
 * 输出格式
 * 输出 NN 行, 每行一个整数, 第 ii 行表示从左到右第 ii 棵树最高能长到多高。
 *
 * 样例输入
 * 3
 *
 * 样例输出
 * 4
 * 2
 * 4
 * 评测用例规模与约定
 * 对于 30 \%30% 的数据, N \leq 10N≤10.
 *
 * 对于 100 \%100% 的数据, 1<N \leq 100001<N≤10000.
 *
 * @author hugaojun Email:nat17185546@163.com
 * @create 2023-02-13-[下午 4:39]-周一
 */
public class No2022_Topiary {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        //遍历每一颗灌木丛
        for (int i = 1; i <= n; i++) {

            //看看灌木从是离最左边的灌木丛近，还是离右边近
            int max = Math.max(n - i, i - 1);
            System.out.println(max * 2);
        }
    }
}
