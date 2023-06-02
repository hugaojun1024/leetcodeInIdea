package com.algorithm.acwingOne;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;

/**
 * @author hugaojun Email:nat17185546@163.com
 * @create 2023-03-16-[下午 4:16]-周四
 */
public class No830_MonotoneStack {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        StringBuffer sb = new StringBuffer();
        Stack<Integer> stack = new Stack<>();

        for (int val : arr) {
            while (!stack.isEmpty() && val <= stack.peek()) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                sb.append(-1).append(" ");
            } else {
                sb.append(stack.peek()).append(" ");
            }
            stack.push(val);
        }

        System.out.println(sb.toString().trim());
    }

    @Test
    public static void test() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[n];
        int j = 0;

        for (String s : br.readLine().split(" ")) {
            nums[j++] = Integer.parseInt(s);
        }
        init();

        //用StringBuffer容器装
        StringBuffer res = new StringBuffer();
        for (int i = 0; i < n; i++) {
            while (tt != -1 && stk[tt] >= nums[i]) {
                pop();
            }
            res.append(tt == -1 ? -1 : stk[tt]).append(" ");
            push(nums[i]);
        }
        System.out.println(res.toString());
    }

    static final int len = 100010;
    static int stk[], tt;   //tt为栈顶

    static void init() {
        stk =  new int[len];
        tt = -1;
    }

    static void push(int x) {
        stk[++ tt] = x;
    }

    static void pop() {
        tt--;
    }

}
