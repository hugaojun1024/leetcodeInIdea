package com.algorithm.acwingOne;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @author hugaojun Email:nat17185546@163.com
 * @create 2023-03-14-[下午 4:11]-周二
 */
public class No803_IntervalMerging {
    private static int N  = 100010;
    private static int[] a;
    private static ArrayList<int[]> list = new ArrayList();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for(int i = 0; i < n; i ++ ) {
            a = new int[2];
            a[0] = in.nextInt();
            a[1] = in.nextInt();
            list.add(a);
        }

        //对列表中每个数组0位置元素升序排序
        list.sort(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        int k = 0;
        int r = Integer.MIN_VALUE;

        for (int a[] : list) {
            //下一个区间左端点大于老区间右端点
            if(a[0] > r){
                k++;
            }
            //更新右端点
            r = Math.max(r,a[1]);
        }

        System.out.println(k);
    }
}
