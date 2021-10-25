package org.g.taocp.sorting.internal;

public class ListInsertion {
    public static void main(String[] args) {
        // 稍做变化，改为与书中的下标 1...N 一致
        int[] R = {0, 503, 87, 512, 61, 908, 170, 897, 275, 653, 426, 154, 509, 612, 677, 765, 703};
        int N = R.length - 1;

        int[] L = new int[N + 1];

        L[0] = N;
        L[N] = 0;

        for (int j = N - 1; j > 0; j--) {
            int p = L[0];
            int q = 0;
            int t = R[j];

            while (R[p] < t && p > 0) {
                q = p;
                p = L[q];
            }

            L[q] = j;
            L[j] = p;
        }

        int p = L[0];
        while (p > 0) {
            System.out.printf("%d, ", R[p]);
            p = L[p];
        }
    }
}
