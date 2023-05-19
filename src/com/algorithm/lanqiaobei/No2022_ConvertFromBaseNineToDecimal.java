package com.algorithm.lanqiaobei;

import java.util.Scanner;
/**
 * @author hugaojun Email:nat17185546@163.com
 * @create 2023-02-13-[下午 4:05]-周一
 */
public class No2022_ConvertFromBaseNineToDecimal {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = "2022";
        System.out.println(Integer.parseInt(str, 9));
        scan.close();
    }
}
