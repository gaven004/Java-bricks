package org.g.taocp.sorting.internal;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        // 稍做变化，改为与书中的下标 1...N 一致
        int[] R = {0, 503, 87, 512, 61, 908, 170, 897, 275, 653, 426, 154, 509, 612, 677, 765, 703};
        int N = R.length - 1;

        System.out.println(Arrays.toString(R));

        int BOUND = N;
        do {
            int t = 0;
            for (int j = 1; j < BOUND; j++) {
                if (R[j] > R[j + 1]) {
                    int i = R[j];
                    R[j] = R[j + 1];
                    R[j + 1] = i;

                    t = j;
                }
            }

            if (t == 0) {
                break;
            } else {
                BOUND = t;
            }

            System.out.println(Arrays.toString(R));
        } while (true);

        System.out.println(Arrays.toString(R));
    }
}
