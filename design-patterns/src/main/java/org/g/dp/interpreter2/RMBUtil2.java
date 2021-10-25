package org.g.dp.interpreter2;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class RMBUtil2 {
    // 大写数字
    static final char DIGITS[] = {'零', '壹', '贰', '叁', '肆', '伍', '陆', '柒', '捌', '玖'};
    // 数位
    static final char NUMBERS[] = {' ', '拾', '佰', '仟'};
    // 整数部分单位
    static final char RADIX[] = {'亿', '万', '元'};
    static final long RADIX_VAL[] = {1_0000_0000, 1_0000, 1};
    // 小数部分单位
    static final char DEC_UNIT[] = {'分', '角'};

    protected static final char ZHENG = '整';

    protected static final long MAX_VALUE = 10000_0000_0000_00L;

    /**
     * 金额转换为中文大写
     */
    public static final String toChinese(BigDecimal amount) {
        long v = amount.setScale(2, RoundingMode.HALF_UP).unscaledValue().longValue();

        if (v >= MAX_VALUE) {
            throw new IllegalArgumentException("Exceeds the maximum value");
        }

        if (v == 0) {
            return "零元整";
        }

        StringBuilder sb = new StringBuilder();

        long segI = v / 100; // 整数部分
        long segD = v % 100; // 小数部分

        long q = 0; // 商
        long r; // 余数

        // 整数部分
        if (segI > 0) {
            int i;

            r = segI;

            for (i = 0; i < RADIX.length && r > 0; i++) {
                q = r / RADIX_VAL[i];
                r = r % RADIX_VAL[i];

                if (q > 0) {
                    sb = sb.append(_seg((int) q, NUMBERS, RADIX[i], sb.length() != 0));
                }
            }

            // 当后边的分段为0时，补上单位元
            if (i < RADIX.length) {
                sb = sb.append('元');
            }
        }

        if (segD == 0) {
            return sb.append(ZHENG).toString();
        }

        // 小数部分
        sb = sb.append(_seg((int) segD, DEC_UNIT, ' ', sb.length() != 0));

        return sb.toString();
    }

    /**
     * 按中文习惯，每4位（千）分段处理
     */
    static final String _seg(int v, char[] numbers, char radix, boolean subsequent) {
        int l = 8; // buff长
        int i = l; // 下标
        char[] buff = new char[l + 1];

        int c = 0; // 位数计

        int q = v; // 商
        int r; // 余数

        do {
            r = q % 10;
            q = q / 10;

            if (r != 0) {
                buff[--i] = numbers[c];
                buff[--i] = DIGITS[r];
            } else {
                // 阿拉伯数字中间连续有几个“0”时、中文大写金额中间可以只写一个“零”字
                if (q > 0 && i < l && buff[i] != DIGITS[0]) {
                    buff[--i] = DIGITS[r];
                }
            }

            c++;
        } while (q > 0);

        // 处理亿、万、个这些每节的底单位
        // 角、分转换时则不需要添加底单位
        if (radix != ' ') {
            if (buff[l - 1] == ' ') {
                buff[l - 1] = radix;
            } else {
                buff[l] = radix;
                l++;
            }
        }

        // 前节非空，本节的最高位为0，补写一个“零”
        if (subsequent && c < numbers.length) {
            buff[--i] = DIGITS[0];
        }

        return new String(buff, i, l - i);
    }
}
