package org.g.taocp.sorting.internal;

import java.util.Arrays;

public class StraightInsertionSort {
    public static void main(String[] args) {
        int[] R = {503, 87, 512, 61, 908, 170, 897, 275, 653, 426, 154, 509, 612, 677, 765, 703};
        int N = R.length;

        System.out.println(Arrays.toString(R));

        int c = 0;

        for (int j = 1; j < N; j++) {
            /*
             * 从最后一个已排序的元素开始比较，直至R[i] <= T
             * 比较和交换同一循环中进行
             */
            int i = j - 1;
            int T = R[j];

            for (; i >= 0 && R[i] > T; i--) {
                R[i + 1] = R[i];
                c++;
            }

            R[i + 1] = T;
            c++;

            System.out.println(Arrays.toString(R));
        }

        System.out.println("c = " + c);

    }
}
