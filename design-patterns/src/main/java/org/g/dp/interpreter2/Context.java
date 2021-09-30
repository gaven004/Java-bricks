package org.g.dp.interpreter2;

public class Context {
    private long input;
    private String output;
    private char radix;
    private char[] unit;

    public Context() {
        this.output = "";
    }

    public Context(long input) {
        this.input = input;
        this.output = "";
    }

    public Context(long input, char radix) {
        this.radix = radix;
        this.input = input;
        this.output = "";
    }

    public Context(long input, char radix, char[] unit) {
        this.radix = radix;
        this.input = input;
        this.output = "";
        this.unit = unit;
    }

    public long getInput() {
        return input;
    }

    public void setInput(long input) {
        this.input = input;
    }

    public String getOutput() {
        return output;
    }

    public void setOutput(String output) {
        this.output = output;
    }

    public char getRadix() {
        return radix;
    }

    public void setRadix(char radix) {
        this.radix = radix;
    }

    public char[] getUnit() {
        return unit;
    }

    public void setUnit(char[] unit) {
        this.unit = unit;
    }
}
