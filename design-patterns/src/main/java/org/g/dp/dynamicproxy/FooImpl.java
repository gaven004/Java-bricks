package org.g.dp.dynamicproxy;

public class FooImpl implements Foo {
    public Object bar(Object obj) throws BazException {
        System.out.println("bar---");
        // ...
        return null;
    }
}