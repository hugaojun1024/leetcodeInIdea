package com.algorithm.leetcode;

import java.util.*;

/** DFS（深度优先遍历） N皇后问题
 * 按照国际象棋的规则，皇后可以攻击与之处在同一行或同一列或同一斜线上的棋子。
 * n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * 给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。每一种解法包含一个不同的 n 皇后问题
 * 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 *
 * @author hugaojun Email:nat17185546@163.com
 * @create 2024-04-11-[上午 11:17]-周四
 */
public class No51_N_Queens {

    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<List<String>>();
        int[] queens = new int[n];
        Arrays.fill(queens, -1);
        Set<Integer> columns = new HashSet<Integer>(); //列
        Set<Integer> diagonals1 = new HashSet<Integer>(); //正对角线
        Set<Integer> diagonals2 = new HashSet<Integer>(); //反对角线
        backtrack(res, queens, n, 0, columns, diagonals1, diagonals2);
        return res;
    }

    private static void backtrack(List<List<String>> res, int[] queens, int n, int row, Set<Integer> columns, Set<Integer> diagonals1, Set<Integer> diagonals2) {
        if (row == n) {
            List<String> board = generateBoard(queens, n);
            res.add(board);
        }
        for (int i = 0; i < n; i ++) {
           if (columns.contains(i)) continue;
           int diagonal1 = row - i; //计算正对角线
           if (diagonals1.contains(diagonal1)) continue;
           int diagonal2 = row + i; //计算反对角线
           if (diagonals2.contains(diagonal2)) continue;
           queens[row] = i;
           columns.add(i);
           diagonals1.add(diagonal1);
           diagonals2.add(diagonal2);
           backtrack(res, queens, n , row + 1, columns, diagonals1, diagonals2);
           queens[row] = -1;
           columns.remove(i);
           diagonals1.remove(diagonal1);
           diagonals2.remove(diagonal2);
        }
    }

    private static List<String> generateBoard(int[] queens, int n) {
        List<String> board = new ArrayList<String>();
        for (int i = 0; i < n; i ++) {
            char[] row = new char[n];
            Arrays.fill(row, '.');
            row[queens[i]] = 'Q';
            board.add(new String(row));
        }
        return board;
    }

    public static void main(String[] args) {
        List<List<String>> lists = solveNQueens(4);
//        for (List<String> innerList : lists) {
//            for (String str : innerList) {
//                System.out.println(str);
//            }
//            System.out.println();
//        }
        System.out.println(lists);
    }
}
