package org.g.taocp.sorting.internal;

import java.util.StringJoiner;

/**
 * List merge sort
 */
public class MergeSort3 {
    public static void main(String[] args) {
        int[] R = {Integer.MIN_VALUE,
                503, 87, 512, 61, 908, 170, 897, 275, 653, 426, 154, 509, 612, 677, 765, 703,
                Integer.MAX_VALUE};
        int[] L = new int[R.length];
        int N = R.length - 2;

        // L1
        L[0] = 1;
        L[N + 1] = 2;
        for (int i = 1; i <= N - 2; i++) {
            L[i] = -(i + 2);
        }
        L[N - 1] = 0;
        L[N] = 0;

        /*
         * L1建立了两个链表，第一个是R1,R3,R5,...，第一个是R2,R4,R5,...
         * L[0]、L[N+1]分别指向表头，L[N-1]、L[N]为0代表表尾
         * L[i]为负时，表示一个链接指向，并不是有序的
         * L[i]为正时，表示指向的下一个元素小于当前元素
         */

        int s; // 指向当前处理的记录
        int t; // 指向上一个处理的链表的末尾
        int p, q; // 用于遍历链表辅助指针

        while (true) {
            printL(L);

            // 开始新一轮的扫描合并

            /*
             * 第一轮从无序的链表开始，两两排序合并，形成N/2个已排序的链表
             * 第二轮是对上一轮的N/2个已排序的链表两合并，链表数减少一半
             * 直至最后合并成一个有序的
             */

            // L2
            s = 0; // L1中建立两个链表的表头
            t = N + 1; // L1中建立两个链表的表头
            p = L[s];
            q = L[t];

            if (q == 0) {
                // 当L[N + 1] = 0时，排序完成
                break;
            }

            while (true) {
                /*
                 * 合并两个有序的链表
                 */

                // L3
                if (R[p] <= R[q]) {
                    // L4
                    L[s] = L[s] > 0 ? p : -p;
                    s = p;
                    p = L[p];
                    if (p > 0) {
                        continue;
                        // return to L3
                    }

                    // L5
                    L[s] = q;
                    s = t;
                    do {
                        t = q;
                        q = L[q];
                    } while (q > 0);
                } else {
                    // L6
                    L[s] = L[s] > 0 ? q : -q;
                    s = q;
                    q = L[q];
                    if (q > 0) {
                        continue;
                        // return to L3
                    }

                    // L7
                    L[s] = p;
                    s = t;
                    do {
                        t = p;
                        p = L[p];
                    } while (p > 0);
                }

                // L8
                p = -p;
                q = -q;
                if (q == 0) {
                    L[s] = L[s] > 0 ? p : -p;
                    L[t] = 0;
                    break;
                    // return to L2
                }

                // return to L3
            }
        }

        // 最后结果，L[0]为最小记录的下标，L[k]是R[k]下一个记录的下标，当L[m]=0时，R[m]是最大的元素
        printResult(R, L);
    }

    private static void printL(int[] l) {
        StringJoiner joiner = new StringJoiner(", ", "[", "]");
        for (int t = 0; t < l.length; t++) {
            joiner.add(String.format("%3d", l[t]));
        }
        System.out.println(joiner.toString());
    }

    private static void printResult(int[] r, int[] l) {
        StringJoiner joiner = new StringJoiner(", ", "[", "]");
        int p = l[0];
        while (p > 0) {
            joiner.add(String.format("%3d", r[p]));
            p = l[p];
        }
        System.out.println("Result: ");
        System.out.println(joiner.toString());
    }
}
