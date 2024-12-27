package com.algorithm.acwingTwo;

/**
 * @author hugaojun Email:nat17185546@163.com
 * @create 2023-02-11-[上午 11:18]-周六
 */
public class No2020_DoorPlateMaking {
    public static void main(String[] args) {

        int count = 0;

        for (int i = 1; i <= 2020; i++) {
            String str = "";
            str += i;
//            System.out.println(str);
            for (int j = 0; j < str.length(); j++) {

                if (str.charAt(j) == '2') {
                    count++;
                }
            }
        }

        System.out.println(count);
    }
}
