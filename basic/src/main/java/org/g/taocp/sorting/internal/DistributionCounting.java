package org.g.taocp.sorting.internal;

import java.util.Arrays;

/**
 * 算法强调键码的范围比较小，其复杂度为 2N + 键码范围
 */
public class DistributionCounting {
    static final int MAX = 999;

    public static void main(String[] args) {
        // 源记录（键码）
        int[] K = {503, 87, 512, 61, 908, 170, 897, 275, 653, 426, 154, 509, 612, 677, 765, 703};

        int N = K.length;

        // 排序后记录
        int[] S = new int[N];

        // 辅助表
        int[] count = new int[MAX + 1];

        // 清空count
        Arrays.fill(count, 0);

        // 统计键码个数
        for (int j = 0; j < N; j++) {
            count[K[j]] = count[K[j]] + 1;
        }

        // 累计
        for (int i = 2; i <= MAX; i++) {
            count[i] = count[i] + count[i - 1];
        }

        // 这时count[i]是小于或等于i的键码的个数，特别有count[MAX] = N
        // 也就是键值为i的记录，应该排在第几位

        for (int j = K.length - 1; j >= 0; j--) {
            int i = count[K[j]];
            S[i - 1] = K[j];

            // 处理重复的键值，输出后该键码的计数减1
            // 注：中文译本的D6步骤有误！！
            count[K[j]] = i - 1;
        }

        System.out.println(Arrays.toString(S));
    }
}
