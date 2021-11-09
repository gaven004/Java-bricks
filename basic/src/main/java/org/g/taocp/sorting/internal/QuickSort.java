package org.g.taocp.sorting.internal;

import java.util.Arrays;
import java.util.Stack;

public class QuickSort {
    static class Pair {
        int l;
        int r;

        public Pair(int l, int r) {
            this.l = l;
            this.r = r;
        }
    }

    public static void main(String[] args) {
        int M = 4;

        // 按书中优化，置K[0]为最小值，K[N+1]为最大值
        int[] R = {Integer.MIN_VALUE, 503, 87, 512, 61, 908, 170, 897, 275, 653, 426, 154, 509, 612, 677, 765, 703, Integer.MAX_VALUE};
        int N = R.length - 2; // N = 16

        System.out.println(Arrays.toString(R));

        System.out.println("-----");

        if (N > M) {
            Stack<Pair> stack = new Stack<>();
            int l = 1; // left
            int r = N; // right

            do {
                int i = l;
                int j = r + 1;
                int T = R[l];

                do {
                    do {
                        i++;
                    } while (R[i] < T);

                    do {
                        j--;
                    } while (T < R[j]);

                    if (j <= i) {
                        swap(R, l, j);
                        break;
                    }

                    swap(R, i, j);
                } while (true);

                System.out.printf("l: %d, r: %d, t: %d, out: %s\n", l, r, T, Arrays.toString(R));

                if (r - j >= j - l) {
                    if (j - l > M) {
                        stack.push(new Pair(j + 1, r));
                        r = j - 1;
                        continue;
                    }

                    if (r - j > M) {
                        l = j + 1;
                        continue;
                    }
                } else {
                    if (r - j > M) {
                        stack.push(new Pair(l, j - 1));
                        l = j + 1;
                        continue;
                    }

                    if (j - l > M) {
                        r = j - 1;
                        continue;
                    }
                }

                if (stack.empty()) {
                    break;
                }

                Pair p = stack.pop();
                l = p.l;
                r = p.r;
            } while (true);
        }

        // 整个序列做一次插入排序
        for (int j = 2; j <= N; j++) {
            int i = j - 1;
            if (R[i] > R[j]) {
                int T = R[j];
                do {
                    R[i + 1] = R[i];
                    i--;
                } while (T < R[i]);
                R[i + 1] = T;
            }

//            System.out.println(Arrays.toString(R));
        }

        System.out.println("-----");
        System.out.println(Arrays.toString(R));
    }

    private static void swap(int[] R, int i, int j) {
        int t = R[i];
        R[i] = R[j];
        R[j] = t;
    }
}
