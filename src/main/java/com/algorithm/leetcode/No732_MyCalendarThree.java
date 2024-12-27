package com.algorithm.leetcode;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author hugaojun Email:nat17185546@163.com
 * @create 2022-06-06-[21:50]-周一
 */
public class No732_MyCalendarThree {

    private TreeMap<Integer, Integer> cnt;

    public No732_MyCalendarThree(){
        cnt = new TreeMap<Integer, Integer>();
    }

    public int book(int start, int end){

        int ans = 0;
        int maxBook = 0;
        cnt.put(start, cnt.getOrDefault(start, 0) + 1);
        cnt.put(end,  cnt.getOrDefault(end, 0) - 1);

        for (Map.Entry<Integer, Integer> entry : cnt.entrySet()) {

            int freg = entry.getValue();
            maxBook += freg;
            ans = Math.max(maxBook, ans);
            }

        return ans;
    }

    public static void main(String[] args) {

        No732_MyCalendarThree test = new No732_MyCalendarThree();
        System.out.println(test.book(10, 20));
        System.out.println(test.book(50, 60));
        System.out.println(test.book(12, 40));
    }
}

/**
 * Your MyCalendarThree object will be instantiated and called as such:
 * MyCalendarThree obj = new MyCalendarThree();
 * int param_1 = obj.book(start,end);
 */