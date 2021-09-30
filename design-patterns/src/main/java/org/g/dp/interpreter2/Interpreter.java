package org.g.dp.interpreter2;

public class Interpreter {
    // 大写数字
    protected static final char NUMERALS[] = {'零', '壹', '贰', '叁', '肆', '伍', '陆', '柒', '捌', '玖'};
    // 大写单位
    protected static final char INT_UNIT[] = {' ', '拾', '佰', '仟'};

    protected static final char DEC_UNIT[] = {'分', '角'};

    protected static final char RADIX[] = {'元', '万', '亿'};

    protected static final int RADIX_VAL[] = {1, 10000, 100000000};

    protected static final char ZHENG = '整';

    protected static final long MAX_VALUE = 100000000000000L;

    public void interpret(Context context) {
        long v = context.getInput();

        if (v >= MAX_VALUE) {
            throw new IllegalArgumentException("Exceeds the maximum value");
        }

        if (v == 0) {
            context.setOutput("零元整");
            return;
        }

        long segI = v / 100; // 整数部分
        long segD = v % 100; // 小数部分

        long q; // 商
        long r; // 余数

        // 整数部分
        if (segI > 0) {
            q = segI;
            r = q;
            context.setUnit(INT_UNIT);

            // 分节处理，中文中，数字4位为一节，即个、十、百、千，
            // 之后进级一个大单位，万、亿这样
            for (int i = RADIX.length - 1; i > 0; i--) {
                if (q >= RADIX_VAL[i]) {
                    r = q % RADIX_VAL[i];
                    q = q / RADIX_VAL[i];
                    context.setInput(q);
                    context.setRadix(RADIX[i]);
                    _segInterpret(context);
                    q = r;
                }
            }

            if (r > 0) {
                context.setInput(r);
                context.setRadix(RADIX[0]);
                _segInterpret(context);
            } else {
                context.setOutput(context.getOutput() + "元");
            }
        }

        if (segD == 0) {
            context.setOutput(context.getOutput() + "整");
            return;
        }

        // 小数部分
        // 也使用分节处理中的算法，只是单位从个、十，转换成角、分
        // 其它的规则与前一致
        context.setInput(segD);
        context.setUnit(DEC_UNIT);
        context.setRadix(' ');
        _segInterpret(context);
    }

    void _segInterpret(Context context) {
        long v = context.getInput();
        char[] unit = context.getUnit();

        int c = 0; // 位数计

        long q = v; // 商
        int r; // 余数

        int l = 8; // buff长
        int i = l; // 下标
        char[] buff = new char[l + 1];

        do {
            r = (int) (q % 10);
            q = q / 10;

            if (r != 0) {
                buff[--i] = unit[c];
                buff[--i] = NUMERALS[r];
            } else {
                // 阿拉伯数字中间连续有几个“0”时、中文大写金额中间可以只写一个“零”字
                if (q > 0 && i < l && buff[i] != NUMERALS[0]) {
                    buff[--i] = NUMERALS[r];
                }
            }

            c++;
        } while (q > 0);

        // 处理亿、万、个这些每节的底单位
        if (buff[l - 1] == ' ') {
            buff[l - 1] = context.getRadix();
        } else {
            buff[l] = context.getRadix();
            l++;
        }

        // 解释角、分时，底单位为' '，删除
        if (context.getRadix() == ' ') {
            l--;
        }

        String src = context.getOutput();
        // 前节非空，本节的最高位为0，补写一个“零”
        if (src.length() > 0 && c < unit.length) {
            buff[--i] = NUMERALS[0];
        }

        context.setOutput(src + new String(buff, i, l - i));
    }
}
