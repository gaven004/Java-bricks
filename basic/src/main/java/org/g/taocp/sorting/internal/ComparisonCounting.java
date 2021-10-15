package org.g.taocp.sorting.internal;

import java.util.Arrays;

public class ComparisonCounting {

    public static void main(String[] args) {
        int[] K = {503, 87, 512, 61, 908, 170, 897, 275, 653, 426, 154, 509, 612, 677, 765, 703};
        System.out.println(Arrays.toString(K));

        int N = K.length;

        int[] count = new int[N];

        Arrays.fill(count, 0);
        System.out.println(Arrays.toString(count));

        for (int i = N - 1; i >= 1; i--) {
            for (int j = i - 1; j >= 0; j--) {
                if (K[i] < K[j]) {
                    count[j] = count[j] + 1;
                } else {
                    count[i] = count[i] + 1;
                }
            }

            System.out.println(Arrays.toString(count));
        }
    }
}
