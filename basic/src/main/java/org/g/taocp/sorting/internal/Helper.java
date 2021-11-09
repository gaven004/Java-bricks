package org.g.taocp.sorting.internal;

public class Helper {
    public static void swap(int[] R, int i, int j) {
        int t = R[i];
        R[i] = R[j];
        R[j] = t;
    }
}
