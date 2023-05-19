package com.algorithm.lanqiaobei;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * 题目描述
 * 小蓝给学生们组织了一场考试，卷面总分为 100 分，每个学生的得分都是一个 0 到 100 的整数。
 *
 * 如果得分至少是 60 分，则称为及格。如果得分至少为 85 分，则称为优秀。
 *
 * 请计算及格率和优秀率，用百分数表示，百分号前的部分四舍五入保留整 数。
 *
 * 输入描述
 * 输入的第一行包含一个整数 n\ (1 \leq n \leq 10^4)n (1≤n≤10
 * 4
 *  )，表示考试人数。
 *
 * 接下来 nn 行，每行包含一个 0 至 100 的整数，表示一个学生的得分。
 *
 * 输出描述
 * 输出两行，每行一个百分数，分别表示及格率和优秀率。百分号前的部分 四舍五入保留整数。
 *
 * 输入输出样例
 * 示例
 * 输入
 *
 * 7
 * 80
 * 92
 * 56
 * 74
 * 88
 * 100
 * 0
 * copy
 * 输出
 *
 * 71%
 * 43%
 * copy
 * 运行限制
 * 最大运行时间：1s
 * 最大运行内存: 256M
 *
 * @author hugaojun Email:nat17185546@163.com
 * @create 2023-02-05-[下午 12:03]-周日
 */
public class No2020_AchievementStatistics {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int numberOfStudents = scan.nextInt();

        int grades[] = new int[numberOfStudents];
        int passNumber = 0;
        int excellentNumber = 0;

        for (int i = 0; i < numberOfStudents; i++) {
            grades[i] = scan.nextInt();
            if (grades[i] >= 60) {
                passNumber++;
            }
            if (grades[i] >= 85) {
                excellentNumber++;
            }
        }

        System.out.println(Math.round((float) passNumber * 100 / numberOfStudents) + "%");
        System.out.println(Math.round((float) excellentNumber * 100 / numberOfStudents) + "%");

        scan.close();
    }
}
