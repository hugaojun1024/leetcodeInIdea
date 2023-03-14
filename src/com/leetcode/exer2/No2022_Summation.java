package com.leetcode.exer2;

import java.util.Scanner;

/**
 * @author hugaojun Email:nat17185546@163.com
 * @create 2023-02-13-[下午 4:23]-周一
 */
public class No2022_Summation {
    public static void main(String[] args) {

/* 暴力求解超时
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scan.nextInt();
        }
        int sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                sum += nums[i] * nums[j];
            }
        }

        System.out.println(sum);
         */

        //前置和
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        //定义一个数组
        Long[] nums = new Long[n];
        Long sum = 0l;

        for (int i = 0; i < n; i++) {
            nums[i] = scan.nextLong();
            sum += nums[i]; //对数组求和
        }

        //结果
        Long res = 0l;
        for (int i = 0; i < n - 1; i++) {
            //依次减去当前索引所指的数
            sum -= nums[i];
            //累加求和
            res += sum * nums[i];
        }

        System.out.println(res);

    }
}
