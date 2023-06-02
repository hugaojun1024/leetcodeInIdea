package com.algorithm.acwingOne;

import java.lang.reflect.Parameter;
import java.util.Scanner;

/**
 * @author hugaojun Email:nat17185546@163.com
 * @create 2023-03-28-[下午 3:31]-周二
 */

//如何手写一个堆？完全二叉树 5个操作
//1. 插入一个数        heap[ ++ size] = x; up(size);
//2. 求集合中的最小值   heap[1]
//3. 删除最小值        heap[1] = heap[size]; size -- ;down(1);
//4. 删除任意一个元素   heap[k] = heap[size]; size -- ;up(k); down(k);
//5. 修改任意一个元素   heap[k] = x; up(k); down(k);

public class No838_HeapSort {

    private static int N = 100010;
    private static int n, m;
    private static int[] h = new int[N];
    private static int size = 0;

    private static void down(int u) {
        int t = u;
        if (u * 2 <= size && h[u * 2] < h[t]) t = u * 2;
        if (u * 2 + 1 <= size && h[u * 2 + 1] < h[t]) t = u * 2 + 1;
        if (u != t) {
            swap(h, u , t);
            down(t);
        }
    }

    private static void up(int u) {
        while (u / 2 > 0 && h[u / 2] > h[u]) {
            swap(h, u / 2, u);
            u /= 2;
        }
    }

    private static void swap(int[] a, int i , int j ) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();m = in.nextInt();
        //初始化
        for (int i = 1; i <= n; i++) {
            h[i] = in.nextInt();
        }
        size = n;

        for (int i = n / 2; i != 0; i -- ) down(i);

        while (m-- > 0) {
            System.out.print(h[1] + " ");
            swap(h, 1, size);
            size --;
            down(1);
        }
    }
}
