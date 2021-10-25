package org.g.dp.interpreter2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

class RMBUtil2Test {

    @Test
    void toCapital() {
        String expected;
        String actual;

        expected = "伍角叁分";
        actual = RMBUtil2.toChinese(new BigDecimal("0.53"));
        assertEquals(expected, actual);
        System.out.println("output = " + actual);

        expected = "伍角";
        actual = RMBUtil2.toChinese(new BigDecimal("0.50"));
        assertEquals(expected, actual);
        System.out.println("output = " + actual);

        expected = "叁分";
        actual = RMBUtil2.toChinese(new BigDecimal("0.03"));
        assertEquals(expected, actual);
        System.out.println("output = " + actual);

        expected = "壹仟贰佰叁拾肆元整";
        actual = RMBUtil2.toChinese(new BigDecimal("1234"));
        assertEquals(expected, actual);
        System.out.println("output = " + actual);

        expected = "壹仟元整";
        actual = RMBUtil2.toChinese(new BigDecimal("1000"));
        assertEquals(expected, actual);
        System.out.println("output = " + actual);

        expected = "壹佰元整";
        actual = RMBUtil2.toChinese(new BigDecimal("100"));
        assertEquals(expected, actual);
        System.out.println("output = " + actual);

        expected = "壹拾壹元整";
        actual = RMBUtil2.toChinese(new BigDecimal("11"));
        assertEquals(expected, actual);
        System.out.println("output = " + actual);

        expected = "壹元整";
        actual = RMBUtil2.toChinese(new BigDecimal("1.00"));
        assertEquals(expected, actual);
        System.out.println("output = " + actual);

        expected = "壹仟零壹元整";
        actual = RMBUtil2.toChinese(new BigDecimal("1001"));
        assertEquals(expected, actual);
        System.out.println("output = " + actual);

        expected = "壹佰零壹元整";
        actual = RMBUtil2.toChinese(new BigDecimal("101"));
        assertEquals(expected, actual);
        System.out.println("output = " + actual);

        expected = "壹仟零壹拾元整";
        actual = RMBUtil2.toChinese(new BigDecimal("1010"));
        assertEquals(expected, actual);
        System.out.println("output = " + actual);

        expected = "壹仟肆佰零玖元伍角";
        actual = RMBUtil2.toChinese(new BigDecimal("1409.50"));
        assertEquals(expected, actual);
        System.out.println("output = " + actual);

        expected = "陆仟零柒元壹角肆分";
        actual = RMBUtil2.toChinese(new BigDecimal("6007.14"));
        assertEquals(expected, actual);
        System.out.println("output = " + actual);

        expected = "壹仟陆佰捌拾元叁角贰分";
        actual = RMBUtil2.toChinese(new BigDecimal("1680.32"));
        assertEquals(expected, actual);
        System.out.println("output = " + actual);

        expected = "壹拾万柒仟元伍角叁分";
        actual = RMBUtil2.toChinese(new BigDecimal("107000.53"));
        assertEquals(expected, actual);
        System.out.println("output = " + actual);

        expected = "壹万陆仟肆佰零玖元零贰分";
        actual = RMBUtil2.toChinese(new BigDecimal("16409.02"));
        assertEquals(expected, actual);
        System.out.println("output = " + actual);

        expected = "叁佰贰拾伍元零肆分";
        actual = RMBUtil2.toChinese(new BigDecimal("325.04"));
        assertEquals(expected, actual);
        System.out.println("output = " + actual);

        expected = "壹拾亿元零壹分";
        actual = RMBUtil2.toChinese(new BigDecimal("1000000000.01"));
        assertEquals(expected, actual);
        System.out.println("output = " + actual);

        expected = "壹拾亿零壹拾万元零壹分";
        actual = RMBUtil2.toChinese(new BigDecimal("1000100000.01"));
        assertEquals(expected, actual);
        System.out.println("output = " + actual);

        expected = "壹拾亿零壹拾万元整";
        actual = RMBUtil2.toChinese(new BigDecimal("1000100000.00"));
        assertEquals(expected, actual);
        System.out.println("output = " + actual);

        expected = "壹拾贰亿叁仟肆佰伍拾陆万柒仟捌佰玖拾元玖角玖分";
        actual = RMBUtil2.toChinese(new BigDecimal("1234567890.99"));
        assertEquals(expected, actual);
        System.out.println("output = " + actual);
//
//        expected = "";
//        actual = RMBUtil2.toChinese(new BigDecimal(""));
//        assertEquals(expected, actual);
//        System.out.println("output = " + actual);
    }

    @Test
    void _seg() {
        assertEquals("壹仟贰佰叁拾肆元", RMBUtil2._seg(1234, RMBUtil2.NUMBERS, RMBUtil2.RADIX[0], false));
        assertEquals("壹仟零叁拾肆元", RMBUtil2._seg(1034, RMBUtil2.NUMBERS, RMBUtil2.RADIX[0], false));
        assertEquals("壹仟零肆元", RMBUtil2._seg(1004, RMBUtil2.NUMBERS, RMBUtil2.RADIX[0], false));
        assertEquals("壹仟零叁拾元", RMBUtil2._seg(1030, RMBUtil2.NUMBERS, RMBUtil2.RADIX[0], false));
        assertEquals("壹仟元", RMBUtil2._seg(1000, RMBUtil2.NUMBERS, RMBUtil2.RADIX[0], false));
        assertEquals("贰佰叁拾肆元", RMBUtil2._seg(234, RMBUtil2.NUMBERS, RMBUtil2.RADIX[0], false));
        assertEquals("贰佰零肆元", RMBUtil2._seg(204, RMBUtil2.NUMBERS, RMBUtil2.RADIX[0], false));
        assertEquals("贰佰元", RMBUtil2._seg(200, RMBUtil2.NUMBERS, RMBUtil2.RADIX[0], false));
        assertEquals("叁拾肆元", RMBUtil2._seg(34, RMBUtil2.NUMBERS, RMBUtil2.RADIX[0], false));
        assertEquals("叁拾元", RMBUtil2._seg(30, RMBUtil2.NUMBERS, RMBUtil2.RADIX[0], false));
        assertEquals("肆元", RMBUtil2._seg(4, RMBUtil2.NUMBERS, RMBUtil2.RADIX[0], false));

        assertEquals("叁角肆分", RMBUtil2._seg(34, RMBUtil2.DEC_UNIT, ' ', false));
        assertEquals("叁角", RMBUtil2._seg(30, RMBUtil2.DEC_UNIT, ' ', false));
        assertEquals("肆分", RMBUtil2._seg(4, RMBUtil2.DEC_UNIT, ' ', false));

    }
}