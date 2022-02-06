package org.g.taocp.sorting.internal;

import java.util.StringJoiner;

/**
 * Natural two-way merge sort
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] R = {Integer.MIN_VALUE,
                503, 87, 512, 61, 908, 170, 897, 275, 653, 426, 154, 509, 612, 677, 765, 703,
                0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int N = 16;

        // N1
        int s = 0;
        int i, j, k, l;
        int d, f;
        int t;

        print(R, N, 1);

        while (true) {
            // N2
            // s = 0时，是从区域1～N，输出至N+1 ~ 2N
            // s = 1时，则是反向
            if (s == 0) {
                i = 1; // 输入区起
                j = N; // 输入区止
                k = N + 1; // 输出区起
                l = 2 * N; // 输出区止
            } else {
                i = N + 1; // 输入区起
                j = 2 * N; // 输入区止
                k = 1; // 输出区起
                l = N; // 输出区止
            }
            d = 1; // 操作方向，1是正向，-1是反向
            f = 1; // 标志位，为0时代表需要继续操作，1是结束

            while (true) {
                // N3
                if (i == j) {
                    // i,j相等时，即为最后一个元素
                    // 输出最后一个元素，并跳出
                    R[k] = R[i];
                    break;
                }

                if (R[i] <= R[j]) {
                    // 输出小的一端
                    // 保持升序，合并到新区域前端指定的位置

                    // N4、N5处理一端队列，N6、N7处理另一端

                    // N4
                    R[k] = R[i];
                    k = k + d;

                    // N5
                    i++;
                    if (R[i - 1] <= R[i]) {
                        continue;
                        // go back to N3
                    }

                    // 不再是保持升序，合并另外一端
                    while (true) {
                        // N6
                        R[k] = R[j];
                        k = k + d;

                        // N7
                        j--;
                        if (R[j + 1] <= R[j]) {
                            continue;
                            // go back to N6
                        } else {
                            break;
                            // go to N12
                        }
                    }
                } else {
                    // 输出大的一端
                    // 与N4 ～ N7的处理逻辑一致，只是方向不同

                    // N8
                    R[k] = R[j];
                    k = k + d;

                    // N9
                    j--;
                    if (R[j + 1] <= R[j]) {
                        continue;
                        // go back to N3
                    }

                    while (true) {
                        // N10
                        R[k] = R[i];
                        k = k + d;

                        // N11
                        i++;
                        if (R[i - 1] <= R[i]) {
                            continue;
                            // go back to N10
                        } else {
                            break;
                            // go to N12
                        }
                    }
                }

                // N12
                // 有合并操作，则置标志位，转一个方向，再走一次逻辑
                f = 0;
                d = -d;
                // interchange k & l
                t = k;
                k = l;
                l = t;
                // return to N3
            }

            // N13
            if (f == 0) {
                print(R, N, s);

                s = 1 - s;
                // return to N2
            } else {
                // sorting is complete
                break;
            }
        }

        print(R, N, s);
    }

    private static void print(int[] r, int n, int s) {
        StringJoiner joiner = new StringJoiner(", ", "[", "]");

        int t;
        if (s == 0) {
            t = n + 1;
            n = 2 * n;
        } else {
            t = 1;
        }

        for (; t <= n; t++) {
            joiner.add(String.format("%3d", r[t]));
        }

        System.out.println(joiner.toString());
    }
}
