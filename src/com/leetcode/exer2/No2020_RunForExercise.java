package com.leetcode.exer2;

import java.util.UnknownFormatConversionException;

/**
 * @author hugaojun Email:nat17185546@163.com
 * @create 2023-04-06-[下午 3:47]-周四
 */
public class No2020_RunForExercise {
    public static void main(String[] args) {
        int w = 6;
        int km = 0;
        for (int i = 20000101; i < 20201001; i++) {
            int day = i % 100;//日
            int mouth = (i % 10000) / 100;//月
            int year = i / 10000;//年份
            int week = w % 7;//星期几

            if (mouth > 12 || mouth == 0) continue;
            if (day > 31 || day == 0) continue;

            if ((mouth == 4 || mouth == 6 || mouth == 9 || mouth == 11) && day > 30) continue;
            if ((year % 100 != 0 & year % 4 == 0) || year % 400 == 0) {
                if (mouth == 2 && day > 29) continue;
            } else {
                if (mouth == 2 && day > 28) {
                    //平年2月为28天
                    continue;
                }
            }
            //以上所有不符合结果的条件都去除后判断，几号和星期几的关系
            if (w == 1 && day == 1 ) {
                km += 2; w ++; continue;
            } else if (w == 1 && day != 1 ) {
                km += 2; w ++; continue;
            } else if (day == 1 && week != 1 ) {
                km += 2; w ++; continue;
            }
            km ++; w ++;
        }
    }

    //判断是否为闰年
    private static boolean bissextile(int year) {
        if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
            return true;
        } else {
            return false;
        }
    }
}
