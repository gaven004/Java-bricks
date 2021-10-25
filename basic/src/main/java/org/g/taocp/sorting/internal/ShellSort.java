package org.g.taocp.sorting.internal;

import java.util.Arrays;

public class ShellSort {
    public static void main(String[] args) {
        int[] R = {503, 87, 512, 61, 908, 170, 897, 275, 653, 426, 154, 509, 612, 677, 765, 703};
        int N = R.length;

        System.out.println(Arrays.toString(R));

        int c = 0;

//        int[] H = {8, 4, 2, 1};
        int[] H = {7, 5, 3, 1};

        for (int h : H) {
            for (int j = h; j < N; j++) {
                int i = j - h;
                int T = R[j];

                for (; i >= 0 && R[i] > T; i -= h) {
                    R[i + h] = R[i];
                    c++;
                }

                R[i + h] = T;
                c++;
            }

            System.out.println(Arrays.toString(R));
        }

        System.out.println("c = " + c);
    }
}
