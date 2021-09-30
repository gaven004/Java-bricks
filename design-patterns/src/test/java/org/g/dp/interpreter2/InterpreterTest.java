package org.g.dp.interpreter2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class InterpreterTest {
    @Test
    public void interpret() {
        Context context = new Context(123400, '元');
        Interpreter interpreter = new Interpreter();
        interpreter.interpret(context);
        String expected = "壹仟贰佰叁拾肆元整";
        String actual = context.getOutput();
        assertEquals(expected, actual);
        System.out.println("output = " + actual);

        context = new Context(100000, '元');
        interpreter.interpret(context);
        expected = "壹仟元整";
        actual = context.getOutput();
        assertEquals(expected, actual);
        System.out.println("output = " + actual);

        context = new Context(10000, '元');
        interpreter.interpret(context);
        expected = "壹佰元整";
        actual = context.getOutput();
        assertEquals(expected, actual);
        System.out.println("output = " + actual);

        context = new Context(1100, '元');
        interpreter.interpret(context);
        expected = "壹拾壹元整";
        actual = context.getOutput();
        assertEquals(expected, actual);
        System.out.println("output = " + actual);

        context = new Context(100, '元');
        interpreter.interpret(context);
        expected = "壹元整";
        actual = context.getOutput();
        assertEquals(expected, actual);
        System.out.println("output = " + actual);

        context = new Context(100100, '元');
        interpreter.interpret(context);
        expected = "壹仟零壹元整";
        actual = context.getOutput();
        assertEquals(expected, actual);
        System.out.println("output = " + actual);

        context = new Context(10100, '元');
        interpreter.interpret(context);
        expected = "壹佰零壹元整";
        actual = context.getOutput();
        assertEquals(expected, actual);
        System.out.println("output = " + actual);

        context = new Context(101000, '元');
        interpreter.interpret(context);
        expected = "壹仟零壹拾元整";
        actual = context.getOutput();
        assertEquals(expected, actual);
        System.out.println("output = " + actual);

        context = new Context(140950);
        interpreter.interpret(context);
        expected = "壹仟肆佰零玖元伍角";
        actual = context.getOutput();
        assertEquals(expected, actual);
        System.out.println("output = " + actual);

        context = new Context(600714);
        interpreter.interpret(context);
        expected = "陆仟零柒元壹角肆分";
        actual = context.getOutput();
        assertEquals(expected, actual);
        System.out.println("output = " + actual);

        context = new Context(168032);
        interpreter.interpret(context);
        expected = "壹仟陆佰捌拾元叁角贰分";
        actual = context.getOutput();
        assertEquals(expected, actual);
        System.out.println("output = " + actual);

        context = new Context(10700053);
        interpreter.interpret(context);
        expected = "壹拾万柒仟元伍角叁分";
        actual = context.getOutput();
        assertEquals(expected, actual);
        System.out.println("output = " + actual);

        context = new Context(1640902);
        interpreter.interpret(context);
        expected = "壹万陆仟肆佰零玖元零贰分";
        actual = context.getOutput();
        assertEquals(expected, actual);
        System.out.println("output = " + actual);

        context = new Context(32504);
        interpreter.interpret(context);
        expected = "叁佰贰拾伍元零肆分";
        actual = context.getOutput();
        assertEquals(expected, actual);
        System.out.println("output = " + actual);

        context = new Context(53);
        interpreter.interpret(context);
        expected = "伍角叁分";
        actual = context.getOutput();
        assertEquals(expected, actual);
        System.out.println("output = " + actual);

        context = new Context(50);
        interpreter.interpret(context);
        expected = "伍角";
        actual = context.getOutput();
        assertEquals(expected, actual);
        System.out.println("output = " + actual);

        context = new Context(2);
        interpreter.interpret(context);
        expected = "贰分";
        actual = context.getOutput();
        assertEquals(expected, actual);
        System.out.println("output = " + actual);

        context = new Context(100000000001L);
        interpreter.interpret(context);
        expected = "壹拾亿元零壹分";
        actual = context.getOutput();
        assertEquals(expected, actual);
        System.out.println("output = " + actual);

        context = new Context(100010000001L);
        interpreter.interpret(context);
        expected = "壹拾亿零壹拾万元零壹分";
        actual = context.getOutput();
        assertEquals(expected, actual);
        System.out.println("output = " + actual);

        context = new Context(100010000000L);
        interpreter.interpret(context);
        expected = "壹拾亿零壹拾万元整";
        actual = context.getOutput();
        assertEquals(expected, actual);
        System.out.println("output = " + actual);

        context = new Context(123456789099L);
        interpreter.interpret(context);
        expected = "壹拾贰亿叁仟肆佰伍拾陆万柒仟捌佰玖拾元玖角玖分";
        actual = context.getOutput();
        assertEquals(expected, actual);
        System.out.println("output = " + actual);
    }
}