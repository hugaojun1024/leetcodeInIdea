package com.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/** DFS深度优先搜索 --全排列
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 * 示例 1：
 *
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 *
 * 示例 2：
 *
 * 输入：nums = [0,1]
 * 输出：[[0,1],[1,0]]
 *
 * 示例 3：
 *
 * 输入：nums = [1]
 * 输出：[[1]]
 *
 * 提示：
 *
 * 1 <= nums.length <= 6
 * -10 <= nums[i] <= 10
 * nums 中的所有整数 互不相同
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/permutations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author hugaojun Email:nat17185546@163.com
 * @create 2022-10-26-[下午 9:18]-周三
 * @update 2024-04-10-[上午 9:18]-周三
 */
public class No46_Permutations {

    public List<List<Integer>> permute(int[] nums) {
        int length = nums.length;
        // 使用一个动态数组保存所有可能的全排列
        List<List<Integer>> res = new ArrayList<>();
        if (length == 0) return res;
        boolean[] used = new boolean[length];
        List<Integer> path = new ArrayList<>();
        int depth = 0;
        dfs(nums, length, res, used, path, depth);
        return res;
    }

    private void dfs(int[] nums, int length, List<List<Integer>> res, boolean[] used, List<Integer> path, int depth) {
        if (length == depth) {

            //变量 path 所指向的列表 在深度优先遍历的过程中只有一份 ，深度优先遍历完成以后，回到了根结点，成为空列表。
            //在 Java 中，参数传递是 值传递，对象类型变量在传参的过程中，复制的是变量的地址。这些地址被添加到 res 变量，
            //但实际上指向的是同一块内存地址,因此我们会看到 666 个空的列表对象。解决的方法很简单，在 res.add(path); 这里做一次拷贝即可。
            res.add(new ArrayList(path));
            return;
        }
        // 在非叶子结点处，产生不同的分支，这一操作的语义是：
        // 在还未选择的数中依次选择一个元素作为下一个位置的元素，这显然得通过一个循环实现。
        for (int i = 0; i < length; i ++) {
            if (!used[i]) {
                path.add(nums[i]);
                used[i] = true;
                dfs(nums, length, res, used, path, depth + 1);
                // 注意：下面这两行代码发生 「回溯」，回溯发生在从 深层结点 回到 浅层结点 的过程，代码在形式上和递归之前是对称的
                used[i] = false;
                path.remove(path.size() - 1);// path如果是数组不用remove
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        No46_Permutations solution = new No46_Permutations();
        List<List<Integer>> lists = solution.permute(nums);
        System.out.println(lists);
    }
}


