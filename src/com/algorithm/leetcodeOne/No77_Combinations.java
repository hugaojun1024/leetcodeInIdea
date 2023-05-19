package com.algorithm.leetcodeOne;

import java.util.*;

/**
 * @author hugaojun Email:nat17185546@163.com
 * @create 2022-10-26-[下午 8:13]-周三
 *
 * 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
 *
 * 你可以按 任何顺序 返回答案。
 *
 * 示例 1：
 *
 * 输入：n = 4, k = 2
 * 输出：
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 * 示例 2：
 *
 * 输入：n = 1, k = 1
 * 输出：[[1]]
 *
 * 提示：
 *
 * 1 <= n <= 20
 * 1 <= k <= n
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/combinations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class No77_Combinations {
    public List<List<Integer>> combine(int n, int k) {

        List<List<Integer>> res = new ArrayList<>();
        if (k <= 0 || n < k ) {
            return res;
        }
        //从1开始是题目的设定
        Deque<Integer> path = new ArrayDeque<>();
        backtracking(n, k, 1, path, res);
        return res;
    }

    private void backtracking(int n, int k, int begin, Deque<Integer> path, List<List<Integer>> res) {
        if (path.size() == k ) {
            res.add(new ArrayList<>(path)); //ArrayList就是动态数组
            return;
        }
        for (int i = begin; i <= n; i++) {
            // 向路径变量里添加一个数
            path.addLast(i);
            // 下一轮搜索，设置的搜索起点要加 1，因为组合数理不允许出现重复的元素
            backtracking(n, k, i + 1, path, res);
            // 重点理解这里：深度优先遍历有回头的过程，因此递归之前做了什么，递归之后需要做相同操作的逆向操作
            path.removeLast();
        }
    }


    public static void main(String[] args) {
        No77_Combinations Test = new No77_Combinations();
        List<List<Integer>> combine = Test.combine(4, 2);
        System.out.println(combine.toString());
        //[[1, 2], [1, 3], [1, 4], [2, 3], [2, 4], [3, 4]]
    }
}
