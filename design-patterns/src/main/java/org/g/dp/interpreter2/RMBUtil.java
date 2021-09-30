package org.g.dp.interpreter2;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class RMBUtil {
    // 大写数字
    static final char DIGITS[] = {'零', '壹', '贰', '叁', '肆', '伍', '陆', '柒', '捌', '玖'};
    // 大写单位
    static final char INT_RADICES[] =
            {'仟', '佰', '拾', ' ', '仟', '佰', '拾', ' ', '仟', '佰', '拾', ' '};

    static final char UNITS[] =
            {'亿', '亿', '亿', '亿', '万', '万', '万', '万', '元', '元', '元', '元'};

    static final char DEC_RADICES[] = {'角', '分'};

    protected static final char ZHENG = '整';

    protected static final long MAX_VALUE = 1000000000000L;

    public static final String toRMB(BigDecimal amount) {
        long v = amount.longValue();

        if (v >= MAX_VALUE) {
            throw new IllegalArgumentException("Exceeds the maximum value");
        }

        if (BigDecimal.ZERO.compareTo(amount) == 0) {
            return "零元整";
        }

        amount = amount.setScale(2, RoundingMode.HALF_UP);
        String str = amount.toPlainString();

        char[] buff = new char[32];
        int i, j, k;
        int r, z;

        j = 0;
        k = str.length() - 3;

        if (v > 0) {
            for (i = 0, r = INT_RADICES.length - k, z = 0; i < k; i++, r++) {
                if (str.charAt(i) != '0') {
                    buff[j++] = DIGITS[str.charAt(i) - '0'];
                    buff[j++] = INT_RADICES[r];
                } else {
                    z++; // 0的计数器
                    // 连接的0，只需要写一个'零'
                    if (buff[j - 1] != DIGITS[0]) {
                        buff[j++] = DIGITS[0];
                    }
                }

                if (INT_RADICES[r] == ' ') {
                    // 若是每个一分段位置，处理补上单位
                    if (z < 4 || r + 1 == INT_RADICES.length) {
                        // 若整一个分段不全为0，补上单位
                        // 或最后一位的单位'元'，必须补上
                        buff[j - 1] = UNITS[r];
                    } else {
                        // 若整一个分段都为0，则不需要写'零'
                        j--;
                    }
                    z = 0;
                }
            }
        }

        // 小数部分
        i = k + 1;
        if (str.charAt(i) == '0' && str.charAt(i + 1) == '0') {
            // 小数部分全是0
            buff[j++] = ZHENG;
        } else {
            // 角
            r = 0;
            if (str.charAt(i) != '0') {
                buff[j++] = DIGITS[str.charAt(i) - '0'];
                buff[j++] = DEC_RADICES[r];
            } else {
                if (j > 0) {
                    buff[j++] = DIGITS[0];
                }
            }

            // 分
            r++;
            i++;
            if (str.charAt(i) != '0') {
                buff[j++] = DIGITS[str.charAt(i) - '0'];
                buff[j++] = DEC_RADICES[r];
            }
        }

        return new String(buff, 0, j);
    }
}
