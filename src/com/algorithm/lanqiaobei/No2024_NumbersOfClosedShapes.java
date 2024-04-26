package com.algorithm.lanqiaobei;

import java.util.*;

/**
 * @author hugaojun Email:nat17185546@163.com
 * @create 2024-04-17-[上午 9:53]-周三
 */
public class No2024_NumbersOfClosedShapes {

    public static int f(int n, int[] data) {
        int res = 0;
        while (n > 0) {
            res += data[n % 10];
            n /= 10;
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Integer[] arr = new Integer[in.nextInt()];
        for (int i = 0; i < arr.length; i ++) {
            arr[i] = in.nextInt();
        }
        int[] data = new int[] {1,0,0,0,1,0,1,0,2,1};
        Arrays.sort(arr, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                int a = f(o1, data);
                int b = f(o2, data);
                if (a == b) {
                    return Integer.compare(o1, o2);
                }
                return Integer.compare(a, b);
            }
        });

        for (int i = 0; i < arr.length; i ++) {
            if (i == arr.length - 1) {
                System.out.println(arr[i]);
            } else {
                System.out.println(arr[i] + " ");
            }
        }
        in.close();
    }
}
