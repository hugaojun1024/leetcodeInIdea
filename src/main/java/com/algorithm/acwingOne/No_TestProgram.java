package com.algorithm.acwingOne;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Scanner;

/**
 * @author hugaojun Email:nat17185546@163.com
 * @create 2023-03-11-[上午 10:33]-周六
 */
public class No_TestProgram {

     private static final int N = 100010;
     private static int[] a;
     public static void main(String[] args) {
         Scanner in = new Scanner(System.in);
         int n = in.nextInt();
         ArrayList<int[]> list = new ArrayList<>();
         for (int i = 0; i < n; i++) {
            a = new int[2];
            a[0] = in.nextInt();
            a[1] = in.nextInt();
            list.add(a);
         }
         //排序
         list.sort(new Comparator<int[]>() {
             @Override
             public int compare(int[] o1, int[] o2) {
                 return o1[0] - o2[0];
             }
         });
         int k = 0;
         int r = Integer.MIN_VALUE;

         for(int a[] : list ) {
             if (a[0] > r ) {
                 k++;
             }
             r = Math.max(r, a[1]);
         }

         System.out.println(k);
     }
}
