package com.algorithm.leetcodeOne;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hugaojun Email:nat17185546@163.com
 * @create 2022-11-02-[下午 10:14]-周三
 */
public class No78_Subsets {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(0, nums, res, new ArrayList<Integer>());
        return res;
    }

    private void backtrack(int i, int[] nums, List<List<Integer>> res, ArrayList<Integer> tmp) {
        res.add(new ArrayList<>(tmp));
        for (int j = i; j < nums.length; j++) {
            tmp.add(nums[j]);
            backtrack(j + 1, nums, res, tmp);
            tmp.remove(tmp.size() -1);
        }
    }

    @Test
    public void test1() {
        List<List<Integer>> res = subsets(new int[]{
                1, 2, 3
        });

        System.out.println(res);

    }
}
