package com.algorithm.acwingOne;

import java.io.*;
import java.util.Scanner;

/**
 * @author hugaojun Email:nat17185546@163.com
 * @create 2023-03-29-[下午 4:24]-周三
 */
public class No839_SimulatedHeap {

    private static int N = 100010;
    private static int n, m;
    private static int[] h = new int[N];
    private static int size = 0;

    static BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter log  = new BufferedWriter(new OutputStreamWriter(System.out));

    //
    private static int[] ph = new int[N];
    private static int[] hp = new int[N];

    //
    private static void heap_swap(int a , int b) {
        int tmp = ph[hp[a]];
        ph[hp[a]] = ph[hp[b]];
        ph[hp[b]] = tmp;

        tmp = hp[a];
        hp[a] = hp[b];
        hp[b] = tmp;

        swap(h, a, b);
    }

    private static void down(int u) {
        int t = u;
        if (u * 2 <= size && h[u * 2] < h[t]) t = u * 2;
        if (u * 2 + 1 <= size && h[u * 2 + 1] < h[t]) t = u * 2 + 1;
        if (u != t) {
            heap_swap(u , t);
            down(t);
        }
    }

    private static void up(int u) {
        while (u / 2 > 0 && h[u / 2] > h[u]) {
            heap_swap(u / 2, u);
            u /= 2;
        }
    }

    private static void swap(int[] a, int i , int j ) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        while(n-- > 0){
            String[] s = read.readLine().split(" ");
            String op = s[0];
            if("I".equals(op)){
                int x = Integer.valueOf(s[1]);
                m++;
                h[++size]=x;
                ph[m]=size;
                hp[size]=m;
                //down(size);
                up(size);
            }else if("PM".equals(op)) System.out.println(h[1] + "\n");
            else if("DM".equals(op)){
                heap_swap(1,size);
                size--;
                down(1);
            }else if("D".equals(op)){
                int k = Integer.valueOf(s[1]);
                int u=ph[k];                //这里一定要用u=ph[k]保存第k个插入点的下标
                heap_swap(u,size);          //因为在此处heapSwap操作后ph[k]的值已经发生
                size--;                    //如果在up,down操作中仍然使用ph[k]作为参数就会发生错误
                up(u);
                down(u);
            }else if("C".equals(op)){
                int k = Integer.valueOf(s[1]);
                int x = Integer.valueOf(s[2]);
                h[ph[k]]=x;                 //此处由于未涉及heapSwap操作且下面的up、down操作只会发生一个所以
                down(ph[k]);                //所以可直接传入ph[k]作为参数
                up(ph[k]);
            }
        }

        log.flush();
    }
}
