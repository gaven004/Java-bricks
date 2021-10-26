package org.g.taocp.sorting.internal;

import java.util.Arrays;

public class ListInsertion {
    public static void main(String[] args) {
        // 稍做变化，改为与书中的下标 1...N 一致
        int[] R = {0, 503, 87, 512, 61, 908, 170, 897, 275, 653, 426, 154, 509, 612, 677, 765, 703};
        int N = R.length - 1;

        System.out.println(Arrays.toString(R));

        System.out.println("-----");

        int[] L = new int[N + 1];

        L[0] = N;
        L[N] = 0;

        System.out.println("L：" + Arrays.toString(L));
        print(R, L);

        for (int j = N - 1; j > 0; j--) {
            int p = L[0];
            int q = 0;
            int t = R[j];

            System.out.println("t = " + t);

            while (R[p] < t && p > 0) {
                q = p;
                p = L[q];
            }

            L[q] = j;
            L[j] = p;

            System.out.println("L：" + Arrays.toString(L));
            print(R, L);
        }

        System.out.println("-----");
        print(R, L);
    }

    private static void print(int[] R, int[] L) {
        System.out.printf("R：");

        int p = L[0];
        while (p > 0) {
            System.out.printf("%d, ", R[p]);
            p = L[p];
        }

        System.out.println();
    }
}
