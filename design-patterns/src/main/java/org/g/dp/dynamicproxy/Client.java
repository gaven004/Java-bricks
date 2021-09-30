package org.g.dp.dynamicproxy;

public class Client {
    public static void main(String[] args) {
        Foo debugFoo = (Foo) DebugProxy.newInstance(new FooImpl());
        try {
            debugFoo.bar(null);
        } catch (BazException e) {
            e.printStackTrace();
        }

        Foo timingFoo = (Foo) TimingProxy.newInstance(new FooImpl());
        try {
            timingFoo.bar(null);
        } catch (BazException e) {
            e.printStackTrace();
        }
    }
}
