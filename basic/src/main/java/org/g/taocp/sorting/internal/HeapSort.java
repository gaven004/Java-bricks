package org.g.taocp.sorting.internal;

import java.util.Arrays;

/**
 * 堆排序
 *
 * 借鉴体育的淘汰制，两两比较，优者胜出
 * 挑选出冠军后，余下中再选第最好的，则只需要在涉及冠军的链上，
 * 再进行一些附加赛即可，其它链条不受影响
 *
 * 堆排序类似于
 * 对于一个1..N的序列，如果
 * 每一个 1 <= floor(j/2) < j <= N，都有 R[floor(j/2)] >= R[j]
 * 则称之为堆，堆的第一个元素为最大值
 * 输出第一个元素，将涉及通道上的元素调整，又转换成一个堆，如此不断
 * 对于这个一个选择排序，大体与 N * log(N) 成比例
 */
public class HeapSort {
    public static void main(String[] args) {
        // 稍做变化，改为与书中的下标 1...N 一致
        int[] R = {0, 503, 87, 512, 61, 908, 170, 897, 275, 653, 426, 154, 509, 612, 677, 765, 703};
        int N = R.length - 1;

        System.out.println(Arrays.toString(R));

        int l = N / 2 + 1;
        int r = N;
        int T;

        while (true) {
            if (l > 1) {
                // 将源数据变换成一个堆
                l--;
                T = R[l];
            } else {
                // 输出第一个元素到右边，余下的元素再整理成一个堆
                T = R[r];
                R[r] = R[1];
                r--;
            }

            if (r == 1) {
                R[1] = T;
                break;
            }

            int j = l;
            int i;

            // 调整，使得每一个 1 <= floor(j/2) < j <= N，都有 R[floor(j/2)] >= R[j]
            while (true) {
                i = j;
                j = 2 * j;

                if (j > r) {
                    break;
                }

                if (j < r) {
                    // 找较大的一个
                    if (R[j] < R[j + 1]) {
                        j++;
                    }
                }

                if (T >= R[j]) {
                    // 已确定T的位置，可以退出
                    break;
                }

                // 上升
                R[i] = R[j];
            }

            R[i] = T;

            System.out.printf("out: %s, \tl: %d, \tr: %d, \tt: %d\n",
                    Arrays.toString(Arrays.copyOfRange(R, 1, N + 1)), l, r, T);
        }

        R[1] = T;
        System.out.println(Arrays.toString(R));
    }
}
