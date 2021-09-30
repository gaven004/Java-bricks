package org.g.dp.factorymethod;

public abstract class Creator {
    public abstract Product createProduct();

    public void doSomething() {
        Product p = createProduct();
        // p.do();
    }
}
