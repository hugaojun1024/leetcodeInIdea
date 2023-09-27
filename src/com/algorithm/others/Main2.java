package com.algorithm.others;

import java.util.Scanner;

/**
 * @author hugaojun Email:nat17185546@163.com
 * @create 2023-09-25-[下午 3:53]-周一
 */
public class Main2 {
    public static void main(String[] args) {
        // 计算圆的周长和面积
        double radii;
        double length;
        double area;
        final double PI = 3.14;
        System.out.println("请输入圆的半径");
        Scanner in = new Scanner(System.in);
        radii = in.nextDouble();
        length = 2 * PI * radii;
        area = PI * radii * radii;

        System.out.println("圆的周长为：" + length);
        System.out.println("圆的面积为：" + area);
    }
}
