package com.leetcode.exer;

import java.util.Arrays;

/**
 *
 * 给定一个字符串 s，返回 s中不同的非空「回文子序列」个数 。
 *
 * 通过从 s中删除 0 个或多个字符来获得子序列。
 *
 * 如果一个字符序列与它反转后的字符序列一致，那么它是「回文字符序列」。
 *
 * 如果有某个 i , 满足ai!= bi，则两个序列a1, a2, ...和b1, b2, ...不同。
 *
 * 注意：
 *
 * 结果可能很大，你需要对109+ 7取模 。
 *
 *
 * 示例 1：
 *
 * 输入：s = 'bccb'
 * 输出：6
 * 解释：6 个不同的非空回文子字符序列分别为：'b', 'c', 'bb', 'cc', 'bcb', 'bccb'。
 * 注意：'bcb' 虽然出现两次但仅计数一次。
 * 示例 2：
 *
 * 输入：s = 'abcdabcdabcdabcdabcdabcdabcdabcddcbadcbadcbadcbadcbadcbadcbadcba'
 * 输出：104860361
 * 解释：共有 3104860382 个不同的非空回文子序列，104860361 对 109 + 7 取模后的值。
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/count-different-palindromic-subsequences
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author hugaojun Email:nat17185546@163.com
 * @create 2022-06-10-[21:45]-周五
 */
public class No730_CountDifferentPalindromicSubsequences {

    int MOD = (int)1e9 + 7;

    public int countPalindromicSubsequences(String s) {

        char[] cs = s.toCharArray();
        int n = s.length();
        int[] L = new int[4] , R = new int[4];
        int[][] f = new int[n][n];
        Arrays.fill(L , -1);
        // 通过从大到小的枚举方式枚举出 每个字符最靠左的位置
        for (int i = n -1 ; i >= 0 ; i--){
            L[cs[i] - 'a'] = i ;
            Arrays.fill(R , -1 );
            // 通过从当前字符最靠左的位置向右一直枚举找到当前字符位于最右侧的位置
            // 减少枚举次数
            for (int j = i ; j < n ; j++){
                R[cs[j] - 'a'] = j;

                for (int k = 0 ; k < 4 ;k++){
                    // 如果当前字符没有在字符当前 ij 区间中出现过 直接跳过
                    if (L[k] == -1 || R[k] == -1) continue;
                    int l = L[k] , r = R[k];
                    // 如果此时字符串中 i,j 中 最靠左与最靠右的位置相同 则说明当前字符串当中出现的字符只有一个
                    // 他所能对 当前字符串的贡献只有 其 本身
                    if (l == r) f[i][j] = (f[i][j] + 1) % MOD;
                        // 如果此时当前字符的最左侧位置与最右侧位置只隔 1 说明 是两个紧挨着且相同的字符的同时
                        // 对源贡献为 k 或者 kk 均为回文子字符串
                    else if (l == r - 1) f[i][j] = (f[i][j] + 2) % MOD ;
                    else f[i][j] = (f[i][j] + f[l + 1][ r -1] + 2) % MOD ;
                }
            }
        }
        return f[0][n-1];
    }
}
