package com.leetcode.exer;

import org.junit.Test;

import java.util.HashMap;

/**
 *
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 *
 * 注意：若 s 和 t 中每个字符出现的次数都相同，则称 s 和 t 互为字母异位词。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 示例 2:
 *
 * 输入: s = "rat", t = "car"
 * 输出: false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/valid-anagram
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author hugaojun Email:nat17185546@163.com
 * @create 2022-09-07-[下午 8:34]-周三
 */
public class No242_ValidAnagram {
    public boolean isAnagram(String s, String t) {

        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char a = s.charAt(i);
            map.put(a, map.getOrDefault(a, 0) + 1);
        }

        for (int i = 0; i < t.length(); i++) {
            char b = t.charAt(i);
            map.put(b, map.getOrDefault(b, 0) - 1);
            if (map.get(b) < 0) {
                return false;
            }
        }

//        for (int i = 0; i < t.length(); i++) {
//            if (map.get(b) < 0) {
//                return false;
//            }
//        }

        return true;
    }

    @Test
    public void test(){
        boolean anagram = isAnagram("anagram", "nagaram");
        System.out.println(anagram);

        boolean anagram2 = isAnagram("anagram", "aagaram");
        System.out.println(anagram2);
    }
}
