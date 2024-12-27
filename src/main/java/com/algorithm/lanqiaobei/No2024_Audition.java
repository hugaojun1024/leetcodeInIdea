package com.algorithm.lanqiaobei;

import java.io.*;

/**
 * 小蓝最近迷上了一款名为“劲舞团”的游戏，具体来说，只要按照游戏中给出的键位提示依次按出对应的键位，
 * 游戏人物便可以跟随节奏跳舞。对于连续的K 次正确敲击，如果任意连续的两次敲击间间隔时间都小于等于1s，
 * 那么我们称这是一次K 连击。现在给出一局小蓝的游戏记录文件，log.txt 中记录了N 条记录，每条记录有三个字段，
 * 依次为正确敲击字符、小蓝打出的字符、打出字符的时间对应的毫秒时间戳。现在请你计算下最长的K 连击是多少，
 * 你只需要输出K的值。
 *
 * @author hugaojun Email:nat17185546@163.com
 * @create 2024-04-26-[下午 4:52]-周五
 */
public class No2024_Audition {

    public static void main(String[] args) {

        try {
            String pathname = "D:\\Data\\TestPath\\log.txt";
            File filename = new File(pathname);
            InputStreamReader reader = new InputStreamReader(
                    new FileInputStream(filename)
            );
            BufferedReader br = new BufferedReader(reader);
            String lineString  = "";
            int maxRes = 0, tmpRes = 0;
            long lastTime = 0;
            while ((lineString = br.readLine()) != null) {
                String[] splitStrings = lineString.split(" ");//返回字符串数组
                if (splitStrings[0].equals(splitStrings[1])) {
                    //正确敲击
                    long curTime = Long.parseLong(splitStrings[2]);
                    if (curTime - lastTime <= 1000) {
                        // 正确敲击且在1秒内
                        tmpRes ++;
                        if (tmpRes >= 2) {
                            maxRes = Math.max(maxRes, tmpRes);
                        }
                    } else {
                        tmpRes = 1;
                    }
                    lastTime = curTime;
                } else {
                    // 不正确敲击，就直接归零
                    tmpRes = 0;
                    lastTime = 0;
                }
            }
            br.close();
            System.out.println(maxRes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
