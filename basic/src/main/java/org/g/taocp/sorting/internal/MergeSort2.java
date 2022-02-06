package org.g.taocp.sorting.internal;

import java.util.StringJoiner;

/**
 * Straight two-way merge sort
 */
public class MergeSort2 {
    public static void main(String[] args) {
        int[] R = {Integer.MIN_VALUE,
                503, 87, 512, 61, 908, 170, 897, 275, 653, 426, 154, 509, 612, 677, 765, 703, 101, 106,
                0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int N = 18;

        // S1
        int s = 0;
        int i, j, k, l;
        int d;
        int p = 1; // 递增路段的大小
        int q, r;
        int t;

        print(R, N, 1);

        while (true) {
            // S2
            // s = 0时，是从区域1～N，输出至N+1 ~ 2N
            // s = 1时，则是反向
            if (s == 0) {
                i = 1; // 输入区起
                j = N; // 输入区止
                k = N; // 输出区起
                l = 2 * N + 1; // 输出区止
            } else {
                i = N + 1; // 输入区起
                j = 2 * N; // 输入区止
                k = 0; // 输出区起
                l = N + 1; // 输出区止
            }
            d = 1; // 操作方向，1是正向，-1是反向
            q = p;
            r = p;

            S3:
            while (true) {
                // S3, compare
                if (R[i] <= R[j]) {
                    // S4
                    k += d;
                    R[k] = R[i];

                    // S5
                    i++;
                    q--;
                    if (q > 0) {
                        continue S3;
                        // go back to S3
                    }

                    while (true) {
                        // S6
                        k += d;
                        if (k == l) {
                            break S3;
                            // go to S13
                        } else {
                            R[k] = R[j];
                        }

                        // S7
                        j--;
                        r--;
                        if (r > 0) {
                            continue;
                            // go back to S6
                        } else {
                            break;
                            // go to S12
                        }
                    }
                } else {
                    // S8
                    k += d;
                    R[k] = R[j];

                    // S9
                    j--;
                    r--;
                    if (r > 0) {
                        continue;
                        // go back to S3
                    }

                    while (true) {
                        // S10
                        k += d;
                        if (k == l) {
                            break S3;
                            // go to S13
                        } else {
                            R[k] = R[i];
                        }

                        // S11
                        i++;
                        q--;
                        if (q > 0) {
                            continue;
                        } else {
                            break;
                        }
                    }
                }

                S12:
                while (true) {
                    // S12
                    q = p;
                    r = p;
                    d = -d;
                    // interchange k & l
                    t = k;
                    k = l;
                    l = t;

                    if (j - i < p) {
                        // 注意这一步，处理队列长度不是2的N次时
                        while (true) {
                            // S10
                            k += d;
                            if (k == l) {
                                break S3;
                            } else {
                                R[k] = R[i];
                            }

                            // S11
                            i++;
                            q--;
                            if (q > 0) {
                                continue;
                            } else {
                                break;
                            }
                        }
                    } else {
                        break;
                        // return to S3
                    }
                }
            }

            // S13
            p = p + p; // 增加路段的长度，原为p长的两路段，合并后长度为2p，且有序
            if (p < N) {
                print(R, N, s);

                s = 1 - s;
                // return to S2
            } else {
                break;
                // sorting is complete
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
