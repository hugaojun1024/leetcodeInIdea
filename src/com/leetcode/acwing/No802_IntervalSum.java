package com.leetcode.acwing;

import java.util.*;

/**
 * @author hugaojun Email:nat17185546@163.com
 * @create 2023-03-13-[下午 4:05]-周一
 */
public class No802_IntervalSum {    //区间和

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();//现在，我们首先进行 n 次操作，每次操作将某一位置 x 上的数加 c。
        int m = in.nextInt();//接下来，进行 m 次询问，每个询问包含两个整数 l 和 r，你需要求出在区间 [l,r] 之间的所有数的和。
        int N = 300010;
        int[] a = new int[N];
        int[] s = new int[N];

        List<Integer> alls = new ArrayList<>();
        List<Pairs> add = new ArrayList<>();//用来存n次操作
        List<Pairs> query = new ArrayList<>();//用来存m次询问

        for (int i = 0; i < n; i++) {
            int x = in.nextInt();
            int c = in.nextInt();
            add.add(new Pairs(x, c));
            alls.add(x);
        }

        for (int i = 0; i < m; i++) {
            int l = in.nextInt();
            int r = in.nextInt();
            query.add(new Pairs(l, r));
            alls.add(l);
            alls.add(r);
        }

        //到此为止，alls中存好了所有会被用到的数轴上的点，可以进行离散化操作
        //1.排序 2.去重
        Collections.sort(alls);
        int unique = unique(alls);
        alls = alls.subList(0, unique);//将去重后的List保存下来，或者此处也可以将unique作为最后一个数，用r作为二分

        for (Pairs item : add) {
            int index = find(item.first, alls);
            a[index] += item.second;
        }

        //求前缀和
        for (int i = 1; i <= alls.size(); i ++ ) {
            s[i] = s[i - 1] + a[i];
        }

        for (Pairs item : query) {
            int l = find(item.first, alls);
            int r = find(item.second, alls);

            System.out.println(s[r] - s[l - 1]);
        }
    }

    //去重
    static int unique(List<Integer> list) {
        int j = 0;
        for (int i = 0; i < list.size(); i++) {
            if (i == 0 || list.get(i) != list.get(i - 1)) {
                list.set(j, list.get(i));
                j++;
            }
        }
        return j;
    }

    static int find(int x, List<Integer> list) {
        int l = 0;
        int r = list.size() - 1;
        while (l < r) {
            int mid = l + r >> 1;
            if (list.get(mid) >= x) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l + 1; //因为要考虑到前缀和
    }
}

class Pairs {
    int first;
    int second;
    public Pairs(int first, int second) {
        this.first = first;
        this.second = second;
    }
}
