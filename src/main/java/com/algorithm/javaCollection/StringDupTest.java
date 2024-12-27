package com.algorithm.javaCollection;

import java.util.HashSet;

/**
 * @author hugaojun Email:nat17185546@163.com
 * @create 2024-08-27-[下午 3:29]-周二
 */
public class StringDupTest {

    public static void main(String[] args) {
        /*String s = new String("aaa");
        String ns = StringDupTest.appendStr(s);
        System.out.println(s);
        StringBuilder sb = new StringBuilder("aaa");
        StringBuilder nsb = StringDupTest.appendSb(sb);
        System.out.println(sb);*/

//        String s1 = new StringBuilder().append("think").append("123").toString();
//        System.out.println(s1.intern() == s1);
//        String s2 = new StringBuilder().append("ja").append("va").toString();
//        System.out.println(s2.intern() == s2);

//        String s1 = "java";
//        System.out.println(s1.intern() == s1);
//        String s2 = s1.intern();
//
//        System.out.println(s1 == s2);

        String a = new String("aaa");
        String b = "aaa";

        System.out.println(a == b);

    }

    public static String appendStr(String s) {
        s += "bbb";
        return s;
    }

    public static StringBuilder appendSb(StringBuilder sb) {
        return sb.append("bbb");
    }
}

