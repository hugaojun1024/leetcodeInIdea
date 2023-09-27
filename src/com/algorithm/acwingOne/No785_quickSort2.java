package com.algorithm.acwingOne;

import java.util.Scanner;

public class No785_quickSort2 {
    private static final int N = 100010;
    private static int[] arr = new int[N];

    // Swap function
    public static void swap(int x, int y) {

        // Wrong!!
//        int temp = x;
//        x = y;
//        y = temp;

        // Wrong!!
//        int temp = x;
//        arr[x] = arr[y];
//        arr[y] = arr[temp];

        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;

    }

    // quick_sort function
    private static void quick_sort(int l, int r) {
        if (l >= r) return;
        int i = l - 1, j = r + 1, x = arr[l + r >> 1];
        while (i < j) {
            do {i++;} while(arr[i] < x);
            do {j--;} while(arr[j] > x);

            // Through the above while loop
            // We find that x (x <= arr[i] && x >= arr[j])
            // Next we will swap the values of arr[i] & arr[j]

            // Conditions need to be added: if (i < j)
            // swap(i , j);
            if (i < j ) swap(i , j);
        }

        // recursion
        quick_sort(l , j);
        quick_sort(j + 1 , r);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        // Input Element
        for(int i = 0; i < n; i++ ) {
            arr[i] = in.nextInt();
        }

        quick_sort(0, n - 1);
        // Output Element
        for(int i = 0; i < n; i++ ) {
            System.out.print(arr[i] + " ");
        }
    }
}