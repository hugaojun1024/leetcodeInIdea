package com.algorithm.publicClass;

import org.junit.Test;
import java.util.Scanner;

/**
 * @author hugaojun Email:nat17185546@163.com
 * @create 2023-02-13-[下午 3:21]-周一
 */
public class NameRuleTest {

    public String titleCase(String str) {

        StringBuilder newStr = new StringBuilder();
        String[] arr = str.toLowerCase().split(" ");
        for (int i = 0; i < arr.length; i++) {
            int a = arr[i].charAt(0);
            int b = a - 32;
            char bb = (char) b;
            arr[i] = bb + arr[i].substring(1);
            newStr.append(arr[i]);
        }
//        System.out.println(Arrays.toString(arr));
//        System.out.println(newStr);

        return "No2022_" + newStr.toString();
    }

    @Test
    public void test() {
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        System.out.println(titleCase(str));
    }

    public static void main(String[] args) {
        NameRuleTest nameRuleTest = new NameRuleTest();
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        System.out.println(nameRuleTest.titleCase(str));
    }
}
