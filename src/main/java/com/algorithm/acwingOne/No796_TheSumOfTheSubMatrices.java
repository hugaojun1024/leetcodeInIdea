package com.algorithm.acwingOne;

import java.util.Scanner;

/**
 * 796. 子矩阵的和
 *
 * 输入一个 n 行 m 列的整数矩阵，再输入 q 个询问，每个询问包含四个整数 x1,y1,x2,y2，表示一个子矩阵的左上角坐标和右下角坐标。
 *
 * 对于每个询问输出子矩阵中所有数的和。
 *
 * 输入格式
 * 第一行包含三个整数 n，m，q。
 *
 * 接下来 n 行，每行包含 m 个整数，表示整数矩阵。
 *
 * 接下来 q 行，每行包含四个整数 x1,y1,x2,y2，表示一组询问。
 *
 * 输出格式
 * 共 q 行，每行输出一个询问的结果。
 *
 * 数据范围
 * 1≤n,m≤1000,
 * 1≤q≤200000,
 * 1≤x1≤x2≤n,
 * 1≤y1≤y2≤m,
 * −1000≤矩阵内元素的值≤1000
 * 输入样例：
 * 3 4 3
 * 1 7 2 4
 * 3 6 2 8
 * 2 1 2 3
 * 1 1 2 2
 * 2 1 3 4
 * 1 3 3 4
 * 输出样例：
 * 17
 * 27
 * 21
 *
 * https://www.acwing.com/problem/content/798/
 * @author hugaojun Email:nat17185546@163.com
 * @create 2023-03-06-[下午 4:14]-周一
 * @update 2024-03-31-[下午 8:00]-周日
 */
public class No796_TheSumOfTheSubMatrices {
    private static final int N = 1010;
    private static int[][] arr = new int[N][N];
    private static int[][] srr = new int[N][N];

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int q = in.nextInt();
        for(int i = 1; i <= n; i ++ ) //arr
            for(int j = 1; j <= m; j ++ )
                arr[i][j] = in.nextInt();
        for(int i = 1; i <= n; i ++ ) //srr前缀和
            for(int j = 1; j <= m; j ++ )
                srr[i][j] = srr[i - 1][j] + srr[i][j - 1] - srr[i - 1][j - 1] + arr[i][j];
        while (q -- != 0 ) {
            int x1 = in.nextInt();
            int y1 = in.nextInt();
            int x2 = in.nextInt();
            int y2 = in.nextInt();
            // ？最后一组测试用例没有打印
            System.out.println(srr[x2][y2] - srr[x1 -1][y2] - srr[x2][y1 - 1] + srr[x1 - 1][y1 - 1]);
        }
    }
}
