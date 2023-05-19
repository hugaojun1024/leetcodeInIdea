package com.algorithm.leetcodeOne;

import org.junit.Test;

import java.util.Random;

/**
 * @author hugaojun Email:nat17185546@163.com
 * @create 2022-06-05-[11:02]-周日
 */
public class No478_GenerateRandomPointInaCircle {

    Random random;
    double xc, yc, r;

    //构造器
    public No478_GenerateRandomPointInaCircle(double radius, double x_center, double y_center) {
        random = new Random();
        xc = x_center;
        yc = y_center;
        r = radius;
    }

    public double[] randPoint() {

        while (true) {

            double x = random.nextDouble() * (2 * r) - r;
            double y = random.nextDouble() * (2 * r) - r;

            if (x * x + y * y <= r * r){
                return new double[]{xc + x, yc + y};
            }

        }
    }

    @Test
    public void test(){

        No478_GenerateRandomPointInaCircle test = new No478_GenerateRandomPointInaCircle(1.0, 0.0, 0.0);

        double[] doubles = test.randPoint();

        for (double aDouble : doubles) {
            System.out.println(aDouble);
        }
    }

    public static void main(String[] args) {

        No478_GenerateRandomPointInaCircle test = new No478_GenerateRandomPointInaCircle(1.0, 0.0, 0.0);

        double[] doubles = test.randPoint();
//        System.out.println(doubles.toString());
        for (double aDouble : doubles) {
            System.out.println(aDouble);
        }
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(radius, x_center, y_center);
 * double[] param_1 = obj.randPoint();
 */