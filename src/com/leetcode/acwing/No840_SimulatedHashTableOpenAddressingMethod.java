package com.leetcode.acwing;

import org.junit.Test;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author hugaojun Email:nat17185546@163.com
 * @create 2023-03-30-[下午 3:50]-周四
 */
public class No840_SimulatedHashTableOpenAddressingMethod {

    //大于200000万的第一质数：200003
    @Test
    public void theFirstPrimeNumberGreaterThanX() {
        for (int i = 200000; ; i++) {
            boolean flag = true;
            for (int j = 2; j * j < i; j ++) {
                if (i % j == 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                System.out.println(i);
                break;
            }
        }
    }

    private static int N = 200003;
    private static int h[] = new int[N];
    private static int nul = 0x3f3f3f3f;    //也可以用包装类 Integer -> null

    private static int find(int x ) {
        int k = (x % N + N) % N;
        while(h[k] != nul && h[k] != x){
            k++;
            if(k == N){
                k = 0;
            }
        }
        return k;
    }

    public static void main(String[] args) {
        //先将所有位置设为null，标识为空
        Arrays.fill(h, nul);
        //System.out.println(Arrays.toString(h));
        //System.out.println(nul);

        Scanner in = new Scanner(System.in);
        int m = in.nextInt();

        while (m-- > 0) {
            String opt = in.next();
            int x = in.nextInt();
            if ("I".equals(opt)) {
                h[find(x)] = x;
            } else {
                System.out.println(find(x) == nul ? "No" : "Yes");
            }
        }
    }
}
