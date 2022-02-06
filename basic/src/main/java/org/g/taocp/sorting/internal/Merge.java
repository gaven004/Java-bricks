package org.g.taocp.sorting.internal;

import java.util.Arrays;

/**
 * 合并两个有序的队列
 */
public class Merge {
    public static void main(String[] args) {
        int[] x = {0, 503, 703, 765};
        int[] y = {0, 87, 512, 677};

        int m = x.length - 1;
        int n = y.length - 1;

        int[] z = new int[m + n + 1];

        int i = 1;
        int j = 1;
        int k = 1;

        while (true) {
            if (x[i] <= y[j]) {
                z[k] = x[i];
                k++;
                i++;
                if (i > m) {
                    while (k <= (m + n)) {
                        z[k] = y[j];
                        k++;
                        j++;
                    }
                    break;
                }
            } else {
                z[k] = y[j];
                k++;
                j++;
                if (j > n) {
                    while (k <= (m + n)) {
                        z[k] = x[i];
                        k++;
                        i++;
                    }
                    break;
                }
            }
        }

        System.out.println(Arrays.toString(z));
    }
}
