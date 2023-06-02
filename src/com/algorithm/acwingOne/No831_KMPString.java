package com.algorithm.acwingOne;

import java.io.*;

/**
 * @author hugaojun Email:nat17185546@163.com
 * @create 2023-03-21-[下午 3:01]-周二
 */
public class No831_KMPString {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(reader.readLine());

        //模式串P
        String P = reader.readLine();
        char[] p = new char[n + 1];
        for (int i = 1; i <= n; i++) {
            p[i] = P.charAt(i - 1);
        }

        int m = Integer.parseInt(reader.readLine());
        String S = reader.readLine();
        //总串
        char[] s = new char[m + 1];
        for (int i = 1; i <= m ; i++) {
            s[i] = S.charAt(i - 1);
        }

        //

    }
}
