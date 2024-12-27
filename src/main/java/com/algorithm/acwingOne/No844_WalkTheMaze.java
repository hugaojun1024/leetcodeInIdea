package com.algorithm.acwingOne;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/** （BFS）广度优先遍历--走迷宫
 * 给定一个 n×m 的二维整数数组，用来表示一个迷宫，数组中只包含 0 或 1 ，其中 0表示可以走的路，1 表示不可通过的墙壁。
 * 最初，有一个人位于左上角 (1,1) 处，已知该人每次可以向上、下、左、右任意一个方向移动一个位置。
 * 请问，该人从左上角移动至右下角 (n,m) 处，至少需要移动多少次。
 * 数据保证 (1,1) 处和 (n,m) 处的数字为 0 ，且一定至少存在一条通路。
 *
 * 输入格式
 * 第一行包含两个整数 n 和 m 。
 *
 * 接下来 n 行，每行包含 m 个整数（0 或 1），表示完整的二维数组迷宫。
 *
 * 输出格式 输出一个整数，表示从左上角移动至右下角的最少移动次数。
 *
 * 数据范围
 * 1≤n,m≤100
 *
 * 输入样例：
 * 5 5
 * 0 1 0 0 0
 * 0 1 0 1 0
 * 0 0 0 0 0
 * 0 1 1 1 0
 * 0 0 0 1 0
 *
 * 输出样例：
 * 8
 *
 * @author hugaojun Email:nat17185546@163.com
 * @create 2024-04-12-[上午 10:28]-周五
 */
public class No844_WalkTheMaze {
    static int n, m;
    static int[][] map = null; //存储地图
    static int[][] d = null; //存储起点到其他各个点的距离
    static Pair[][] prev = null;

    public static void main(String[] args) throws IOException {
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(in);
        String[] nums = br.readLine().split(" ");
        n = Integer.parseInt(nums[0]);
        m = Integer.parseInt(nums[1]);
        map = new int[n][m];
        d = new int[n][m];
        prev = new Pair[n][m];

        //迷宫map
        for (int i = 0; i < n; i ++) {
            String[] inputs = br.readLine().split(" ");
            for (int j = 0; j < m; j ++) {
                map[i][j] = Integer.parseInt(inputs[j]);
            }
        }

        System.out.println(bfs());
    }

    private static int bfs() {
        //初始化队列
        Queue<Pair> q = new LinkedList<>();
        int[] dy = {0, 1, 0, -1}, dx = {-1, 0, 1, 0};
        // 从起点开始广度优先遍历地图
        q.offer(new Pair(0,0));//将指定元素添加到此列表的末尾（最后一个元素）。

        while (!q.isEmpty()) {
            Pair pair = q.poll();
            if (pair.x == n - 1 && pair.y == m - 1) break;

            //上下左右 遍历
            for (int i = 0; i < 4; i++) {
                int x = pair.x + dx[i];
                int y = pair.y + dy[i];
                if (x > 0 && x < n && y < m && y >= 0 && d[x][y] == 0 && map[x][y] == 0) {
                    q.offer(new Pair(x, y));
                    d[x][y] = d[pair.x][pair.y] + 1;
                    prev[x][y] = pair;
                }
            }
        }
//        int x = n - 1, y = m - 1;
//        while (x != 0 || y != 0) {
//            System.out.println(x + " " + y);
//            Pair tmp = prev[x][y];
//            x = tmp.x;
//            y = tmp.y;
//        }
        return d[n - 1][m - 1];
    }
}

class Pair {
    int x, y;
    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
