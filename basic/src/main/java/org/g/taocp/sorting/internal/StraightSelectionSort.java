package org.g.taocp.sorting.internal;

import java.util.Arrays;

public class StraightSelectionSort {
    public static void main(String[] args) {
        int[] R = {0, 503, 87, 512, 61, 908, 170, 897, 275, 653, 426, 154, 509, 612, 677, 765, 703};
        int N = R.length - 1;

        System.out.println(Arrays.toString(R));

        for (int j = N; j > 1; j--) {
            int i = j;
            for (int k = j - 1; k > 0; k--) {
                if (R[k] > R[i]) {
                    i = k;
                }
            }
            swap(R, i, j);
        }

        System.out.println(Arrays.toString(R));
    }

    private static void swap(int[] R, int i, int j) {
        int t = R[i];
        R[i] = R[j];
        R[j] = t;
    }
}
