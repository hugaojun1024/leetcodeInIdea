package com.algorithm.acwingOne;

import org.junit.Test;

import java.util.Scanner;

/**
 *
 * 散列表（Hash table，也叫哈希表），是根据键（Key）而直接访问在内存储存位置的数据结构。也就是说，它通过计算出一个键值的函数，
 * 将所需查询的数据映射到表中一个位置来让人访问，这加快了查找速度。这个映射函数称做散列函数，存放记录的数组称做散列表。
 *
 * 一个通俗的例子是，为了查找电话簿中某人的号码，可以创建一个按照人名首字母顺序排列的表（即建立人名x到首字母F(x)的一个函数关系），
 * 在首字母为W的表中查找“王”姓的电话号码，显然比直接查找就要快得多。这里使用人名作为关键字，“取首字母”是这个例子中散列函数的函数法则
 * F()，存放首字母的表对应散列表。关键字和函数法则理论上可以任意确定。
 *
 * @author hugaojun Email:nat17185546@163.com
 * @create 2023-03-30-[上午 9:27]-周四
 */
public class No840_SimulatedHashTableZipperMethod {

    //大于100000万的第一质数：
    @Test
    public void theFirstPrimeNumberGreaterThanX() {
        for (int i = 100000; ; i++) {
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

/*连接表法*/
    private static int N = 100003;
    private static int[] h = new int[N];
    private static int[] e = new int[N];
    private static int[] ne = new int[N];

    //设0为空，地址从1开始
    private static int idx = 1;

    private static void insert(int x) {
        int k = (x % N + N) % N;
        e[idx] = x;
        ne[idx] = h[k];
        h[k] = idx ++;
    }

    private static boolean find(int x) {
        int k = (x % N + N) % N;
        //这里需要指针t来遍历，不能直接移动a[k]
        /*
        int t = h[k];
        while (t != 0) {
            if (x == e[t]) {
                return true;
            }
            t = ne[t];
        }
        */
        for (int i = h[k]; i != 0; i = ne[i]) {
            if (e[i] == x) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        while (m -- > 0) {
            String opt = in.next();
            int x = in.nextInt();
            if ("I".equals(opt)) {
                insert(x);
            } else {
                System.out.println(!find(x) ? "No" : "Yes");
            }
        }
    }
}
